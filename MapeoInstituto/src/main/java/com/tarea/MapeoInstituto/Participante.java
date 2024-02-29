package com.tarea.MapeoInstituto;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Participantes")
public class Participante {

	public Participante() {
		super();
	}

	public Participante(ParticipanteId id, Alumno alumno) {
		super();
		this.id = id;
		this.alumno = alumno;
	}

	@EmbeddedId
    private ParticipanteId id;

    @ManyToOne
    @JoinColumn(name = "Alumno", referencedColumnName = "Expediente", insertable = false, updatable = false)
    private Alumno alumno;

	public ParticipanteId getId() {
		return id;
	}

	public void setId(ParticipanteId id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Participante)) {
			return false;
		}
		Participante other = (Participante) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", alumno=" + alumno + "]";
	}
	
}
