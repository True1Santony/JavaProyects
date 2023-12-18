package tarea;

import javax.xml.bind.annotation.XmlElement;

public class Votos {
	
	private Contabilizados contabilizados;
	private Abstenciones abstenciones;
	
	

	/**
	 * @return the contabilizados
	 */
	@XmlElement(name = "contabilizados")
	public Contabilizados getContabilizados() {
		return contabilizados;
	}
	/**
	 * @param contabilizados the contabilizados to set
	 */
	public void setContabilizados(Contabilizados contabilizados) {
		this.contabilizados = contabilizados;
	}
	/**
	 * @return the abstenciones
	 */
	@XmlElement(name = "abstenciones")
	public Abstenciones getAbstenciones() {
		return abstenciones;
	}
	/**
	 * @param abstenciones the abstenciones to set
	 */
	public void setAbstenciones(Abstenciones abstenciones) {
		this.abstenciones = abstenciones;
	}
	@Override
	public String toString() {
		return "Votos [contabilizados=" + contabilizados + ", abstenciones=" + abstenciones + "]";
	}
	
}
