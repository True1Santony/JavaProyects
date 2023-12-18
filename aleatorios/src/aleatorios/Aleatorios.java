package aleatorios;

//import java.util.ArrayList;

//import java.util.Random;

/**
 * Genera 40 números aleatorios (entre 0 y 100), 
 * y que los escribe en su salida estándar.
 * @author espartaco
 */

public class Aleatorios {

	public static void main(String[] args) {
		//ArrayList<Integer> a = new ArrayList<>();
		//int b;
		//Random random = new Random();
        for (int i = 0; i < 40; i++) {
            //System.out.print(random.nextInt(101) + " ");  
            System.out.println(String.valueOf((int)(Math.random()*100)) + " ");
            
        }
	}

	
}
