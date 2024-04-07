package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * Este programa lee un archivo en el directorio que de ejecute, el nombre del archivo esta limitado a 8 caracteres
 * asi que será casi imposible consultar facilitando la ruta mas el nombre del fichero. Crea una carpeta 'loger' en C:\loger 
 * y dentro de ella un rachivo que almacena los registros de la actividad del programa.
 * 
 * 
 * */
public class Principal {
	
	
	private static Logger logger;

	public static void main(String[] args) {
		
		creaDirectorioyArchivo();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		validaUsuario(reader);
		String nombreFichero= obtenerNombreFichero(reader);
		visualizarFichero(nombreFichero);
		
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static void creaDirectorioyArchivo() {
		String directorioLogs="C:\\loger";
		String archivoLog="MyLogFile.log";
		
		File directorio = new File(directorioLogs);
		if(!directorio.exists()) {// crea el directorio si no existe
			
			directorio.mkdirs();
			
		}
		
		File archivo = new File(directorio,archivoLog);
		
		try {
			archivo.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		logger = Logger.getLogger("MyLog");//se crea el objeto logger
		try {
			FileHandler fh = new FileHandler("C:\\loger\\MyLogFile.log",true);//se redirige la salida de los registros a la ruta especificada
			logger.setUseParentHandlers(false);//para no usar el paternhandlers, no sacar por pantalla
			XMLFormatter farmatter = new XMLFormatter();
			fh.setFormatter(farmatter);//establezco al fileHandler el formato xml
			logger.setLevel(Level.ALL);
			logger.addHandler(fh);

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void visualizarFichero(String nombreFichero) {
		
		String linea;
		try(BufferedReader reader = new BufferedReader(new FileReader(nombreFichero))) {
			 System.out.println("Contenido del fichero '" + nombreFichero + "':");
	            while ((linea = reader.readLine()) != null) {
	                System.out.println(linea);
	            }
				logger.info("Fichero leido: " + nombreFichero);

		} catch (FileNotFoundException fe) {
			
			System.out.println("El fichero '" + nombreFichero + "' no se encuentra.");
			logger.info("Fichero no leido, no existe: " + nombreFichero);

			fe.printStackTrace();
		}catch (IOException e) {
			System.out.println("Error al leer el fichero '" + nombreFichero + "'.");
			logger.info("Error al leer el fichero: " + nombreFichero);

			e.printStackTrace();
		}
		
	}

	private static String obtenerNombreFichero(BufferedReader reader) {//metodo de clase
		
		String fichero;
		
		do {
			System.out.println("Introduce el nombre del fichero(máximo 8 caracteres) con la extensión: ");
			
			try {
				fichero= reader.readLine();
			} catch (IOException e) {
				
				fichero="";// para la condicion de while, en caso de que falle el string fichero este inicializado.
				e.printStackTrace();
			}
			
			if(fichero.matches("[a-zA-Z0-9]{1,8}\\.[aA-zZ]{3}")) {
				System.out.println("Formato del fichero correcto.");
				logger.info("Intento lectura del fichero: " + fichero);

			}else {
				System.out.println("Formato del fichero incorrecto.");
			}
			
		}while(!fichero.matches("[a-zA-Z0-9]{1,8}\\.[aA-zZ]{3}"));//se escapa con\\ para que no detecte el nunto como cualquier caracter, si no con el . como caracter en sí mismo. 

		return fichero;
	}

	private static void validaUsuario(BufferedReader reader) {//metodo de clase
		
		String usuario;
		do {
			System.out.println("Por favor, introduce tu nombre de usuario: ");
			
			try {
				usuario= reader.readLine();
			} catch (IOException e) {
				usuario="";// para la condicion de while, en caso de que falle el string usuario este inicializado.
				e.printStackTrace();
				
			}
			
			if(usuario.matches("[a-z]{8}")) {
				System.out.println("Usuario correcto.");
				logger.info("Usuario logeado: " + usuario);
			}else {
				System.out.println("Usuario incorrecto.");
			}
			
		}while(!usuario.matches("[a-z]{8}"));// mientras no haya match, repite.

		
	}
}