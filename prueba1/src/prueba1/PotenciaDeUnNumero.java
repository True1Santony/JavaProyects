package prueba1;

import java.util.Scanner;

public class PotenciaDeUnNumero {

	public static void main(String[] args) {
		System.out.print("Introduce la base:");
		int base=0;
				Scanner teclado = new Scanner(System.in);
		base=teclado.nextInt();
		System.out.print("Introduce el exponente:");
		int exponente=teclado.nextInt();
		int resultado=(int)Math.pow(base, exponente);
		
		System.out.println("El resutado de "+ base + " elevado a "+ exponente + ", es:  " + resultado );
		
	}

}
