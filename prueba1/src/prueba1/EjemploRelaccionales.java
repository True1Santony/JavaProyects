package prueba1;

import java.util.Scanner;

public class EjemploRelaccionales {
	   public static void main( String args[] )

	   {

	      // clase Scanner para petición de datos

	      Scanner teclado = new Scanner( System.in );

	      int x, y;

	      String cadena;

	      boolean resultado;

	      System.out.print( "Introducir primer número: " );

	      x = teclado.nextInt(); // pedimos el primer número al usuario

	      System.out.print( "Introducir segundo número: " );

	      y = teclado.nextInt(); // pedimos el segundo número al usuario

	      // realizamos las comparaciones

	      cadena=(x==y)?"iguales":"distintos";

	      System.out.printf("Los números %d y %d son %s\n",x,y,cadena);

	      resultado=(x!=y);

	      System.out.println("x != y  // es " + resultado);

	      resultado=(x < y );

	      System.out.println("x < y  // es " + resultado);

	      resultado=(x > y );

	      System.out.println("x > y  // es " + resultado);

	      resultado=(x <= y );

	      System.out.println("x <= y  // es " + resultado);

	      resultado=(x >= y );

	      System.out.println("x >= y  // es " + resultado);

	    } // fin método main

}
