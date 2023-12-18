package prueba1;

public class Operadoresasignacion {
	 // clase principal main que inicia la aplicación

    public static void main(String[] args) {
    	
    	int x;

        int y;

        x = 5;  // operador asignación

        y = 3;  // operador asignación

 

        //operadores de asignación combinados

        System.out.printf("El valor de x es %d y el valor de y es %d\n", x,y);// la d es x y la segunda d es y , valores enteros la n es salto de linea

        x += y;

        // podemos utilizar indistintamente printf o println

        System.out.println(" Suma combinada: x += y " + " ............ x vale " + x);

        x = 5;

        x -= y;

        System.out.println(" Resta combinada: x -= y " + " ........... x vale " + x);

        x = 5;

        x *= y;

        System.out.println(" Producto combinado: x *= y " + " ........ x vale " + x);

        x = 5;

        x /= y;

        System.out.println(" Division combinada: x /= y " + " ........ x vale " + x);

        x = 5;

        x %= y;

        System.out.println(" Resto combinada: x %= y " + " ........... x vale " + x);
        
        x=(x>y)?x:y;
        
        System.out.println("Condicion = " + x );
        // en esta se compara si x es mayor que y, si es verdad devuelve el valor de x, si es falso devuelve el valor de y
        

    } // fin main

}
