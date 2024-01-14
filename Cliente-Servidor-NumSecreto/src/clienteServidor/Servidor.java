package clienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;

/**<h1>Servidor</h1>
 * <p>Clase con metodo main que publica el puerto <b>2000</b>, genera un número aleatorio
 *   y espera que un cliente lo adivine. Una vez adivinado se cierra. </p>
 * @author espar
 * @version 1.0
 */
public class Servidor {

	
	/**
	 * Constructor de Servidor.
	 * El programa se desarrola en él.
	 */
	public Servidor() {
	
		
	try{
            ServerSocket server = new ServerSocket(2000);
            Socket cliente = server.accept();

            InputStream entrada = cliente.getInputStream();
            DataInputStream datosEntrada = new DataInputStream(entrada);
            DataOutputStream datosSalida = new DataOutputStream(cliente.getOutputStream());
            
            int leido=datosEntrada.readInt();
            
            int a= generaAleatorio();
            
            
        	
    		while(respuesta(leido,a, datosEntrada, datosSalida)) {
    			leido=datosEntrada.readInt();
    			}
    		
    		
    		entrada.close();
    	    datosSalida.close();
    	    cliente.close();
    	    server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
	
	}	
	
	/**
	 * @return int a
	 * Genera un entero de 0 a 99
	 */
	public int generaAleatorio() {
		
		int a=(int)(Math.random()*100);
		
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
	 * @param arg
	 * Ejecución
	 */
	public static void main( String[] arg ) {
    
     new Servidor();
	}
	
}

