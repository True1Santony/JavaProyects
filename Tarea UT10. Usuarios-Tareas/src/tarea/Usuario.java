package tarea;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Usuario {
	
	private String nombreCompl="";
	private Tarea tareaAsignada;
	
	/**constructor 
	 * @param nombre
	 */
	public Usuario(String nombre) {
		
		nombreCompl=nombre;
	}

	@Override
	public String toString() { 
		return nombreCompl+", "+tareaAsignada;
	}

	/**
	 * @return el nombreCompl
	 */
	public String getNombreCompl() {
		return nombreCompl;
	}

	/**
	 * @param nombreCompl el nombreCompl a establecer
	 */
	public void setNombreCompl(String nombreCompl) {
		this.nombreCompl = nombreCompl;
	}

	/**
	 * @return tareaAsignada
	 */
	public Tarea getTareaAsignada() {
		return tareaAsignada;
	}

	/**
	 * @param tareaAsignada a establecer
	 */
	public void setTareaAsignada(Tarea tareaAsignada) {
		this.tareaAsignada = tareaAsignada;
	}

	@Override
	public int hashCode() {
		String nombreInterno=Normalizer.normalize(nombreCompl, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");// sin esta linea no funciona la comparación, no se porque.
		return Objects.hash(nombreInterno);
	}

	/**
	 *para comparar objetos de Ususrios.
	 *Compara sin tomar en cuenta acentos...
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Usuario) {
			
			Usuario uno=(Usuario)obj;
			
			String nombreInterno=Normalizer.normalize(nombreCompl, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
			String nombreDeObjPasado=Normalizer.normalize(uno.nombreCompl, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
			
				if(nombreInterno.equalsIgnoreCase(nombreDeObjPasado)) {
					
					return true;
				}else {
					return false;
				}
		}else {
			
			return false;
		}
	}
	
	
	
}
