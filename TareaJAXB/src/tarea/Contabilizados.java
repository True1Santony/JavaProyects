package tarea;

import javax.xml.bind.annotation.XmlElement;

public class Contabilizados {

	@Override
	public String toString() {
		return "Contabilizados [cantidad=" + cantidad + "]";
	}

	private String cantidad;

	/**
	 * @return the cantidad
	 */
	@XmlElement
	public String getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
}
