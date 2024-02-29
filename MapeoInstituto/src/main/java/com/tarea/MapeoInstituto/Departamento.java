package com.tarea.MapeoInstituto;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/*
 * El departamento contiene los profesores y los profesores tienen los set de las demas tablas
 * relaccionadas por OneToMany
 */
@Entity
@Table(name = "Departamentos")
public class Departamento {

	public Departamento() {
		super();
	}

	public Departamento(Integer idDepartamento, String nombre, Set<Profesor> profesores) {
		super();
		this.profesores=profesores;
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
	}

	@Id
    @Column(name = "IdDepartamento")
    private Integer idDepartamento;

    @Column(name = "Nombre")
    private String nombre;
    
    @OneToMany(mappedBy="departamento")//se relacciona con el atributo Departamento departamento de la clase Profesor
    private Set<Profesor> profesores;

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDepartamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Departamento)) {
			return false;
		}
		Departamento other = (Departamento) obj;
		return Objects.equals(idDepartamento, other.idDepartamento);
	}

	@Override
	public String toString() {
		return "Departamento [idDepartamento=" + idDepartamento + ", nombre=" + nombre + "]";
	}

	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}
	
}
