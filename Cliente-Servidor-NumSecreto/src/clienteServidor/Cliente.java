package clienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


/**<h1>Clinete</h1>
 * <p>Clase con metodo main que intenta conectarse a traves del puerto <b>2000</b>, solicita al usuario 
 * un numero entero. Una vez adivinado se cierra. </p>
 * @author espar
 * @version 1.0
 */
public class Cliente {
	
	static final String Host = "localhost";
    static final int Puerto=2000;
    /**
	 * Constructor de Clinete.
	 * El programa se desarrola en él.
	 */
    public Cliente() {
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
		
		Cliente cliente=new Cliente();

	}

}
