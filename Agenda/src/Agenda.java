import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Agenda {

	public static void mostrarAgenda(Academia academia) {
		System.out.println(academia.infoSesion(10));
		System.out.println(academia.infoSesion(11));
	}

	static List<String> asistentes = new ArrayList<String>(); // he encontrado este objeto ArrayList que se adecua a lo
																// que necesito en este programa.
	String a;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "";
		Academia academia1 = new Academia("musica"); // instancio las 3 academias
		Academia academia2 = new Academia("ingles");
		Academia academia3 = new Academia("baile");

		for (int i = 0; i < 6; i++) { // bucle para rellenar la lista del array
			System.out.println("Introduzca el nombre del alumno número " + (i + 1)
					+ " o escriba ´fin´ para dejar de introducir alumnos.");
			Scanner sc = new Scanner(System.in); // no se como puedo cerrarlo sin afectar al codigo.
			a = sc.nextLine(); // posible incongruencia, no error.
			if (a.equalsIgnoreCase("fin")) {
				i = 6;
			} else {
				asistentes.add(a);
			}
		}

		for (int i = 0; i < asistentes.size(); i++) {
			int auxInt = 0;

			System.out.println("¿En que actividad se quiere apuntar " + asistentes.get(i) + "?");
			Scanner sc = new Scanner(System.in); // no se como puedo cerrarlo sin afectar al codigo.
			a = sc.nextLine(); // posible error, controlado mas abajo(OK).

			switch (a.toLowerCase()) { // pasa a minusculas leido por teclado
			case "ingles":
				boolean continua;
				do {
					try { // captura error, en caso de introducir char en vez de int.
						continua = false;
						System.out.println("¿En que sesión, de la academia de Inglés, se quiere apuntar "
								+ asistentes.get(i) + " (escoja 10 o 11): ");
						auxInt = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Tiene que introducir un valor numérico!!!");
						sc.next();
						continua = true;
					}
				} while (continua); // RuntimeException(error,mejorar programa).

				if (auxInt == 10 || auxInt == 11) {
					if (auxInt == 10 && (academia2.mostrarSesUno() == 0 || academia2.mostrarSesUno() == 1)) {
						academia2.reservaPlaza(auxInt, asistentes.get(i));
						System.out.println(
								"Se ha hecho la reserva para Inglés a las 10:00, para el alumno: " + asistentes.get(i));
						academia2.comprobarDisp(auxInt);
					} else if (academia2.mostrarSesUno() == 2 && auxInt == 10) {
						System.out.println("No quedan plazas para Ingles, en la sesion de las 10");
					} else if (auxInt == 11 && (academia2.mostrarSesDos() == 0 || academia2.mostrarSesDos() == 1)) {
						academia2.reservaPlaza(auxInt, asistentes.get(i));
						System.out.println(
								"Se ha hecho la reserva para Inglés a las 11:00, para el alumno: " + asistentes.get(i));
						academia2.comprobarDisp(auxInt);
					} else if (academia2.mostrarSesDos() == 2 && auxInt == 11) {
						System.out.println("No quedan plazas para Inglés, en la sesion de las 11:00");
					}
					break;
				} else if (auxInt != 10 || auxInt != 11) {
					System.out.println(
							"Porfavor escoja entre las opciones disponibles: 10 para la sesión de las 10:00 o 11 para la sesión de las 11:00");
					i--;
				}
				break;

			case "musica":

				do {
					try {
						continua = false;
						System.out.println("¿En que sesión, de la academia de Música, se quiere apuntar "
								+ asistentes.get(i) + " (escoja 10 o 11): ");
						auxInt = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Tiene que introducir un valor numérico!!!");
						sc.next();
						continua = true;
					}
				} while (continua); // RuntimeException

				if (auxInt == 10 || auxInt == 11) {
					if (auxInt == 10 && (academia1.mostrarSesUno() == 0 || academia1.mostrarSesUno() == 1)) {
						academia1.reservaPlaza(auxInt, asistentes.get(i));
						System.out.println(
								"Se ha hecho la reserva para Música a las 10:00, para el alumno: " + asistentes.get(i));
						academia1.comprobarDisp(auxInt);
					} else if (academia1.mostrarSesUno() == 2 && auxInt == 10) {
						System.out.println("No quedan plazas para Música, en la sesion de las 10");
					} else if (auxInt == 11 && (academia1.mostrarSesDos() == 0 || academia1.mostrarSesDos() == 1)) {
						academia1.reservaPlaza(auxInt, asistentes.get(i));
						System.out.println(
								"Se ha hecho la reserva para Musica a las 11:00, para el alumno: " + asistentes.get(i));
						academia1.comprobarDisp(auxInt);
					} else if (academia1.mostrarSesDos() == 2 && auxInt == 11) {
						System.out.println("No quedan plazas para Música, en la sesion de las 11:00");
					}
					break;
				} else if (auxInt != 10 || auxInt != 11) {
					System.out.println(
							"Porfavor escoja entre las opciones disponibles: 10 para la sesión de las 10:00 o 11 para la sesión de las 11:00");
					i--;
				}
				break;

			case "baile":

				do {
					try {
						continua = false;
						System.out.println("¿En que sesión, de la academia de Baile, se quiere apuntar "
								+ asistentes.get(i) + " (escoja 10 o 11): ");
						auxInt = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Tiene que introducir un valor numérico!!!");
						sc.next();
						continua = true;
					}
				} while (continua); // RuntimeException

				if (auxInt == 10 || auxInt == 11) {
					if (auxInt == 10 && (academia3.mostrarSesUno() == 0 || academia3.mostrarSesUno() == 1)) {
						academia3.reservaPlaza(auxInt, asistentes.get(i));
						System.out.println(
								"Se ha hecho la reserva para Baile a las 10:00, para el alumno: " + asistentes.get(i));
						academia3.comprobarDisp(auxInt);
					} else if (academia3.mostrarSesUno() == 2 && auxInt == 10) {
						System.out.println("No quedan plazas para Baile, en la sesion de las 10");
					} else if (auxInt == 11 && (academia3.mostrarSesDos() == 0 || academia3.mostrarSesDos() == 1)) {
						academia3.reservaPlaza(auxInt, asistentes.get(i));
						System.out.println(
								"Se ha hecho la reserva para Baile a las 11:00, para el alumno: " + asistentes.get(i));
						academia3.comprobarDisp(auxInt);
					} else if (academia3.mostrarSesDos() == 2 && auxInt == 11) {
						System.out.println("No quedan plazas para Baile, en la sesion de las 11:00");
					}
					break;
				} else if (auxInt != 10 || auxInt != 11) {
					System.out.println(
							"Porfavor escoja entre las opciones disponibles: 10 para la sesión de las 10:00 o 11 para la sesión de las 11:00");
					i--;
				}
				break;

			default:

				System.out.println("Porfavor escoja entre las clases disponibles: Música, Inglés o Baile."); // para el
																												// caso
																												// de
																												// que
																												// se
																												// introduzca
																												// cualquier
																												// cosa
																												// no
																												// contemplada.
				i--;

			}

		}
		Agenda.mostrarAgenda(academia1);
		Agenda.mostrarAgenda(academia2);
		Agenda.mostrarAgenda(academia3);

		/*
		 * for (int i=0; i<asistentes.size(); i++) {
		 * 
		 * System.out.println(asistentes.get(i)); Esto es para pruebas, si se comporta
		 * como lo esperado del ArrayList }
		 */
		/*
		 * System.out.println(academia1.infoSesion(10)); Impresion, antes de saber como
		 * hacer el metodo mostrarAgenda. System.out.println(academia1.infoSesion(11));
		 * 
		 * System.out.println(academia2.infoSesion(10));
		 * System.out.println(academia2.infoSesion(11));
		 * 
		 * System.out.println(academia3.infoSesion(10));
		 * System.out.println(academia3.infoSesion(11));
		 * 
		 * }
		 */

	}

}
