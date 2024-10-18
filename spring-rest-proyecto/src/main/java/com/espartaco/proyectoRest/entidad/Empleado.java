package com.espartaco.proyectoRest.entidad;


/**
 * POJO class, no hereda de otras clases o no ligadas a un framework
 */
public class Empleado {

	private String nombre;
	
	private String apellido;

	public Empleado(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Empleado() {
		super();
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
	
	

	
}
