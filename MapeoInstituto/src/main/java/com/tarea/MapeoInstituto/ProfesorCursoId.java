package com.tarea.MapeoInstituto;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProfesorCursoId implements Serializable {

	    public ProfesorCursoId() {
		super();
	}

		public ProfesorCursoId(Integer profesorId, Integer cursoId) {
		super();
		this.profesorId = profesorId;
		this.cursoId = cursoId;
	}

		@Column(name = "Profesor")
	    private Integer profesorId;

	    @Column(name = "Curso")
	    private Integer cursoId;

		public Integer getProfesorId() {
			return profesorId;
		}

		public void setProfesorId(Integer profesorId) {
			this.profesorId = profesorId;
		}

		public Integer getCursoId() {
			return cursoId;
		}

		public void setCursoId(Integer cursoId) {
			this.cursoId = cursoId;
		}

		@Override
		public int hashCode() {
			return Objects.hash(cursoId, profesorId);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof ProfesorCursoId)) {
				return false;
			}
			ProfesorCursoId other = (ProfesorCursoId) obj;
			return Objects.equals(cursoId, other.cursoId) && Objects.equals(profesorId, other.profesorId);
		}

		@Override
		public String toString() {
			return "ProfesorCursoId [profesorId=" + profesorId + ", cursoId=" + cursoId + "]";
		}
	
}
