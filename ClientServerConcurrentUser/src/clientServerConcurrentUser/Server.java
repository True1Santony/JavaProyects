package clientServerConcurrentUser;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Clase servidor implementa Runnable. Hace de proceso que lanza hilos de si mismo para cada cliente.
 * @author espar
 * @version 1.0
 */
public class Server implements Runnable {

	private DataInputStream inData;
	private DataOutputStream outData;
	private Socket client;
	private static final int PORT=1500;
	
	
	/**
	 * Constructor de Server, agrega a un cliente. 
	 * @param client socket que genera el servidor al aceptar un cliente
	 */
	public Server(Socket client) {
		
		this.client=client;
		
	}
	
	

	/**
	 * 
	 * Comienzo del programa, hilo principal.
	 * @param args
	 */
	public static void main(String[] args) {
		
		try (ServerSocket sSocket = new ServerSocket(PORT)) {
			
			while(true) {
				
				Socket cSocket=sSocket.accept();
				
				Thread newServer=new Thread(new Server(cSocket));//lanzo un thread para un clinete aceptado
				
				newServer.start();
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	/**
	 *Metodo run un hilo servidor, la logica esta en él.
	 */
	@Override
	public void run() {
		
		try {
			
			inData = new DataInputStream(client.getInputStream());
			outData = new DataOutputStream(client.getOutputStream());
			
			String userPass;
			do{	
				//nuevo para este ejercicio.
				userPass=inData.readUTF();
				
				if(userPass.equalsIgnoreCase("javiersecreta")) {//2. se validan los datos del usuario
					
					outData.writeUTF("Escoja una opción:\n 1. Mostrar el contenido del directorio.\n 2. Mostrar contenido del archivo. ");//3. envio de opciones
					//outData.flush();
					System.out.println("Usuario logeado");
					boolean ok=true;
					
					String opcion;
					do {
					
					opcion=inData.readUTF();
					
					
						
							switch(opcion) {
						
						
							case "1":
								String rutaDirectorioRaiz = System.getProperty("user.dir");
								File directorioAmostrar = new File(rutaDirectorioRaiz);
								
								File[] archivos = directorioAmostrar.listFiles();
								
								for(File a:archivos) {
									
									if(a.getName().endsWith(".txt")) {//lista solo los archivos txt
										
										outData.writeBoolean(false);//no finaliza el envio.
										outData.writeUTF(a.getName().toString());
										
									}
									
								}
								outData.writeBoolean(false);
								outData.writeUTF("Escoja una opción:\n 1. Mostrar el contenido del directorio.\n 2. Mostrar contenido del archivo. ");
								outData.flush();
								outData.writeBoolean(true);//marcador fin de envio
								ok=true;
								break;
								
							case "2":
								
								while(true) {
								
								String readed= inData.readUTF();//lee lo recibido del cliente
								
								
								File file = new File(readed);
								
								if(file.exists() && file.isFile()) {// si el file existe y la ruta es correcta entra en el if
									
									try (BufferedReader buffRead = new BufferedReader(new FileReader(readed))) {
										String line;
										
											while((line=buffRead.readLine()) != null) {
												
												outData.writeUTF(line);//se envia o se agrega al buffer de envio
												
											}
									}
									
									outData.writeUTF("Archivo enviado.");//marcador fin bucle cliente
									outData.flush();//vaciado de buffer y forzando el envio.
									
									System.out.println("Archivo enviado.");//notificacion para el server
									
									cerrarTodo();
									ok=false;//salida del bucle menu
									System.out.println("Clinete desconectado.");
									return;//salida del hilo
									//break;//salida del while(true)
										
										
									
								}else {
									
									System.out.println("No se pudo encontrar el archivo!!!!");
									
									outData.writeUTF("No se pudo encontrar el archivo!!!!");
									ok=true;
									
								}
								break;
								
							}
								break;
								
							default:
								
								
								System.out.println("opcion escogina no válida");
								outData.writeUTF("opcion escogina no válida \nEscoja una opción:\n 1. Mostrar el contenido del directorio.\n 2. Mostrar contenido del archivo.");//3. envio de opciones
								
								ok=true;
								break;
						}
					}while(ok);
					
					
					
				}else {
					
					System.out.println("Usuario erroneo");
					outData.writeUTF("Usuario erroneo");
					
				}
				}while(!userPass.equalsIgnoreCase("javiersecreta"));
				
			
		}catch (java.net.SocketException e) {// en el caso de que un clinete se desconecte de manera repentina
	        
	        System.out.println("Cliente desconectado.");
	        e.printStackTrace();
	        
		}catch (FileNotFoundException e) {//catch de menor nivel para fallo file
			
			try {
				outData.writeUTF("error de file");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		} catch (IOException e) {// catch general
			e.printStackTrace();
		}
		
	}



	/**
	 * Metodo que cierra las comunicaciones del hilo servidor.
	 */
	private void cerrarTodo() {
		
		
		try {
			
			inData.close();
			outData.close();
			//server.close();
			client.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	
}
