package com.tarea.MapeoInstituto;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="Actividades")
public class Actividad {

	@Id
	@Column(name="IdActividad")
	private Integer idActividad;
	
	@Column(name="Actividad")
	private String Actividad;
	
	@OneToMany(mappedBy = "actividad")
    private List<Calendario> calendarios;

	public Integer getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(Integer idActividad) {
		this.idActividad = idActividad;
	}

	public String getActividad() {
		return Actividad;
	}

	public void setActividad(String actividad) {
		Actividad = actividad;
	}

	@Override
	public String toString() {
		return "Actividad [idActividad=" + idActividad + ", Actividad=" + Actividad + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idActividad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Actividad)) {
			return false;
		}
		Actividad other = (Actividad) obj;
		return Objects.equals(idActividad, other.idActividad);
	}
	
	
}
