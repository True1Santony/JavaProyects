package tarea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * @author espar 
 *  Este programa pretende leer 2 archivos de texto. 
 *  Uno lo toma como String de usuarios y el otro como String de tareas.
 *  Funcionará si solo está el archivo de usuarios, generará él solo el archivo de tareas.
 *  Distinge tanto los usuarios como las tareas aunque tengan caracteres no ASCII, no agregará Jose si existe José,
 *  aunque respera los no ASCII si fueron introducidos.
 *  Asigna a cada usuario una tarea de forma aleatoria.
 */
public class Uso {

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();// para la semilla
		int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);

		System.out.println(
				"Por favor, indique la ruta del archivo que contiene a los usuarios.\nEj: E:\\programacion\\tarea10\\usuarios.txt");
		Scanner sc = new Scanner(System.in);
		String ruta = sc.nextLine();
		File archivo1 = new File(ruta);

		System.out.println(
				"Por favor, indique la ruta del archivo que contiene las tareas.\nEj: E:\\\\programacion\\\\tarea10\\\\tareas.txt");
		ruta = sc.nextLine();
		File archivo2 = new File(ruta);

		sc.close();
		Set<Usuario> usuarios = new HashSet(); // No repetidos y desorganizados en cada ejecución, ambas de interes para
												// el programa.
		Set<Tarea> tareas = new HashSet(); // No repetidos y desorganizados en cada ejecución, ambas de interes para el
											// programa.

		try {
			FileReader fr = new FileReader(archivo1); // asigno el archivo file al flujo de 'carácteres'.
			BufferedReader br = new BufferedReader(fr); // abro el flujo buffer para lectura por linea.
			String line;

			while ((line = br.readLine()) != null) { // mientras la linea leida no sea null
				usuarios.add(new Usuario(line));
			}
			br.close(); // cierre flujo de datos

		} catch (FileNotFoundException e1) {
			System.err.println("Error: No se ha encontrado el archivo. Indique la ruta correcta."); // para el file

		} catch (IOException e2) {
			System.err.println("Error: No se ha podido leer el archivo."); // para el .readLine()

		}

		try {

			FileReader fr = new FileReader(archivo2);
			BufferedReader br = new BufferedReader(fr);
			String line;

			while ((line = br.readLine()) != null) {
				// String comparado=Normalizer.normalize(line,
				// Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", ""); Pruebas previas, ya
				// hace esto las clases con metodo sobreescrito
				tareas.add(new Tarea(line));
			}
			br.close();// cierre flujo de datos

		} catch (FileNotFoundException e1) {

			System.err.println(
					"Error: No se ha encontrado el archivo de tareas, se generará uno por defecto si existe el archivo de usuarios.");

			for (int i = 0; i < usuarios.size(); i++) { // genera una lista de tareas por defecto desde 1 hasta
														// nºusuarios
				String ale = Integer.toString(i + 1);
				tareas.add(new Tarea(ale));
			}

		} catch (IOException e2) {

			System.err.println("Error: No se ha podido leer el archivo.");

		}

		System.out.println("Los usuarios:");
		for (Usuario usuario : usuarios) {
			System.out.println("· " + usuario.getNombreCompl());
		}
		System.out.println("\nLas tareas:");
		for (Tarea tarea : tareas) {
			System.out.println("· " + tarea.getNombre());
		}

		ArrayList<Tarea> listaTareas = new ArrayList(tareas);// para hacer uso de .shuffle()

		for (Usuario usuario : usuarios) {

			long semilla = diaSemana + System.currentTimeMillis();
			Collections.shuffle(listaTareas, new Random(semilla));

			usuario.setTareaAsignada(listaTareas.get(1));
			System.out.println(usuario);

		}
	}

}
