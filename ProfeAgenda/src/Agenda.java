import java.util.Scanner;

public class Agenda {
	// Instancias a las tres academias que participan en el ejercicio.
	static Academia acaMusica = new Academia ("Musica");
	static Academia acaIngles  = new Academia ("Ingles");
	static Academia acaBaile = new Academia ("Baile");
	
	
	public static void main (String [] args) {
		Scanner miScan = new Scanner(System.in);
		String sLectScan = "";
		int iNumAlum = 1;
		String sActividad = "";
		String sAux = "";
		int iSesion = 0;
		
		// Se solicita el nombre de los alumnos y las actividades que quieren realizar
		System.out.println("******************************************************************************");
		System.out.println("Introduce información de los alumnos y sus reservas.");
		System.out.println("El número máximo de alumnos será 4. Si hay menos, finaliza la entrada con FIN.");
		System.out.println("******************************************************************************\n");

		System.out.print("Indica el nombre del alumno " + iNumAlum + " o FIN para finalizar: ");
		sLectScan = miScan.nextLine();
		sLectScan = sLectScan.toUpperCase();
		
		while ((iNumAlum <= 4) && !sLectScan.equals("FIN")) {

			// Actividad. No se procesa que el valor introducido sea diferente al que se pide (uno de los tres sin tildes)
			System.out.print("Indica la actividad (musica o ingles o baile): ");
			sActividad = miScan.nextLine();
			sActividad = sActividad.toLowerCase();
			System.out.print("Indica la sesion: ");
			sAux = miScan.nextLine();
			iSesion = Integer.parseInt(sAux);
			boolean bActApun = false;
			
			if (sActividad.equals("musica")) {
				bActApun = acaMusica.reservarPlaza(iSesion, sLectScan);
			}
			else if (sActividad.equals("ingles")) {
				bActApun = acaIngles.reservarPlaza(iSesion, sLectScan);
			}
			else if (sActividad.equals("baile")) {
				bActApun = acaBaile.reservarPlaza(iSesion, sLectScan);
			}
			
			if(bActApun) {
				System.out.println("\nLa actividad " + sActividad + " ha sido asignada a " + sLectScan + " en la sesion " + iSesion);
			}
			else {
				System.out.println("\nLa actividad " + sActividad + " no ha sido asignada a " + sLectScan);
			}
			

			iNumAlum++;
			
			if (iNumAlum <= 4) {
				System.out.println("\n\n******************************************************************************");
				System.out.print("Indica el nombre del alumno " + iNumAlum + " o FIN para finalizar: ");
				sLectScan = miScan.nextLine();
				sLectScan = sLectScan.toUpperCase();
			}
		}
		
		mostrarAgenda();	// Muestra el resumen final
		miScan.close();
	}
	
	static public void mostrarAgenda() {
		System.out.println("\n\n******************************************************************************");
		System.out.println("RESUMEN DE ACTIVIDADES RESERVADAS");
		System.out.println("******************************************************************************");
		System.out.println(acaMusica.infoSesion(1));
		System.out.println(acaMusica.infoSesion(2));
		System.out.println(acaIngles.infoSesion(1));
		System.out.println(acaIngles.infoSesion(2));
		System.out.println(acaBaile.infoSesion(1));
		System.out.println(acaBaile.infoSesion(2));
	}
}
