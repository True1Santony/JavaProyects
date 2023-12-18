package prueba1;

import java.util.Scanner;

public class VerdesAzules {
	
	
	public static void main(String[] args) {
		Scanner entradas = new Scanner(System.in);
		String cadena;
		int entrada;
		
			
		
		
		
			System.out.print("Introduzca los tres numeros de las entradas, separadas por un espacio: ");
			cadena = entradas.nextLine();
			entrada = Integer.parseInt(cadena);
			
			
			System.out.println("Las entradas son " + cadena);
			
			if ( entrada % 2 == 0 )
	        {
	            System.out.printf( "ES PAR luego verde" );
	        }
	        else
	        {
	            System.out.printf( "ES IMPAR luego azul" );
			
			
		
		
		
	        }
	}

}
