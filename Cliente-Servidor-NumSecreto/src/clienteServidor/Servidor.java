package clienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;

public class Servidor {

	
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
	
	public int generaAleatorio() {
		
		int a=(int)(Math.random()*100);
		
		return a;
	}
	
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
	
	public static void main( String[] arg ) {
    
     new Servidor();
	}
	
}

