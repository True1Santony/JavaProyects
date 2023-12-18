package ejercicio2_2;

import java.io.IOException;


/**
 *  Lanza al menos 10 instancias de la aplicación "lenguaje".
 *  Haciendo que todas ellas, colaboren en generar un gran fichero de palabras.
 *  Cada instancia generará un número creciente de palabras de 10, 20, 30, …
 *  No gestiona concurrencia.
 * 
 * @author espartaco
 */

public class Colaborar {
	
	/**
	 * @param args
	 * Recibe un String con la cantidad de procesos que se desea lanzar.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if(args.length == 1) {
			
			int procesos=Integer.parseInt(args[0]);
			
			if(procesos<10) {
				procesos=10;
				System.out.println("Se van a lanzar 10 procesos, por defecto.");
			}
			
			for(int i=1;i<=procesos;i++) { //cada x procesos va a lanzar estos mismos x lineas,
				                           // lineas generadas se sumaran a las lineas anteriores exponencialmente.
				System.out.println("proceso:" + i );
				String command="java -jar lenguaje.jar " +(i * procesos) + " miFicheroDeLenguaje.txt";
				
				try {
					Runtime.getRuntime().exec(command);// se lanza el proceso.
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			System.out.println();
		}else {
			
			System.out.println("Ingroduzca 1 parámetro, entero, cuantos procesos quiere lanzar(al menos 10).");
		}
		
	}
}
