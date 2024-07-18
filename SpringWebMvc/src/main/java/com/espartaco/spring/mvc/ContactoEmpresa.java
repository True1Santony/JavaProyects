package com.espartaco.spring.mvc;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ContactoEmpresa {

	
	
	
	@NotNull
	@NotBlank
	@Size(min=3, message="Campo requerido")
	private String nombre;
	
	@Min(value=18, message="Tiene que ser mayor de edad")
	@Max(value=100, message="Edad no válida.")
	private int edad;
	
	@Email
	private String mail;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
