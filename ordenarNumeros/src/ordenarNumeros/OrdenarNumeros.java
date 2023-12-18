package ordenarNumeros;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
import java.util.Collections;

/**
 * Ordena un conjunto indeterminado de números que recibe a través de su entrada estándar;
 *  y muestra el resultado de la ordenación en su salida estándar.
 * @author espartaco
 */

public class OrdenarNumeros {

	public static void main(String[] args) throws Exception {
		
		ArrayList<String> a=new ArrayList<String>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       /* String[] numerosStr=reader.readLine().split(" ");// array de String, almacena 1 String hasta detectar un espacio. 
        int[] numeros=new int[numerosStr.length];*/
		String linea;
        while((linea=reader.readLine())!=null) {
        	
        	a.add(linea);
        }
        Collections.sort(a);
        for(String z:a) {
        	System.out.print(z+ " ");
        	
        }
        
        /*for (int i = 0; i < numerosStr.length; i++) {
            numeros[i] = Integer.parseInt(numerosStr[i]);
        }
        Arrays.sort(numeros);
        for (int numero : numeros) { // saca en pantalla el array ordenado.
            System.out.print(numero + " ");
        }*/
    }

	}


