import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQSequence;


import net.xqj.exist.ExistXQDataSource;

/**
 * Método main que ejecuta el programa. Hace una conexión a la DDBB de eXist y realiza una consulta sobre el menu.xml en funcion del Id del menu,
 * calcula la cantidad de ingredientes en función del numero de comensales.
 * @author espar
 * @version 1.0
 */
public class Main {
	
	private static final String PORT = "8080";
	private static final String HOST = "localhost";
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		XQDataSource xqdataSource = new ExistXQDataSource();
		
		try {
			xqdataSource.setProperty("serverName",HOST);
			xqdataSource.setProperty("port",PORT);

			XQConnection conexion = xqdataSource.getConnection("admin","admin");
			
			System.out.println("Conexion establecida.");

				do {
					
				}while(solicitaDatosMenu(conexion));
				
			scanner.close();	
				
			conexion.close();
			
			System.out.println("Conexion finalizada.");

		} catch (XQException e) {

			System.out.println("no se pudo establecer la conexión.");
			e.printStackTrace();
		}
	}
/**
 * Método para solicitar los datos al usuario y validarlos.
 * Si los datos son correctos llama al metodo <b>muestraListaCompra().</b>
 * Mientras esté en true se solicitan datos en bucle.
 * */
	private static boolean solicitaDatosMenu(XQConnection conexion) {
		
		boolean finBuclePrograma=true;
		String idMenu, numeroComensales;
		
		
		System.out.println("Facilite el ID del Menú: ");
		idMenu=scanner.nextLine();
		
		Pattern pattern = Pattern.compile("\\b[1-8]\\b");//se permite de 1 a 8.
        Matcher matcher = pattern.matcher(idMenu);
        
        if(matcher.find()) {//hay coincidencia 
            System.out.println("Coincidencia encontrada: " + matcher.group());
            
    		System.out.println("Facilite el número de comensales:  ");
    		numeroComensales=scanner.nextLine();
    		pattern = Pattern.compile("\\b([1-9][0-9]{0,2})\\b");//un limite de 1 a 999 comensales
    		matcher = pattern.matcher(numeroComensales);
    		
    		if(matcher.find()) {//obtengo los dos datos del usuario, todo trabajo de consulta aqui.
    			
    			muestraListaCompra(conexion,idMenu,numeroComensales);
    			
    			System.out.println("Quiere continuar consultando, si o no :(Y/N)");
    			
    			String opcion=scanner.nextLine();
    			
    			if(opcion.equalsIgnoreCase("n")) { //sale del programa si se pulsa "n"
    				finBuclePrograma=false;
    				
    			}
    			
    		}else {
    			
            	System.out.println("Dato no válido. Ponga un numero entero de comensales.");

    		}
        
        }else {
        	System.out.println("Puede escoger de 1 a 8.");
        }
        
        
		return finBuclePrograma;
	}

	/**
	 * Método que ejecuta la query predefinida con los datos del usuario. 
	 * 
	 * @param conexion XQConnection objeto del metodo main
	 * @param idMenu String con el número del menú a consultar
	 * @param numeroComensales String número de Comensales
	 */
	private static void muestraListaCompra(XQConnection conexion,String idMenu,String numeroComensales) {
		
		XQConnection conexionInterna=conexion;
		
		String query = "let $menu := //menu[@id =\"" + idMenu + "\"] "
				+ " return "
				+ "<menu id=\"{$menu/@id}\"> {"
				+ "    for $plato in $menu/plato "
				+ "    return "
				+ "    <plato tipo=\"{$plato/@tipo}\">"
				+ "        <nombre>{$plato/nombre}</nombre>"
				+ "        {"
				+ "            for $ingrediente in $plato/ingrediente "
				+ "            return "
				+ "            <ingrediente nombre=\"{$ingrediente/@nombre}\">"
				+ "                <cantidad>{number($ingrediente/cantidad) * " + numeroComensales + "}</cantidad>"
				+ "            </ingrediente>"
				+ "        }"
				+ "    </plato>"
				+ "} </menu>";

		
		
		try {
			XQPreparedExpression expr = conexionInterna.prepareExpression(query);
			XQSequence result = expr.executeQuery();
			System.out.println(result.getSequenceAsString(null));
			
			result.close();
			expr.close();
			
		} catch (XQException e) {
			
			System.err.println("Consulta erronea!!");
			e.printStackTrace();
			
		}
 		
	}

}
