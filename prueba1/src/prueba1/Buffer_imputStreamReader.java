package prueba1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Buffer_imputStreamReader {

	public static void main(String[] args) {
		
		try
        {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
 
            System.out.print("Introduce el texto: ");
            String cad = br.readLine();
 
            //salida por pantalla del texto introducido
            System.out.println(cad);
 
            System.out.print("Introduce un numero: ");
            int num = Integer.parseInt(br.readLine());
 
            // salida por pantalla del numero introducido
            System.out.println(num);
 
        } catch (Exception e) {
           // System.out.println("Error al leer datos");
            e.printStackTrace();
	}

  }
}