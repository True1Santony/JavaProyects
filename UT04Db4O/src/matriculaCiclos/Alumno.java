package matriculaCiclos;

import java.util.ArrayList;

public class Alumno {
	private String dni;
	private String nmatricula;
	private String nombre;
	private String ape1;
	private String ape2;
	ArrayList<AlumnoModulo> moduloNota;
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alumno(String dni, String nmatricula, String nombre, String ape1, String ape2) {
		super();
		this.dni = dni;
		this.nmatricula = nmatricula;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.moduloNota=new ArrayList<AlumnoModulo>();
		
	}
	public ArrayList<AlumnoModulo> getModuloNota() {
		return moduloNota;
	}
	public void setModuloNota(ArrayList<AlumnoModulo> moduloNota) {
		this.moduloNota = moduloNota;
	}
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nmatricula=" + nmatricula + ", nombre=" + nombre + ", ape1=" + ape1 + ", ape2="
				+ ape2 + "]";
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNmatricula() {
		return nmatricula;
	}
	public void setNmatricula(String nmatricula) {
		this.nmatricula = nmatricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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

}
