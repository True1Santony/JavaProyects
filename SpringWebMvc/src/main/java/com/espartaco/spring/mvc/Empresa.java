package com.espartaco.spring.mvc;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Empresa {
	
	
	private String localidad;
	
	@NotNull
	@NotBlank
	@Size(min=3, message="Campo requerido")
	private String nombre;
	
	private String tipoEmpresa;//sa, sau...
	private String ciudadEmpresa;
	private String diaAtencion;
	
	
	@Valid
    @NotNull(message="Debe proporcionar la información de contacto")
	private ContactoEmpresa contactoEmpresa;
	
	@Valid
	private DireccionEmpresa direccion;
	
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoEmpresa() {
		return tipoEmpresa;
	}
	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}
	//se llama desde la pagina de confirmacionRegistroEmporesa
	public String getCiudadEmpresa() {
		
		if(ciudadEmpresa == null || ciudadEmpresa.equals("")) {
			ciudadEmpresa = "No se ha escogido NINGUNA CIUDAD";
		}
		
		return ciudadEmpresa;
	}
	//metodo llamado desde los radiobutons a traves de path, tienen que coincidir el nombre del metodo y la propiedad
	public void setCiudadEmpresa(String ciudadEmpresa) {
		this.ciudadEmpresa = ciudadEmpresa;
	}
	public String getDiaAtencion() {
		return diaAtencion;
	}
	public void setDiaAtencion(String diaAtencion) {
		this.diaAtencion = diaAtencion;
	}
	public ContactoEmpresa getContactoEmpresa() {
		return contactoEmpresa;
	}
	public void setContactoEmpresa(ContactoEmpresa contactoEmpresa) {
		this.contactoEmpresa = contactoEmpresa;
	}
	public DireccionEmpresa getDireccion() {
		return direccion;
	}
	public void setDireccion(DireccionEmpresa direccion) {
		this.direccion = direccion;
	}

}
