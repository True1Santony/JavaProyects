package tarea;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;


public class EscrutinioSitios {

	@Override
	public String toString() {
		return "EscrutinioSitios [num_a_elegir=" + num_a_elegir + ", nombre_sitio=" + nombre_sitio + ", ts=" + ts
				+ ", votos=" + votos + "]";
	}
	private String num_a_elegir;//numero de concejales
	private String nombre_sitio;//el nombre de la poblacion del ayuntamiento
	private String ts;//identificacion  del ayuntamiento
	private ArrayList<Votos> votos;
	
	/**
	 * @return the num_a_elegir
	 */
	@XmlElement(name = "num_a_elegir")
	public String getNum_a_elegir() {
		return num_a_elegir;
	}
	/**
	 * @param num_a_elegir the num_a_elegir to set
	 */
	public void setNum_a_elegir(String num_a_elegir) {
		this.num_a_elegir = num_a_elegir;
	}
	/**
	 * @return the nombre_sitio
	 */
	@XmlElement(name = "nombre_sitio")
	public String getNombre_sitio() {
		return nombre_sitio;
	}
	/**
	 * @param nombre_sitio the nombre_sitio to set
	 */
	public void setNombre_sitio(String nombre_sitio) {
		this.nombre_sitio = nombre_sitio;
	}
	/**
	 * @return the ts
	 */
	@XmlElement(name = "ts")
	public String getTs() {
		return ts;
	}
	/**
	 * @param ts the ts to set
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}
	/**
	 * @return the votos
	 */
	
    @XmlElement(name = "votos")
	public ArrayList<Votos> getVotos() {
		return votos;
	}
	/**
	 * @param votos the votos to set
	 */
	public void setVotos(ArrayList<Votos> votos) {
		this.votos = votos;
	}
	
}
