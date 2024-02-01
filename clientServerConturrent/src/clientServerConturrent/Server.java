package clientServerConturrent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;


/**
 * Clase servidor implementa Runnable. Hace de proceso que lanza hilos de si mismo para cada cliente.
 * 
 */
public class Server implements Runnable{

	Socket cliente;

	
	/**
	 * Constructor de Server, requiere de un Socket clinete para asignar a cada 
	 * Server uno.
	 *
	 */
	public Server(Socket cliente) {
	
		this.cliente=cliente;

	}	
	
	/**
	 * @return int a
	 * Genera un entero de 0 a 99
	 */
	public int generaAleatorio() {
		
		var a=(int)(Math.random()*100);
		
		return a;
	}
	
	/**
	 * @param numeroUsuario el numero que recibe el server
	 * @param numeroAleatorio el numero que genera el server
	 * @param entrda objeto DataInputStream para futuras aplicaciones, no se usa.
	 * @param salida objeto DataOutputStream para generar respuesta al servidor.
	 * @return boolean para finalizar el bucle
	 */
	public boolean respuesta(int numeroUsuario, int numeroAleatorio, DataInputStream entrda, DataOutputStream salida) {
		boolean b=true;
		
			try {
				if(numeroUsuario == numeroAleatorio) {
					
				salida.writeUTF("Ha adividado el número");
				b=false;
		
				}else if(numeroUsuario > numeroAleatorio) {
				
				salida.writeUTF("El número es mayor que el que intenta averiguar");
				
				}else{
					
				salida.writeUTF("El número es menor que el que intenta averiguar");
					
				}
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
	}
			return b;
	}

	/**
	 *Método Run(), codigo que ejecutara cada hilo de Server.
	 *
	 *
	 */
	@Override
	public void run() {
		
		try{
	            InputStream entrada = cliente.getInputStream();
	            DataInputStream datosEntrada = new DataInputStream(entrada);
	            DataOutputStream datosSalida = new DataOutputStream(cliente.getOutputStream());
	            
	            int leido=datosEntrada.readInt();
	            
	            int a= generaAleatorio();
	        
	        	
	    		while(respuesta(leido,a, datosEntrada, datosSalida)) {
	    			leido=datosEntrada.readInt();
	    			}
	    		
	    		System.out.println("Cliente desconectado tras adivinar el número secreto. ");
	    		datosEntrada.close();
	    	    datosSalida.close();
	    	    cliente.close();
	    	    

	        }catch (SocketException se) {//para cuando cliente finalice la conexion antes de finalizar la ratea de adivinar el numero.
	            System.out.println("Cliente desconectado inesperadamente: " + se.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
	}
	
	/**
	 * @param arg
	 * Ejecución e hilo principal que se queda a la escucha por un puerto.
	 * Acepta conexiones de clientes en bucle infinito e instancia un thread de Server a cada cliente conectado.
	 */
	
	public static void main( String[] arg ) {
		
		try {
			ServerSocket server = new ServerSocket(2000);
			System.out.println("Escucho el puerto 2000");
			
			
			while(true) {
				
	            Socket clientIn = server.accept();
	            System.out.println("Cliente conectado");
			     Thread t= new Thread(new Server(clientIn));
			     t.start();
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}
}
