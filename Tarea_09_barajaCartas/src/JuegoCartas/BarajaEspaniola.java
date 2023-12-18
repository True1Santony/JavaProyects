package JuegoCartas;

import java.util.ArrayList;

/**
 * @author espar
 * clase que hereda de Baraja
 * 
 * @param carta atributo propio, las cartas posibles.
 * @paran palo atributo de clase, los palos posibles.
 */
public class BarajaEspaniola extends Baraja {

	private final String[] carta = { "AS", "2", "3", "4", "5", "6", "7", "SOTA", "CABALLO", "REY" };
	private final String[] palo = { " de BASTOS", " de OROS", " de COPAS", " de ESPADAS" };

	/**
	 * constructor que llama al metodo creaBaraja
	 * 
	 */
	public BarajaEspaniola() {

		creaBaraja();

	}

	/**
	 * crea una baraja española
	 */
	private void creaBaraja() {
		cartas=new ArrayList<String>();
		
		for(int i=0; i<carta.length; i++) {
			
			String q = carta[i];
			String w = palo[0];
			String e = q+w;
			cartas.add(e);
			
		}
		for(int i=0; i<carta.length; i++) {
					
			String q = carta[i];
			String w = palo[1];
			String e = q+w;
			cartas.add(e);
		
		}
		for(int i=0; i<carta.length; i++) {
			
			String q = carta[i];
			String w = palo[2];
			String e = q+w;
			cartas.add(e);
		}
		for(int i=0; i<carta.length; i++) {
			
			String q = carta[i];
			String w = palo[3];
			String e = q+w;
			cartas.add(e);
		}
	}

	
}
