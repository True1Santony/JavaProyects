package org.apache.maven.MapeoDB;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="ALUMNOS")
public class Alumno {
	
	 @Id
	    @Column(name = "DNI")
	    private int dni;

	    @Column(name = "NMATRICULA", unique = true)
	    private int nMatricula;

	    @Column(name = "APE1", nullable = false)
	    private String ape1;

	    @Column(name = "APE2", nullable = false)
	    private String ape2;

	    @Column(name = "NOMBRE", nullable = false)
	    private String nombre;

	    @Column(name = "FECNA")
	    @Temporal(TemporalType.DATE)
	    private Date fecna;

	    @Column(name = "DIRECCION")
	    private String direccion;

	    @Column(name = "POBLA")
	    private String poblacion;

	    @Column(name = "PROVINCIA")
	    private String provincia;

	    @Column(name = "CP")
	    private int cp;

	    @Column(name = "TEL")
	    private int tel;

	    @Column(name = "TMOVIL")
	    private Integer tMovil;//para que acepte nulos

	    @Column(name = "EMAIL")
	    private String email;

	    @Column(name = "AFCT")
	    private String afct;
	    
	    
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getnMatricula() {
		return nMatricula;
	}

	public void setnMatricula(int nMatricula) {
		this.nMatricula = nMatricula;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecna() {
		return fecna;
	}

	public void setFecna(Date fecna) {
		this.fecna = fecna;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public Integer gettMovil() {
		return tMovil;
	}

	public void settMovil(Integer tMovil) {
		this.tMovil = tMovil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAfct() {
		return afct;
	}

	public void setAfct(String afct) {
		this.afct = afct;
	}
    
    

}
