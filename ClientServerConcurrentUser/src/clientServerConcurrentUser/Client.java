package clientServerConcurrentUser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


/**
 * Clase que lanza el proceso de cliente.
 * @author espar
 * @version 1.0
 */
public class Client {

	static final String Host = "localhost";
    static final int Puerto=1500;
    private Socket cliente;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private Scanner sc;
    private String usuarioContrasen;
    private boolean logeado=false;
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
			sc = new Scanner(System.in);
			String respuestaServer1="";
			
    		boolean condicion =true;
				do {
	    		
						//nuevo, para este ejercicio.
							if(!logeado) {
								do{
								solicitaUserPass();//1.pide los datos del usuario y envia un strig al server
							
								respuestaServer1 =entrada.readUTF();
								System.out.println(respuestaServer1);//4. se escoje la opcion o error de usuario y/o pass
								

								}while(respuestaServer1.equals("Usuario erroneo"));//mientras sean erroneos el usuario y pass, los volvera a pedir.
					
					
						logeado=true;//no entra mas al logueo
						
						String opcion;
						do {
							opcion=sc.nextLine();
							
							if(opcion.equals("2")) {
								
								salida.writeUTF(opcion);//se lo manda
								
								System.out.println("Ingrese el archivo que quiere consultar con extensión");
								
								String leidoRutaArchUsuario=sc.nextLine();
								
								salida.writeUTF(leidoRutaArchUsuario);
								
								    //buble para imprimir el texto del archivo, no entrará en él si el server no envia el texto del file.
									//imprime por pantalla mientras no sea condicionString1 y no sea condicionString2
									while(!(linea = entrada.readUTF()).equals("Archivo enviado.") && !linea.equals("No se pudo encontrar el archivo!!!!") ) {
										System.out.println(linea);
									}
									System.out.println(linea);//imprime la ultima linea enviada del server, que es la causante del fin del while.
									
										if( linea.equals("No se pudo encontrar el archivo!!!!")) {
											
											System.out.println("Escoja una opción:\n 1. Mostrar el contenido del directorio.\n 2. Mostrar contenido del archivo.");
											
										}
									condicion=false;
								
							}else if(opcion.equals("1")) {
							//escoge la opcion que da el servidor
							salida.writeUTF(opcion);//se lo manda
							//opcion=entrada.readUTF();//leo la respuesta del server a la opcion dada, error es boolean de entrada
							
							while(opcion.equalsIgnoreCase("opcion escogina no válida \nEscoja una opción:\n 1. Mostrar el contenido del directorio.\n 2. Mostrar contenido del archivo.")) {
								
								System.out.println(opcion);
								opcion=sc.nextLine();
								salida.writeUTF(opcion);
								
							}
							
							while(!entrada.readBoolean()) {// se sale tras mostrar contenido del directorio
								
								opcion=entrada.readUTF();
								System.out.println(opcion);
								
							}
							}else {
								
								salida.writeUTF(opcion);//se lo manda
								System.out.println(entrada.readUTF());
								condicion=true;
								
							}
						
						}while(opcion.equals("Escoja una opción:\n 1. Mostrar el contenido del directorio.\n 2. Mostrar contenido del archivo. ") || linea.equals("No se pudo encontrar el archivo!!!!") || condicion);	
				}	
				//////////////////////////////////////////////////////////////////////
					
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
	 * Solicita una contraseña y usuario, luego los envia al servidor.
	 */
	public void solicitaUserPass() {
		
		System.out.println("Ingrese el usuario:");
		usuarioContrasen=sc.nextLine();
		
		
		System.out.println("Ingrese la contraseña:");
		usuarioContrasen+=sc.nextLine();
		
		try {
			
			salida.writeUTF(usuarioContrasen);
			
		} catch (IOException e) {
			
			System.out.println("Error al enviar usuario u contraseña");
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
