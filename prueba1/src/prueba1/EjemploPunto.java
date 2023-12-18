package prueba1;

//Ejemplo Clase Punto sencillo

class Punto {

//Definición de Atriobutos

double x; double y;

//Definicion de metodos

String muestraDatos(){

  String retorno = "(" + x + " , " + y + ")";

  return retorno;

}

}

public class EjemploPunto {

public static void main(String []args) {

  Punto P = new Punto(), Q = new Punto();

  P.x = 1.1111; P.y = 2.2222;

  Q.x = 4.7; Q.y = 7.4;   



  double distanciaPQ = 0.0; //Para calcular la distancia de dos puntos.

  System.out.printf("Punto P : Coordenadas (%03.1f , %03.1f).\n" , P.x , P.y );

  System.out.printf("Punto Q : Coordenadas (%03.1f , %03.1f).\n" , Q.x , Q.y );

  System.out.println("Punto P : " + P.muestraDatos() );

  System.out.println("Punto Q : " + Q.muestraDatos() );

  //Calculo de la Distancia de P a Q. Por Pitagoras.

  // d = sqrt( (x-x0)2 + (y-y0)2 );

  distanciaPQ = Math.sqrt(  Math.pow((P.x-Q.x) ,2) + Math.pow((P.y-Q.y) ,2) );

  System.out.printf("Distancia P a Q : %03.1f", distanciaPQ ) ;

}

}

/* //La ejecución del código :

run:

Punto P : Coordenadas (1,1 , 2,2).

Punto Q : Coordenadas (4,7 , 7,4).

Punto P : (1.1111 , 2.2222)

Punto Q : (4.7 , 7.4)

Distancia P a Q : 6,3

BUILD SUCCESSFUL (total time: 0 seconds)*/