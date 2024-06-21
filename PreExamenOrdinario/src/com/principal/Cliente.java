package com.principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Cliente {

	private static final int PORT=1500;
	private static final String HOST="localhost";
	private DataInputStream datosEntrada;
	private DataOutputStream datosSalida;
	private Scanner entradaConsola;
    private Socket clienteSocket;

	
	public Cliente() {
		
		String respuestaDelServer, envioAlServer;
		
		try {
					
				Socket clienteSocket = new Socket(HOST,PORT);
				
				datosEntrada= new DataInputStream(clienteSocket.getInputStream());
				datosSalida = new DataOutputStream(clienteSocket.getOutputStream());
				
				//pideUserPass();
				
				
				do {
					respuestaDelServer = datosEntrada.readUTF();//contesta que esta atendiendo
					System.out.println(respuestaDelServer);
					
					
				
				}while(respuestaDelServer.equalsIgnoreCase("Se ha superado el maximo de conexiones"));
				
				envioAlServer=pideArchivo();
				//envia al server la ruta
				datosSalida.writeUTF(envioAlServer);
				
				do {
					
					respuestaDelServer=datosEntrada.readUTF();
					System.out.println(respuestaDelServer);
					
				}while(!respuestaDelServer.equals("FIN ENVIO") && !respuestaDelServer.equals("NO EXISTE"));
				
					if(respuestaDelServer.equals("FIN ENVIO")) {System.out.println("¿Quieres encriptarlo? si/no :" );
					
					String preguntaEncriptar=entradaConsola.nextLine();
					
						if(preguntaEncriptar.equalsIgnoreCase("si")) {
							
							datosSalida.writeUTF(preguntaEncriptar);
							System.out.println(datosEntrada.readUTF());

							
						}else {
							
							datosSalida.writeUTF("no");
							System.out.println(datosEntrada.readUTF());

						}
					}
				
				
			}catch (IOException e) {
				
				System.err.println("Error de conexion con el servidor "+ e);
				
			}finally {
			
				try {
					if(datosEntrada !=null)datosEntrada.close();
					if(datosSalida !=null)datosSalida.close();
					if(entradaConsola !=null)entradaConsola.close();
					if(clienteSocket!=null)clienteSocket.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
	}
		
	
	
	
	
	private String pideArchivo() {
		
		entradaConsola= new Scanner(System.in);
		String archivo="";
		System.out.println("Facilite el archivo que quiere consultar:");
		archivo=entradaConsola.nextLine();
		
		return archivo;

	}





	private String pideUserPass() {
		
		boolean validado= false; 
		
		entradaConsola= new Scanner(System.in);
		String usuario="";
		
		
		while (!validado) {
			
			System.out.println("Facilite el usuario:");
			
			usuario=entradaConsola.nextLine();
			
			if(usuario.matches("[a-zA-Z]{8}")) {
				
				validado= true;
				
				System.out.println("Usuario valido");
				
			}else {
				
				System.out.println("Usuario no valido, tiene que tener 8 caracteres");

			}
		}
		return usuario;
	}





	public static void main(String[] args) {
		
		new Cliente();

	}
}