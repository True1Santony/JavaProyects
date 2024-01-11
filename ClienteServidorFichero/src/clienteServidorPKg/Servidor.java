package clienteServidorPKg;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	
	
	public Servidor() {
	
		DataOutputStream datosSalida=null;
			
			try {
				ServerSocket server = new ServerSocket(1500);
				Socket cliente = server.accept();
				 InputStream entrada = cliente.getInputStream();
		            DataInputStream datosEntrada = new DataInputStream(entrada);
		            datosSalida = new DataOutputStream(cliente.getOutputStream());
		            String leido=datosEntrada.readUTF();
		            
		            File file =new File(leido);
		            FileReader reader = new FileReader(file);
		            BufferedReader buffReader = new BufferedReader(reader);
		            
		            String todo=null;
		            String linea;
		            while((linea=buffReader.readLine()) != null) {
		            	todo+=linea;
		            	//StringBuilder mas el metodo .append con mejor rendimieno en caso de archivos grandes.
		            }
		            
		            datosSalida.writeUTF(todo);
		            
			} catch (FileNotFoundException e) {
				try {
					datosSalida.writeUTF("No se pudo encontrar el archivo!!!!");
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				e.printStackTrace();
			} catch (IOException e) {
			    e.printStackTrace();
			    
			}
    

}
	
public static void main(String[] args) {
		
		new Servidor();
	}
}
