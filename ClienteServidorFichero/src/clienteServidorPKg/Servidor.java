package clienteServidorPKg;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**<h1>Servidor</h1>
 * <p>Clase con metodo main que publica el puerto <b>1500</b>, espera la ruta de un archivo válido
 * si lo obtiene manda linea a linea su contenido, si no, devuelve un mensaje de error y se queda a la 
 * escucha de nuevo. </p>
 * @author espar
 * @version 1.0
 */
public class Servidor {
	
	private DataInputStream datosEntrada;
	private DataOutputStream datosSalida;
	private ServerSocket server;
	private Socket cliente;
	
	/**
	 * Constructor de Servidor.
	 * El programa se desarrola en él.
	 */
	public Servidor() {
	
		
			
			try {
				server = new ServerSocket(1500);
				cliente = server.accept();
				 
		            datosEntrada = new DataInputStream(cliente.getInputStream());// obtengo el input del socket
		            datosSalida = new DataOutputStream(cliente.getOutputStream());//obtengo el output del socket
		     while (true) {
		        	   String leido=datosEntrada.readUTF(); //se lee el string recibido, el nombre del archivo.
		            
		            File file =new File(leido);
		     if(file.exists()&& file.isFile()) {//si el file existe y la ruta es correcta
		           
		    	 BufferedReader buffReader = new BufferedReader(new FileReader(leido));
		            
		            String linea;
		            while((linea= buffReader.readLine()) !=null) {
		            	
		            	datosSalida.writeUTF(linea);//se envia la linea
		            	//StringBuilder mas el metodo .append con mejor rendimieno en caso de archivos grandes.
		            }
		            datosSalida.writeUTF("Archivo enviado.");//marcador fin envio para el clinete
		            System.out.println("Archivo enviado.");
		            cerrarTodo();
		            break;//salir del bucle si se ha enviado
			}else {
	            System.out.println("No se pudo encontrar el archivo!!!!");

				datosSalida.writeUTF("No se pudo encontrar el archivo!!!!");
				}
			}
		            
		            
		            
		            
			} catch (FileNotFoundException e) {
				try {
					datosSalida.writeUTF("error de file");
					
					
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				e.printStackTrace();
			} catch (IOException e) {
			    e.printStackTrace();
			    
			}
    

}
	
	/**
	 * Método para cerrar todas las comunicaciones y lectura/escritura
	 */
	public void cerrarTodo() {
		try {
			server.close();
			cliente.close();
	        datosSalida.close();
	        datosEntrada.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	/**
	 * @param arg
	 * Ejecución
	 */
public static void main(String[] args) {
		
		new Servidor();
	}
}
