package JuegoCartas;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author espar
 *
 * Clase abstracta de Barajas
 * @param cartas , es una coleccion de cartas de tipo String ya que no manejará de otros tipos.
 */
public abstract class Baraja   {

	protected ArrayList<String> cartas; //protected para que tenga visibilidad en el paquete

	
	/**
	 * Imprime toda la baraja. El contenido del ArrayList
	 */
	public void devuelveBaraja() {
		for (int i = 0; i < cartas.size(); i++) {
			System.out.println(cartas.get(i));
		}
	}

	/**
	 * @param <T> tipo de baraja que se va a manejar.
	 * @param a la baraja a pasar por paramentro
	 * baraja cualquier baraja heredada de Barajas.
	 */
	public static <T> void barajar(ArrayList<T> a) { 

		Collections.shuffle(a);
	}

	public ArrayList<String> getCartas() {
		return cartas;
	}
}
