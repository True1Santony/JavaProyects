package clientServer2Concurrent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



/**
 * Clase que lanza el proceso de cliente.
 * 
 */
public class Client {
		
		static final String Host = "localhost";
	    static final int Puerto=1500;
	    private Socket cliente;
	    private DataOutputStream salida;
	    private DataInputStream entrada;
	    private Scanner sc;
	    /**
	   	 * Constructor de Clinete.
	   	 * El programa se desarrola en él.
	   	 */
	    public Client() {
	    	String linea="";
	    	try {
	    		cliente =new Socket(Host,Puerto);
				
				
				salida=new DataOutputStream(cliente.getOutputStream());
				entrada = new DataInputStream(cliente.getInputStream());
	    		
					do {
		    		
					
						System.out.println("Ingrese el archivo que quiere consultar con extensión");
						sc = new Scanner(System.in);
			
						String leidoRutaArchUsuario=sc.nextLine();
						
						salida.writeUTF(leidoRutaArchUsuario);
						
						    //buble para imprimir el texto del archivo, no entrará en él si el server no envia el texto del file.
							//imprime por pantalla mientras no sea condicionString1 y no sea condicionString2
							while(!(linea = entrada.readUTF()).equals("Archivo enviado.") && !linea.equals("No se pudo encontrar el archivo!!!!") ) {
								System.out.println(linea);
							}
							System.out.println(linea);//imprime la ultima linea enviada del server, que es la causante del fin del while.
							
		    		}while(linea.equals("No se pudo encontrar el archivo!!!!"));//se va a ejecutar minetras el servidor no encuentre el archivo
				
	    		sc.close();
	            cliente.close();
	            salida.close();
	            entrada.close();
				
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		
			new Client();

		}


	

}
