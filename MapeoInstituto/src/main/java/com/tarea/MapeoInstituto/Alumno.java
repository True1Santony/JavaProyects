package com.tarea.MapeoInstituto;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/*Alumno apunta a Curso, pero Curso no apunta a Alumno
 * ManyToOne y ya esta
 * 
 */
@Entity
@Table(name="Alumnos")
@NamedQueries({
	@NamedQuery(name = "Alumno.buscaTodosOrdenadosPorExpediente", query = "SELECT a FROM Alumno a ORDER BY a.expediente"),
	@NamedQuery(name = "Alumno.buscaPorApellidoPattern", query = "SELECT a FROM Alumno a WHERE a.apellidos LIKE :apellidoPattern")
	})
public class Alumno {

	@Id
	@Column(name="Expediente")
	private Integer expediente;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Apellidos")
	private String apellidos;
	
	@Column(name = "Grupo")//es el IdCurso de Cursos
	private Integer grupo;
	
	@Column(name = "FechaNacimiento")
	@Temporal(TemporalType.DATE)//la fecha sin hora
	private Date fechaNacimineto;
	
	@ManyToOne
	@JoinColumn(name="Grupo", referencedColumnName="IdCurso", insertable=false, updatable=false)
	//se usará el campo Grupo de la tabla Alumnos como FK y hace referencia a IdCurso de la tabla Cursos
	private Curso curso;

	public Integer getExpediente() {
		return expediente;
	}

	public void setExpediente(Integer expediente) {
		this.expediente = expediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getGrupo() {
		return grupo;
	}

	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

	public Date getFechaNacimineto() {
		return fechaNacimineto;
	}

	public void setFechaNacimineto(Date fechaNacimineto) {
		this.fechaNacimineto = fechaNacimineto;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Alumno [expediente=" + expediente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", grupo="
				+ grupo + ", fechaNacimineto=" + fechaNacimineto + ", curso=" + curso + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(expediente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Alumno)) {
			return false;
		}
		Alumno other = (Alumno) obj;
		return Objects.equals(expediente, other.expediente);
	}
	
}
