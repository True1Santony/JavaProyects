package prueba1;

import java.util.Scanner;

public class CalculaRectangulo {

	public static void main(String[] args) {
		double largo=0,ancho=0;
		
		System.out.println("Introduce, porfavo, el largo del rectangulo: ");
		Scanner entrada= new Scanner(System.in);
		largo = entrada.nextDouble();
			System.out.println("Ahora introduce, porfavo, el ancho del rectangulo: ");
			ancho = entrada.nextDouble();
	double perimetro=largo+ancho;
			
			System.out.println("El area del rectangulo es: " + perimetro);
			
		entrada.close();
	}

}
