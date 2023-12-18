package tarea;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Contiene los parametrode los ayuntamientos
 * cada ayuntamiento posee un atributo xml = ts.
 */
@XmlType(propOrder = {"ts", "nombre", "concejales", "votantes"})
public class Ayuntamientos {

	
	private String ts;
	private String nombre;
	private String concejales;
	private String votantes;
	
	@Override
	public String toString() {
		return "Ayuntamientos [ts=" + ts + ", nombre=" + nombre + ", concejales=" + concejales + ", votantes="
				+ votantes + "]";
	}
	/**
	 * @return the ts
	 */
	@XmlAttribute
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
	 * @return the nombre
	 */
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the concejales
	 */
	@XmlElement
	public String getConcejales() {
		return concejales;
	}
	/**
	 * @param concejales the concejales to set
	 */
	public void setConcejales(String concejales) {
		this.concejales = concejales;
	}
	/**
	 * @return votantes
	 */
	@XmlElement
	public String getVotantes() {
		return votantes;
	}
	/**
	 * @param votantes the votantes to set
	 */
	public void setVotantes(String votantes) {
		this.votantes = votantes;
	}
	
}
