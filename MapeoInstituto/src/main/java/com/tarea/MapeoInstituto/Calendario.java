package com.tarea.MapeoInstituto;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="Calendario")
@NamedQueries({
    @NamedQuery(name = "Calendario.listaOrdenada",
        query = "SELECT c.actividad.Actividad, c.equipoA.nombre, c.equipoB.nombre, c.primaryKeyCalendario.fecha, c.primaryKeyCalendario.hora, c.primaryKeyCalendario.lugar " +
                "FROM Calendario c " +
                "ORDER BY c.actividad.Actividad, c.primaryKeyCalendario.fecha, c.primaryKeyCalendario.hora"),
    @NamedQuery(name = "Calendario.resultadosPorDeporte",
    query = "SELECT c.primaryKeyCalendario.fecha, c.primaryKeyCalendario.hora, c.equipoA.nombre, c.equipoB.nombre, c.resultadoEquipoA, c.resultadoEquipoB " +
            "FROM Calendario c "+
            "WHERE c.actividad.Actividad = :deporte")
            
})
public class Calendario implements Serializable {

	

	public Calendario(CalendarioId primaryKeyCalendario, Integer jornada, Integer resultadoEquipoA,
			String resultadoEquipoB, Equipo equipoA, Equipo equipoB, Actividad actividad) {
		super();
		this.primaryKeyCalendario = primaryKeyCalendario;
		this.jornada = jornada;
		this.resultadoEquipoA = resultadoEquipoA;
		this.resultadoEquipoB = resultadoEquipoB;
		this.equipoA = equipoA;
		this.equipoB = equipoB;
		this.actividad = actividad;
	}

	@EmbeddedId
	private CalendarioId primaryKeyCalendario;
	
	@Column(name="Jornada")
	private Integer jornada;
	
	@Column(name="ResultadoEquipoA")
	private Integer resultadoEquipoA;
	
	@Column(name="ResultadoEquipoB")
	private String resultadoEquipoB;
	
	@ManyToOne
	@JoinColumn(name="EquipoA", referencedColumnName="IdEquipo")
	private Equipo equipoA;
	
	@ManyToOne
    @JoinColumn(name = "EquipoB", referencedColumnName = "IdEquipo")
    private Equipo equipoB;
	
	@ManyToOne
	@JoinColumn(name="Actividad", referencedColumnName="IdActividad",insertable=false, updatable=false )
	private Actividad actividad;

	public CalendarioId getPrimaryKeyCalendario() {
		return primaryKeyCalendario;
	}
	
	


	public Calendario() {
		super();
	}
	
	

	public void setPrimaryKeyCalendario(CalendarioId primaryKeyCalendario) {
		this.primaryKeyCalendario = primaryKeyCalendario;
	}

	public Integer getJornada() {
		return jornada;
	}

	public void setJornada(Integer jornada) {
		this.jornada = jornada;
	}

	public Integer getResultadoEquipoA() {
		return resultadoEquipoA;
	}

	public void setResultadoEquipoA(Integer resultadoEquipoA) {
		this.resultadoEquipoA = resultadoEquipoA;
	}

	public String getResultadoEquipoB() {
		return resultadoEquipoB;
	}

	public void setResultadoEquipoB(String resultadoEquipoB) {
		this.resultadoEquipoB = resultadoEquipoB;
	}

	public Equipo getEquipoA() {
		return equipoA;
	}

	public void setEquipoA(Equipo equipoA) {
		this.equipoA = equipoA;
	}

	public Equipo getEquipoB() {
		return equipoB;
	}

	public void setEquipoB(Equipo equipoB) {
		this.equipoB = equipoB;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(primaryKeyCalendario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Calendario)) {
			return false;
		}
		Calendario other = (Calendario) obj;
		return Objects.equals(primaryKeyCalendario, other.primaryKeyCalendario);
	}

	@Override
	public String toString() {
		return "Calendario [primaryKeyCalendario=" + primaryKeyCalendario + ", jornada=" + jornada
				+ ", resultadoEquipoA=" + resultadoEquipoA + ", resultadoEquipoB=" + resultadoEquipoB + ", equipoA="
				+ equipoA + ", equipoB=" + equipoB + ", actividad=" + actividad + "]";
	}
	
}
