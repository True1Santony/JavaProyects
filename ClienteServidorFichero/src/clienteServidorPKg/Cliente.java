package clienteServidorPKg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	
	static final String Host = "localhost";
    static final int Puerto=1500;
	
    
    public Cliente() {
    	
    	try {
			Socket cliente =new Socket(Host,Puerto);
			
			OutputStream aux=cliente.getOutputStream();
			DataOutputStream salida=new DataOutputStream(aux);
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Ingrese el archivo que quiere consultar.");
			
			String leidoRutaArchUsuario=sc.nextLine();
			
			
			
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
