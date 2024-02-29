package com.tarea.MapeoInstituto;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name="Equipos")
public class Equipo {

	@Id
	@Column(name="IdEquipo")
	private Integer idEquipo;
	
	@Column(name="Nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "equipoA")//para los requisitos de consultas
    private List<Calendario> calendariosEquipoA;
	
	@OneToMany(mappedBy = "equipoB")//para los requisitos de consulta
    private List<Calendario> calendariosEquipoB;

	public Integer getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Equipo [idEquipo=" + idEquipo + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEquipo, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Equipo)) {
			return false;
		}
		Equipo other = (Equipo) obj;
		return Objects.equals(idEquipo, other.idEquipo) && Objects.equals(nombre, other.nombre);
	}
	
}
