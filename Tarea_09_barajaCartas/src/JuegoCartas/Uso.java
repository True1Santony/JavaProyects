package JuegoCartas;

public class Uso {

	public static void main(String[] args) {

		int jugadores, numCartas, baraja;
		
		if (args.length == 3 && (args[2].equalsIgnoreCase("0") || args[2].equalsIgnoreCase("1"))) {// si los valores de args[] son correctos
													
			jugadores = Integer.parseInt(args[0]); // paso a tipos primitivos para un manejo mas comodo.
			numCartas = Integer.parseInt(args[1]);
			baraja = Integer.parseInt(args[2]);
			
			if (baraja == 0) {// baraja española

				BarajaEspaniola esp = new BarajaEspaniola(); // instancia de baraja española, el constructor la crea.
				Baraja.barajar(esp.cartas); // se baraja
				for (int i = 0; i < jugadores; i++) {

					System.out.println("jugador:" + (i + 1));

					for (int j = 0; j < numCartas; j++) {

						System.out.print("[" + esp.cartas.get(j) + "] ");
						esp.cartas.remove(j);

						if (j == (numCartas - 1)) {// salto de linea tras imprimir al jugador
							System.out.println();
						}
					}
				}

			} else { //baraja francesa

				BarajaFrancesa fr = new BarajaFrancesa();// instancia de baraja franfesa

				if (numCartas == 5) {

					BarajaFrancesa.sumaComodin(fr);// sumo 2 comodines si hay 5 cartas por jugador
				}

				Baraja.barajar(fr.cartas);// se baraja

				for (int i = 0; i < jugadores; i++) { // for anidado para imprimir cartas por cada jugador.

					System.out.println("jugador:" + (i + 1));

					for (int j = 0; j < numCartas; j++) {

						System.out.print("[" + fr.cartas.get(j) + "] ");
						fr.cartas.remove(j);

						if (j == (numCartas - 1)) {// salto de linea tras imprimir al jugador
							System.out.println();
						}
					}
				}

			}

		} else {                 // ejecucion por defecto, como está esta opción no valido más casos por única posibilidad.
			jugadores = 4;
			numCartas = 4;
			baraja = 0;
            System.out.println("VALORES NO ACEPTADOS.Juego por defecto: MUS\n");
			BarajaEspaniola esp = new BarajaEspaniola(); // instancia de baraja española
			Baraja.barajar(esp.cartas); // se baraja
			for (int i = 0; i < jugadores; i++) {

				System.out.println("jugador:" + (i + 1));

				for (int j = 0; j < numCartas; j++) {

					System.out.print("[" + esp.cartas.get(j) + "] ");
					esp.cartas.remove(j);

					if (j == (numCartas - 1)) {// salto de linea tras imprimir al jugador
						System.out.println();

					}

				}

			}
			System.out.println("\nEJEMPLO VALORES VÁLIDOS: 5 5 1  NO SE OLVIDE DEL ESPACIO ENTRE NÚEROS");
		}
	}
}
