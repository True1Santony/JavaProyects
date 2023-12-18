package JuegoCartas;

import java.util.ArrayList;

public class BarajaFrancesa extends Baraja {

	private final String[] carta = { "AS", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JOTA", "DAMA", "REY" };
	private final String[] palo = { " de PICAS", " de TRÉVOLES", " de CORAZONES", " de DIAMANTES" };

	public BarajaFrancesa() {// constructor, crea la baraja española, recorre todas las cartas por cada palo

		creaBaraja();

	}

	/**
	 * Crea la baraja de clase.
	 */
	private void creaBaraja() {
		cartas = new ArrayList<String>();

		for (int i = 0; i < carta.length; i++) {

			String q = carta[i];
			String w = palo[0];
			String e = q + w;
			cartas.add(e);

		}
		for (int i = 0; i < carta.length; i++) {

			String q = carta[i];
			String w = palo[1];
			String e = q + w;
			cartas.add(e);

		}
		for (int i = 0; i < carta.length; i++) {

			String q = carta[i];
			String w = palo[2];
			String e = q + w;
			cartas.add(e);
		}
		for (int i = 0; i < carta.length; i++) {

			String q = carta[i];
			String w = palo[3];
			String e = q + w;
			cartas.add(e);
		}
	}

	/**
	 * @param fr la coleccion de cartas francesas AGREGA 2 COMODINES A LA BARAJA,
	 *           static para usarlo mas comodamente
	 */
	public static void sumaComodin(BarajaFrancesa fr) {

		fr.cartas.add("JOKER");
		fr.cartas.add("JOKER");
	}

}
