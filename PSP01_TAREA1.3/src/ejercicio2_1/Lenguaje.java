package ejercicio2_1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/**
 *  Esta aplicación escribe en un fichero indicado por el usuario conjuntos de letras generadas de forma aleatoria (sin sentido real).
 *  Escribiendo cada conjunto de letras en una línea distinta. 
 *  El número de conjuntos de letras a generar por el proceso, 
 *  también será dado por el usuario en el momento de su ejecución.
 *  Geastiona la concurrencia de posibles procesos de esta clase.
 * 
 * @author espartaco
 */

public class Lenguaje {

	/**
	 * @param args [0] Las lineas que se quiere generar 
	 * @param args [1] Nombre del fichero .txt
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String caracteres="abcdefghijklmnopqrstuvwxyz";
		String nomFichero;
		FileLock bloqueo;
		int lineas =40;
		
		
		if(args.length ==2 ) {//comprobamos si tenemos los 2 argumentos
			
			try {
				
				int temp = Integer.parseInt(args[0]);
				lineas=temp; // se evita duplicidad de variable por encapsulamiento en try/catch.
				
			} catch (NumberFormatException e) { // ejecucion por defecto si no se pasa un int como primer parametro
				
				System.out.println("No es un número entero, se haran por defecto 40 líneas");
				e.printStackTrace();
			}
			String osName = System.getProperty("os.name");
			
			if(osName.toUpperCase().contains("WIN")) {// en caso de windows, sustituye  \
				
				nomFichero=args[1].replace("\\","\\\\");
				
			}else {
				
				nomFichero=args[1];
			}
			
			File archivo =new File(nomFichero);
			
			if(!archivo.exists()) { //crea el fichro si no existe
				
				try {
					
					archivo.createNewFile();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			try {
				RandomAccessFile raf = new RandomAccessFile(archivo,"rwd");
				
				bloqueo = raf.getChannel().lock(); //empieza el bloqueo de raf para la creacion de lineas.
				
				raf.seek(archivo.length());//posicionamiento al final del archivo
				
				for (int i=0;i<lineas;i++) {// se van a generar las lineas que se pasaron por parametros
					
					int longitudString=(int)(Math.random()*50); 
					String linea="";
					
					for(int j=0;j<longitudString;j++) {
						
						linea += caracteres.charAt((int)(Math.random()*25));// escoge aleatoriamente un caracter de la cadena predefinida.
						
					}
					raf.writeChars(linea + "\n"); //se escribe el string generado con salto de linea al final.
				}
				
				bloqueo.release(); //se abre paso al siguiente raf
				bloqueo=null;
				raf.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else {
			System.out.println("Tiene que indicar, por parámetros, cuantos conjuntos de lentras quiere y el nombre de fichero que lo va a almacenar");
		}
	}

}
