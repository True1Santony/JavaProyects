import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.System.Logger;
import java.util.logging.Level;

public class lector_texto {

	public static void main(String[] args) {
		
		FileInputStream fichero;
		try {
		     // Elegimos fichero para leer flujos de bytes "crudos"
		 fichero = new FileInputStream("c:\\texto.txt");
		     // InputStreamReader sirve de puente de flujos de byte a caracteres
		 InputStreamReader unReader = new InputStreamReader(fichero);
		     // Vemos la codificación actual
		 System.out.println(unReader.getEncoding());
		} catch (FileNotFoundException ex) {
		   
		}

	}

}
