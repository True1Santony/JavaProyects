package tarea;

import javax.xml.bind.annotation.XmlElement;

public class Abstenciones {
	

	@Override
	public String toString() {
		return "Abstenciones [cantidad=" + cantidad + "]";
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
