package tarea;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class Tarea {

	private String nombre = "";

	/**
	 * Constructor
	 * 
	 * @param nombre
	 */
	public Tarea(String nombre) {

		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}

	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Necesario para la comparacion.
	 */
	@Override
	public int hashCode() {
		String comparado = Normalizer.normalize(nombre, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		// Por intuicion he puesto esta linea aqui sin saber porque, asi funciona la comparacion, sin esta no funciona.
																												
		return Objects.hash(comparado);
	}

	/**
	 * Compara los objetos Tarea en funcion de su nombre Se puede agregar, encadenando al final:
	 * .replaceAll("\\s+", " ")
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Tarea) {

			Tarea other = (Tarea) obj;

			String comparado = Normalizer.normalize(nombre, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			String comparador = Normalizer.normalize(other.nombre, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

			if (comparado.equalsIgnoreCase(comparador)) {

				return true;

			} else {
				return false;
			}
		} else {
			return false;
		}

	}
}
