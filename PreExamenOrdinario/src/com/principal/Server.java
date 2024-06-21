package com.principal;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.concurrent.Semaphore;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Server implements Runnable {
	
	private static final int PORT=1500; 
	private static final int MAX_CLIENTES = 5;
	private static final Semaphore semaphore = new Semaphore(MAX_CLIENTES, true);
	private static final Logger logger = Logger.getLogger("MyLog");
	
	private Socket cliente;
	private DataInputStream datosEntrada;
	private DataOutputStream datosSalida;
	private int idCliente;
	private SecretKey secretKey;
	
	
	public Server(Socket clinete, int idCliente) {
		
		this.cliente=clinete;
		this.idCliente=idCliente;
		inicializaLog();
		
	}

	public static void main(String[] args) {
		
		int idClientes = 1;
		
		try {
			
			ServerSocket server= new ServerSocket(PORT);
			
			while(true) {
				
				try {
					
					Socket clienteNuevo = new Socket();

					clienteNuevo=server.accept();
					
					Thread clienteAtendido = new Thread(new Server(clienteNuevo, idClientes));
					clienteAtendido.start();
					
					idClientes++;
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void run() {
		
		System.out.println("Server UP:");

		boolean repite= false;
		
		try {
			do {
				if(semaphore.tryAcquire()) {

					datosEntrada = new DataInputStream(cliente.getInputStream());
					datosSalida = new DataOutputStream(cliente.getOutputStream());
					
					

					datosSalida.writeUTF("Atendiendo al clinete " + idCliente);//le dice al clinete que esta atendiendolo
					System.out.println("Atendientdo al clinete: "+ idCliente);
					
					log("se ha atendido al cliente: "+idCliente);
					
					//recibe la ruta
					File archivoConsultar= new File(datosEntrada.readUTF());
					
					if(archivoConsultar.exists()) {
						
						//envia el archivo
						BufferedReader reader = new BufferedReader(new FileReader(archivoConsultar));
						String linea;
						while((linea=reader.readLine())!=null) {
							
							datosSalida.writeUTF(linea);
							
						}
						
						datosSalida.writeUTF("FIN ENVIO");//MARCADOR FIN ENVIO
						System.out.println("Archivo enviado");

						
							//termina de enviar el archivo y espera en envio del clinete
							if (datosEntrada.readUTF().equalsIgnoreCase("si")) {
								
								encriptaArchivo(archivoConsultar);
								
								
								datosSalida.writeUTF("Encriptado");
								System.out.println("encriptado");

	
								
							}else {
								
								datosSalida.writeUTF("no encriptado");
								System.out.println("no se encripta");

								
							}
						
					}else {
						//envia que no existe el archivo
						datosSalida.writeUTF("NO EXISTE");//MARCADOR NO ENCUENTRA EL ARCHIVO
						System.out.println("No se ha podido leer el archivo porque no existe.");

					}
					
					
					
					Thread.sleep(10000);

					semaphore.release();
					System.out.println("Server se libera, ha termindao!!! ");

					repite=false;
				}else {
					
					datosSalida = new DataOutputStream(cliente.getOutputStream());
					datosSalida.writeUTF("Se ha superado el maximo de conexiones");

					System.out.println("Server no conectado, superado en numero de conexiones");

					repite=true;
					Thread.sleep(10000);
				}
			}while(repite);
		
		}catch(SocketException se) {
			
			System.err.println("El cliente se ha deconectado "+ se);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(datosEntrada!=null) {datosEntrada.close();}
				if(datosSalida!=null) {datosSalida.close();}
				if(cliente !=null) {cliente.close();}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
	}

	private void inicializaLog() {
		
		try {
			
			//el nombre del archivo log y que no se sobreescibe 
			FileHandler fileHandler = new FileHandler("LogArchivo.log",true);
			//logger.setUseParentHandlers(false);
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
			
			logger.setLevel(Level.ALL);
			
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Aunque es Thread-safe, impemento sincronizacion de escritura
	 * 
	 * @param mensaje
	 */
	private synchronized void log(String mensaje) {
		
		logger.log(Level.INFO, mensaje);
		
	}

	private void encriptaArchivo(File archivoConsultar) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
		
		secretKey = generaKey();
		
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		BufferedReader reader =new BufferedReader(new FileReader(archivoConsultar));
		StringBuilder stringBuilder = new StringBuilder();
		String linea;
		while((linea=reader.readLine())!=null) {
			
			stringBuilder.append(linea).append("\n");
			
		}
		
		reader.close();
		
		byte[] plainTextBytes = stringBuilder.toString().getBytes();

        // Cifrar el contenido
        byte[] encryptedBytes = cipher.doFinal(plainTextBytes);
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        // Imprimir o guardar el contenido cifrado
        System.out.println("Contenido cifrado: " + encryptedText);
		
	}

	private SecretKey generaKey() {
		SecretKey secretKey=null;
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("AES");
			keyGen.init(256);
			secretKey=keyGen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return secretKey;
	}

}
