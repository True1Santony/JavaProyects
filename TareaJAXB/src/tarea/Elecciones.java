package tarea;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;//importado a mano

@XmlRootElement(name = "elecciones")
public class Elecciones {
 
	private ArrayList<EscrutinioSitios> escrutinioSitios;
	
	@Override
	public String toString() {
		return "Elecciones [escrutinioSitios=" + escrutinioSitios + "]";
	}

	
	/**
	 * @return the escrutinioSitios
	 */
	
    @XmlElement(name = "escrutinio_sitio")
	public ArrayList<EscrutinioSitios> getEscrutinioSitios() {
		return escrutinioSitios;
	}

	/**
	 * @param escrutinioSitios the escrutinioSitios to set
	 */
	public void setEscrutinioSitios(ArrayList<EscrutinioSitios> escrutinioSitios) {
		this.escrutinioSitios = escrutinioSitios;
	}

	
	
}
