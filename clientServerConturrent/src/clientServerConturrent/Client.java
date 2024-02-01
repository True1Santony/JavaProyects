package clientServerConturrent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


/**
 * Clase que lanza el proceso de cliente.
 * 
 */
public class Client {

	static final String Host = "localhost";
    static final int Puerto=2000;
    /**
	 * Constructor de Clinete.
	 * El programa se desarrola en él.
	 */
    public Client() {
    	try {
			Socket cliente =new Socket(Host,Puerto);
			
			OutputStream aux=cliente.getOutputStream();
			DataOutputStream salida=new DataOutputStream(aux);
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			Scanner sc = new Scanner(System.in);
			while(true) {//se ejecuta hasta caso if, break
				int numeroUsuario;
				while (true) {//comprueba que sea in int
                    System.out.print("Ingrese un número: ");
                    if (sc.hasNextInt()) {
                        numeroUsuario = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Por favor, introduzca un número entero válido.");
                        sc.next(); // Limpia el buffer del scanner
                    }
                }
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
	
	
	
	
    /**
	 * @param arg
	 * Ejecución
	 */
	public static void main(String[] args) {
		
		Client cliente=new Client();

	}

	
}
