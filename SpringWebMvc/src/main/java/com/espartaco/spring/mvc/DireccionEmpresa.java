package com.espartaco.spring.mvc;

import javax.validation.constraints.Pattern;

public class DireccionEmpresa {

	@Pattern(regexp="[0-9]{5}", message="Codigo Postal no válido.")
	private String codigoPostal;

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
}
