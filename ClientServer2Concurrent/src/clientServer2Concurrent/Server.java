package clientServer2Concurrent;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
	
	private DataInputStream inData;
	private DataOutputStream outData;
	private ServerSocket server;
	private Socket client;
	private static final int PORT=1500;
	
	
	public Server(Socket client) {
		
		this.client=client;
		
	}
	
	

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

	@Override
	public void run() {
		
		try {
			
			inData = new DataInputStream(client.getInputStream());
			outData = new DataOutputStream(client.getOutputStream());
			
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
					
					break;//salida del while(true)
						
						
					
				}else {
					
					System.out.println("No se pudo encontrar el archivo!!!!");
					
					outData.writeUTF("No se pudo encontrar el archivo!!!!");
					
				}
			}
			
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
