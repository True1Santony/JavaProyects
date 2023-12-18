import java.util.Scanner;

/**
 * 
 * Esta clase hace una muestra de posibles errores derivados de la clase
 * Throwable
 * 
 * @author Espartaco
 *
 */

public class ejecutar {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int iAux;
		String sAux;

		do {
			System.out.println("1. Aritmética");
			System.out.println("2. Puntero-Nulo");
			System.out.println("3. Formato");
			System.out.println("4. Array");
			System.out.println("5. Miclase");
			System.out.println("6. Fin");

			sAux = sc.nextLine();

			if (sAux.equalsIgnoreCase("1") || sAux.equalsIgnoreCase("Aritmetica")) {

				try {
					aritneticException();
				} catch (ArithmeticException e) {
					System.out.println("Vaya, hemos tenido un problema, no se puede dividir entre 0");
					System.out.println(e);
				}

			} else if (sAux.equalsIgnoreCase("2") || sAux.equalsIgnoreCase("Puntero-nulo")) {

				try {
					objeto_nulo();
				} catch (NullPointerException e) {
					System.out.println("Vaya, hemos tenido un problema, el objeto se encuentra en estado nulo");
					System.out.println(e);
				}

			} else if (sAux.equalsIgnoreCase("3") || sAux.equalsIgnoreCase("Formato")) {

				System.out.println("Introduzca unas letras o caracteres no numéricos, porfavor: ");
				try {
					transform_str_a_int(sc);
				} catch (NumberFormatException e) {
					System.out.println("Vaya, hemos tenido un problema, no se ha podido tranformar el String en Int");
					System.out.println(e);
				}

			} else if (sAux.equalsIgnoreCase("4") || sAux.equalsIgnoreCase("Array")) {

				String cadena = new String("Mi cadena");
				char caracter;

				try {
					caracter = cadena.charAt(25);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("No existe un carácter en esa posición");
					System.out.println(e);
				}

			} else if (sAux.equalsIgnoreCase("5") || sAux.equalsIgnoreCase("Miclase")) {

				try {
					throw new MiClaseException();
				} catch (MiClaseException e) {
					System.out.println(e);
				}

			} else if (sAux.equalsIgnoreCase("6") || sAux.equalsIgnoreCase("fin")) {

			}

		} while (!(sAux.equalsIgnoreCase("Fin") || (sAux.equalsIgnoreCase("6"))));

		System.out.println("Hemos finalizado");
	}

	/**
	 * 
	 * @param sc Este parametro lee con Scanner un String e intenta pasarlo a
	 *           Integer.
	 * @throws NumberFormatException
	 */

	private static void transform_str_a_int(Scanner sc) throws NumberFormatException {
		int iAux;
		String sAux2;
		sAux2 = sc.nextLine();
		iAux = Integer.parseInt(sAux2);
	}

	/**
	 * Metodo generado con eclipse refactorizacion, genera excepción.
	 * 
	 * @throws NullPointerException
	 */

	private static void objeto_nulo() throws NullPointerException {
		String sAux2;
		sAux2 = null;
		sAux2.charAt(1);
	}

	/**
	 * 
	 * Metodo generado con eclipse refactorizacion, genera excepción.
	 * 
	 * @throws ArithmeticException
	 */

	private static void aritneticException() throws ArithmeticException {
		int i = 0, j = 0, q;
		q = i / j;
	}

}

/**
 * 
 * Clase propia de objetos/excepción.
 * 
 * @author espar
 *
 */

class MiClaseException extends Exception {

	long lNumAleatorio;

	/**
	 * Constructor que establece valor por defecto aleatorio.
	 * 
	 */
	MiClaseException() {
		setlNumAleatorio();
	}

	/**
	 * Metodo toString sobreescito
	 * 
	 */
	public String toString() {

		String cadena = "Generada la excepción MiClaseException con número aleatorio " + getlNumAleatorio();

		return cadena;
	}

	/**
	 * 
	 * @return
	 */
	public long getlNumAleatorio() {
		return lNumAleatorio;
	}

	/**
	 * 
	 * @param establece, con math.random un valor aleatorio al atributo del objeto.
	 */
	public void setlNumAleatorio() {

		double variable = Math.random() * 10;
		lNumAleatorio = (long) variable;

	}
}
