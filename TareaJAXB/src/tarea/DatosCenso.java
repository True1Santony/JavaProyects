package tarea;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Clase elemento raiz, contiene los ayuntamientos
 * Tiene un elemento xml contenedor que contiene los objetos
 * del array.
 * 
 * 
 */
@XmlRootElement(name = "datos_censo")
@XmlType(propOrder = {"titulo", "total_votantes", "total_concejales", "ayuntamientos"})
public class DatosCenso {
	
	/**
	 * @param titulo String
	 * @param total_votantes String
	 * @param total_concejales String
	 * @param ayuntamientos array de Ayuntamientos
	 */
	private String titulo;
	private String total_votantes;
	private String total_concejales;
	private ArrayList<Ayuntamientos> ayuntamientos;
	
	@Override
	public String toString() {
		return "DatosCenso [titulo=" + titulo + ", total_votantes=" + total_votantes + ", total_concejales="
				+ total_concejales + ", ayuntamientos=" + ayuntamientos + "]";
	}
	
	
	/**
	 * @return the titulo
	 */
	@XmlElement
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the total_votantes
	 */
	@XmlElement(name = "total_votantes")
	public String getTotal_votantes() {
		return total_votantes;
	}
	/**
	 * @param total_votantes the total_votantes to set
	 */
	public void setTotal_votantes(String total_votantes) {
		this.total_votantes = total_votantes;
	}
	/**
	 * @return the total_concejales
	 */
	@XmlElement(name = "total_concejales")
	public String getTotal_concejales() {
		return total_concejales;
	}
	/**
	 * @param total_concejales the total_concejales to set
	 */
	public void setTotal_concejales(String total_concejales) {
		this.total_concejales = total_concejales;
	}
	/**
	 * @return the ayuntamientos
	 */
	@XmlElementWrapper(name = "ayuntamientos")
    @XmlElement(name = "ayuntamiento")
	public ArrayList<Ayuntamientos> getAyuntamientos() {
		return ayuntamientos;
	}
	/**
	 * @param ayuntamientos the ayuntamientos to set
	 */
	public void setAyuntamientos(ArrayList<Ayuntamientos> ayuntamientos) {
		this.ayuntamientos = ayuntamientos;
	}
	

}
