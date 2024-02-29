package com.tarea.MapeoInstituto;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProfesoresCursos")
public class ProfesorCurso {

	public ProfesorCurso() {
		
	}

	public ProfesorCurso(ProfesorCursoId id, String tutor, Profesor profesor, Curso curso) {
		
		this.id = id;
		this.tutor = tutor;
		this.profesor = profesor;
		this.curso = curso;
	}

	@EmbeddedId
    private ProfesorCursoId id;

    @Column(name = "Tutor")
    private String tutor;

    @ManyToOne
    @JoinColumn(name = "Profesor", referencedColumnName = "IDProfesor", insertable = false, updatable = false)
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "Curso", referencedColumnName = "IdCurso", insertable = false, updatable = false)
    private Curso curso;

	public ProfesorCursoId getId() {
		return id;
	}

	public void setId(ProfesorCursoId id) {
		this.id = id;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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
		if (!(obj instanceof ProfesorCurso)) {
			return false;
		}
		ProfesorCurso other = (ProfesorCurso) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ProfesorCurso [id=" + id + ", tutor=" + tutor + ", profesor=" + profesor + ", curso=" + curso + "]";
	}
}
