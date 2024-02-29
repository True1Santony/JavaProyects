package com.tarea.MapeoInstituto;

import java.util.Objects;

import jakarta.persistence.*;


/*Se le puede agregar el campo OneToMany para un set de Alumno, en caso de necesitar consultar los alumnos pertenecientes a un curso
 * 
 */
@Entity
@Table(name="Cursos")
public class Curso {

	@Id
	@Column(name="IdCurso")
	private Integer idCurso;
	
	@Column(name="Curso")//es el nombre del curso 1A, 2B.... 
	private String curso;

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(curso, idCurso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Curso)) {
			return false;
		}
		Curso other = (Curso) obj;
		return Objects.equals(curso, other.curso) && Objects.equals(idCurso, other.idCurso);
	}

	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", curso=" + curso + "]";
	}
	
}
