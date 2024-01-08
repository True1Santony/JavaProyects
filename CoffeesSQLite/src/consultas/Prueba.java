package consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 
 *<p>En la carpeta <b>lib</b> se encuentra el Driver.</p>
 *<a href="https://github.com/xerial/sqlite-jdbc/releases/tag/3.32.3.2>Enlace a JAR Driver SQLite>Jar de SQLite</a>
 *
 *@author espar
 *@version 1.0
 */
public class Prueba {

	public static void main(String[] args) {
		
		Cafes cafe=new Cafes();
		cafe.muestraDatosTabla();
		
		
		cafe.liberarRecursos();
		cafe.cerrarConexion();
		
		
	}

}
