package prueba1;

import java.util.Scanner;

public class GruposDeNumeros {

	public static void main(String[] args) {
		final int maximo=65;
		final int minimo=18;
		int menores=0;
		int mayores=0;
		int intermedios=0;
		int actual =0;
		String cadena[];
		String cadenas="";
		
		
		Scanner teclado= new Scanner(System.in);
		cadenas=teclado.nextLine();
		cadena=cadenas.split(" ");
		actual=Integer.parseInt(cadena[0]);
		if (actual>maximo) {
			actual=mayores;}
			else if (actual<maximo && actual>minimo) {
				
				
			
		}
			
			
		System.out.println("Los numeros menores de 18 son: " + menores);
		System.out.println("Los numeros mayores de 65 son: " + mayores);
		 
		}
  
 
	}


