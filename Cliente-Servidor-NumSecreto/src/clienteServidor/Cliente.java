package clienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	static final String Host = "localhost";
    static final int Puerto=2000;
    
    public Cliente() {
    	try {
			Socket cliente =new Socket(Host,Puerto);
			
			OutputStream aux=cliente.getOutputStream();
			DataOutputStream salida=new DataOutputStream(aux);
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			
			while(true) {
				Scanner sc = new Scanner(System.in);
				System.out.print("Ingrese un número: ");
				int numeroUsuario=sc.nextInt();//controlar el error si no se introduce un int
				
				salida.writeInt(numeroUsuario);//enviamos al servidor el numero
				
				String respuesta = entrada.readUTF();
                System.out.println(respuesta);
                
                if (respuesta.equals("Ha adividado el número")) {
                    break;
                }
			}
			
		cliente.close();
		salida.close();
		entrada.close();
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	
	

	public static void main(String[] args) {
		
		Cliente cliente=new Cliente();

	}

}
