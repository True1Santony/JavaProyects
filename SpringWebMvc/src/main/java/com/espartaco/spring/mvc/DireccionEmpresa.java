package com.espartaco.spring.mvc;

import javax.validation.constraints.Pattern;

import com.espartaco.spring.mvc.validacionespersonalizadas.CodigoPostalMadrid;

public class DireccionEmpresa {

	//@Pattern(regexp="[0-9]{5}", message="Codigo Postal no válido.")
	@CodigoPostalMadrid
	private String codigoPostal;

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
}
