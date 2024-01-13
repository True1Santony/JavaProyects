package clienteServidorPKg;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	
	static final String Host = "localhost";
    static final int Puerto=1500;
    private Socket cliente;
    private DataOutputStream salida;
    private DataInputStream entrada;
    Scanner sc;
    
    public Cliente() {
    	String linea="";
    	try {
    		cliente =new Socket(Host,Puerto);
			
			
			salida=new DataOutputStream(cliente.getOutputStream());
			entrada = new DataInputStream(cliente.getInputStream());
    		
				do {
	    		
				
					System.out.println("Ingrese el archivo que quiere consultar.");
					sc = new Scanner(System.in);
		
					String leidoRutaArchUsuario=sc.nextLine();
					
					salida.writeUTF(leidoRutaArchUsuario);
					
					//segunda condicion corregida, depurador, no se puede ejecutar readUTF seguido para evaluar misma linea!!!
						while(!(linea = entrada.readUTF()).equals("Archivo enviado.") && !linea.equals("No se pudo encontrar el archivo!!!!") ) {
							System.out.println(linea);
						}
						System.out.println(linea);
	    		}while(linea.equals("No se pudo encontrar el archivo!!!!"));
			
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

	public static void main(String[] args) {
	
		new Cliente();

	}

}
