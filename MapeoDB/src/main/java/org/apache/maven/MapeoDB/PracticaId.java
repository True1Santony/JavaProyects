package org.apache.maven.MapeoDB;

import java.io.Serializable;
import java.util.Objects;

public class PracticaId implements Serializable {

	
    private int nConvenio;

    
    private int nPrograma;

    
    private int dni;

	public int getnConvenio() {
		return nConvenio;
	}

	public void setnConvenio(int nConvenio) {
		this.nConvenio = nConvenio;
	}

	public int getnPrograma() {
		return nPrograma;
	}

	public void setnPrograma(int nPrograma) {
		this.nPrograma = nPrograma;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, nConvenio, nPrograma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PracticaId other = (PracticaId) obj;
		return dni == other.dni && nConvenio == other.nConvenio && nPrograma == other.nPrograma;
	}
	
}
