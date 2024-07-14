package com.espartaco.spring.mvc;

public class Empresa {
	
	
	private String localidad;
	private String nombre;
	private String tipoEmpresa;//sa, sau...
	
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

}
