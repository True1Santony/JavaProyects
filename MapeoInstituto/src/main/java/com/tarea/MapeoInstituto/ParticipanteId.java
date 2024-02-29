package com.tarea.MapeoInstituto;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ParticipanteId implements Serializable {

	    public ParticipanteId() {
		super();
	}

		public ParticipanteId(Integer participanteActividad, Integer participanteEquipo, Integer alumno) {
		super();
		this.participanteActividad = participanteActividad;
		this.participanteEquipo = participanteEquipo;
		this.alumno = alumno;
	}

		@Column(name = "ParticipanteActividad")
	    private Integer participanteActividad;

	    @Column(name = "ParticipanteEquipo")
	    private Integer participanteEquipo;

	    @Column(name = "Alumno")
	    private Integer alumno;

		public Integer getParticipanteActividad() {
			return participanteActividad;
		}

		public void setParticipanteActividad(Integer participanteActividad) {
			this.participanteActividad = participanteActividad;
		}

		public Integer getParticipanteEquipo() {
			return participanteEquipo;
		}

		public void setParticipanteEquipo(Integer participanteEquipo) {
			this.participanteEquipo = participanteEquipo;
		}

		public Integer getAlumno() {
			return alumno;
		}

		public void setAlumno(Integer alumno) {
			this.alumno = alumno;
		}

		@Override
		public int hashCode() {
			return Objects.hash(alumno, participanteActividad, participanteEquipo);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof ParticipanteId)) {
				return false;
			}
			ParticipanteId other = (ParticipanteId) obj;
			return Objects.equals(alumno, other.alumno)
					&& Objects.equals(participanteActividad, other.participanteActividad)
					&& Objects.equals(participanteEquipo, other.participanteEquipo);
		}

		@Override
		public String toString() {
			return "ParticipanteId [participanteActividad=" + participanteActividad + ", participanteEquipo="
					+ participanteEquipo + ", alumno=" + alumno + "]";
		}
}
