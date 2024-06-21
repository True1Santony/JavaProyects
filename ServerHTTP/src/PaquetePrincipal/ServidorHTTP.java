package PaquetePrincipal;

import java.io.BufferedReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

/**
 * *****************************************************************************
 * Servidor HTTP que atiende peticiones de tipo 'GET' recibidas por el puerto 
 * 8066
 *
 * NOTA: para probar este código, comprueba primero de que no tienes ningún otro
 * servicio por el puerto 8066 (por ejemplo, con el comando 'netstat' si estás
 * utilizando Windows)
 *
 * @author IMCG
 */
class ServidorHTTP implements Runnable{

	public ServidorHTTP(Socket socCliente, int idCliente) {
		super();
		this.socCliente = socCliente;
		this.idCliente = idCliente;
	}

	private Socket socCliente;
	private int idCliente;
	
	
  /**
   * **************************************************************************
   * procedimiento principal que asigna a cada petición entrante un socket 
   * cliente, por donde se enviará la respuesta una vez procesada 
   *
   * @param args the command line arguments
   */
  public static void main(String[] args)  {

	  try {
	        ServerSocket socServidor = new ServerSocket(8066);
	        imprimeDisponible();

	        int contadorClientes=1;
	        while (true) {
	            Socket socCliente = socServidor.accept();
	            
	            Thread hilo = new Thread(new ServidorHTTP(socCliente, contadorClientes));
	            hilo.start();
	            contadorClientes++;
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
  

  /**
   *****************************************************************************
   * procesa la petición recibida
   *
   * @throws IOException
   */
  private static void procesaPeticion(Socket socketCliente)  {
    //variables locales
    String peticion;
    String html;

    //Flujo de entrada
    InputStreamReader inSR;
	try {
		inSR = new InputStreamReader(
		        socketCliente.getInputStream());
	
    //espacio en memoria para la entrada de peticiones
    BufferedReader bufLeer = new BufferedReader(inSR);

    //objeto de java.io que entre otras características, permite escribir 
    //'línea a línea' en un flujo de salida
    PrintWriter printWriter = new PrintWriter(
            socketCliente.getOutputStream(), true);

   /* List <String> peticiones=new ArrayList<String>();//Parte solo para ver que es lo que envia el clinete al servidor
    while((peticion = bufLeer.readLine()) != null) {
    	peticiones.add(peticion);
    	
    	if(peticion.contains("Accept-Language")) {
    		break;
    	}
    }
    for(String ar:peticiones) {
    	System.out.println(ar);
    }*/
    //mensaje petición cliente
    peticion = bufLeer.readLine();//aqui puede haber mas de una linea

    //para compactar la petición y facilitar así su análisis, suprimimos todos 
    //los espacios en blanco que contenga
    //peticion = peticiones.get(0).replaceAll(" ", "");//esto es por si se usa con el foreach del array del clinete
    
    peticion = peticion.replaceAll(" ", "");

    //si realmente se trata de una petición 'GET' (que es la única que vamos a
    //implementar en nuestro Servidor)
    
      if (peticion.startsWith("GET")) {
		      //extrae la subcadena entre 'GET' y 'HTTP/1.1'
		      peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));
		
		      //si corresponde a la página de inicio
		      if (peticion.length() == 0 || peticion.equals("/")) {
		        //sirve la página
		        html = Paginas.html_index;
		        printWriter.println(Mensajes.lineaInicial_OK);//respuesta para el cliente
		        printWriter.println(Paginas.primeraCabecera);//Content-Type
		        printWriter.println("Content-Length: " + html.length() + 1);//Content-Length
		        printWriter.println(daFecha());//Date
		        printWriter.println("\n");// salto de linea
		        printWriter.println(html);
		      } //si corresponde a la página del Quijote
		      else if (peticion.equals("/quijote")) {
		        //sirve la página
		        html = Paginas.html_quijote;
		        printWriter.println(Mensajes.lineaInicial_OK);
		        printWriter.println(Paginas.primeraCabecera);
		        printWriter.println("Content-Length: " + html.length() + 1);
		        printWriter.println(daFecha());//Date
		        printWriter.println("\n");
		        printWriter.println(html);
		      } //en cualquier otro caso
		      else {
		        //sirve la página
		        html = Paginas.html_noEncontrado;
		        printWriter.println(Mensajes.lineaInicial_NotFound);
		        printWriter.println(Paginas.primeraCabecera);
		        printWriter.println("Content-Length: " + html.length() + 1);
		        printWriter.println(daFecha());//Date
		        printWriter.println("\n");
		        printWriter.println(html);
		      }
		    
		    }
	} catch (NullPointerException e) {//Cannot invoke "String.replaceAll(String, String)" because "peticion" is null
		System.out.println("Se cerró el navegador");
		e.printStackTrace();
	}catch (IOException e) {//genérica
		e.printStackTrace();
	}
  }

  /**
   * **************************************************************************
   * muestra un mensaje en la Salida que confirma el arranque, y da algunas
   * indicaciones posteriores
   */
  private static void imprimeDisponible() {

    System.out.println("El Servidor WEB se está ejecutando y permanece a la "
            + "escucha por el puerto 8066.\nEscribe en la barra de direcciones "
            + "de tu explorador preferido:\n\nhttp://localhost:8066\npara "
            + "solicitar la página de bienvenida\n\nhttp://localhost:8066/"
            + "quijote\n para solicitar una página del Quijote,\n\nhttp://"
            + "localhost:8066/q\n para simular un error");
  }
  
  private static String daFecha() {
	
	  Date fechaActual = new Date();//fecha
	  SimpleDateFormat formatoFechaHTTP = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");//formato a http Date: Wed, 12 Mar 2024 15:30:00 GMT
	  formatoFechaHTTP.setTimeZone(TimeZone.getTimeZone("GMT"));
	  String fecha="Date: " + formatoFechaHTTP.format(fechaActual);
	  
	  return fecha;
  }

@Override
public void run() {
	
	try {
		procesaPeticion(socCliente);
		int idee=idCliente;//solo pruebas
		System.out.println("Atendiendo al cliente "+ idCliente);
	
	      //cierra la conexión entrante
	      socCliente.close();
	      System.out.println("cliente atendido");
	      
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


/**
 * @return the socCliente
 */
public Socket getSocCliente() {
	return socCliente;
}


/**
 * @param socCliente the socCliente to set
 */
public void setSocCliente(Socket socCliente) {
	this.socCliente = socCliente;
}


/**
 * @return the idCliente
 */
public int getIdCliente() {
	return idCliente;
}


/**
 * @param idCliente the idCliente to set
 */
public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}

}
