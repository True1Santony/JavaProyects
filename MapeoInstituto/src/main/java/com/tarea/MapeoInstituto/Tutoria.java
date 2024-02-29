package com.tarea.MapeoInstituto;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tutorias")
public class Tutoria {

	
	public Tutoria() {
		super();
	}

	public Tutoria(Integer idTutoria, Profesor profesor, Curso curso, String diaSemana, String horaTutoria) {
		super();
		this.idTutoria = idTutoria;
		this.profesor = profesor;
		this.curso = curso;
		this.diaSemana = diaSemana;
		this.horaTutoria = horaTutoria;
	}

	@Id
    @Column(name = "IdTutoria")
    private Integer idTutoria;

    @ManyToOne
    @JoinColumn(name = "Profesor", referencedColumnName = "IDProfesor")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "Curso", referencedColumnName = "IdCurso")
    private Curso curso;

    @Column(name = "DiaSemana")
    private String diaSemana;

    @Column(name = "HoraTutoria")
    private String horaTutoria;

	public Integer getIdTutoria() {
		return idTutoria;
	}

	public void setIdTutoria(Integer idTutoria) {
		this.idTutoria = idTutoria;
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

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHoraTutoria() {
		return horaTutoria;
	}

	public void setHoraTutoria(String horaTutoria) {
		this.horaTutoria = horaTutoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTutoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Tutoria)) {
			return false;
		}
		Tutoria other = (Tutoria) obj;
		return Objects.equals(idTutoria, other.idTutoria);
	}

	@Override
	public String toString() {
		return "Tutoria [idTutoria=" + idTutoria + ", profesor=" + profesor + ", curso=" + curso + ", diaSemana="
				+ diaSemana + ", horaTutoria=" + horaTutoria + "]";
	}
}
