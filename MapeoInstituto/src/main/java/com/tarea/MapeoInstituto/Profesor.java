package com.tarea.MapeoInstituto;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Profesores")
@NamedQueries({
    @NamedQuery(name = "Profesor.findAllOrderedById", query = "SELECT p FROM Profesor p ORDER BY p.idProfesor"),
    @NamedQuery(name = "Profesor.buscaPorApellidoPattern",query = "SELECT p FROM Profesor p WHERE p.apellido LIKE :apellidoPattern")
})
public class Profesor {

	

	public Profesor(Integer idProfesor, String nombre, String apellido, String direccion, String ciudad,
			String provincia, String codPostal, Integer idDepartamento, Departamento departamento,
			Set<ProfesorCurso> profesorCursos, Set<Tutoria> tutorias) {
		super();
		this.idProfesor = idProfesor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.codPostal = codPostal;
		this.idDepartamento = idDepartamento;
		this.departamento = departamento;
		this.profesorCursos = profesorCursos;
		this.tutorias = tutorias;
	}

	public Profesor() {
		
	}

	@Id
    @Column(name = "IDProfesor")
    private Integer idProfesor;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Ciudad")
    private String ciudad;

    @Column(name = "Provincia")
    private String provincia;

    @Column(name = "CodPostal")
    private String codPostal;

    @Column(name = "Departamento")
    private Integer idDepartamento;
    
    @ManyToOne
    @JoinColumn(name="Departamento", insertable=false, updatable=false)
    private Departamento departamento;
    
    @OneToMany(mappedBy="profesor")
    private Set<ProfesorCurso> profesorCursos;
    
    @OneToMany(mappedBy="profesor")
    private Set<Tutoria> tutorias;

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProfesor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Profesor)) {
			return false;
		}
		Profesor other = (Profesor) obj;
		return Objects.equals(idProfesor, other.idProfesor);
	}

	

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Set<ProfesorCurso> getProfesorCursos() {
		return profesorCursos;
	}

	public void setProfesorCursos(Set<ProfesorCurso> profesorCursos) {
		this.profesorCursos = profesorCursos;
	}

	public Set<Tutoria> getTutorias() {
		return tutorias;
	}

	public void setTutorias(Set<Tutoria> tutorias) {
		this.tutorias = tutorias;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	@Override
	public String toString() {
		return "Profesor [idProfesor=" + idProfesor + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion="
				+ direccion + ", ciudad=" + ciudad + ", provincia=" + provincia + ", codPostal=" + codPostal
				+ ", idDepartamento=" + idDepartamento + "]";
	}

	
	
}
