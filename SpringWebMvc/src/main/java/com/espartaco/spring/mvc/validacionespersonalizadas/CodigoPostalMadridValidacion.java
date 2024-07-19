package com.espartaco.spring.mvc.validacionespersonalizadas;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CodigoPostalMadridValidacion implements ConstraintValidator<CodigoPostalMadrid, String> {

	private String prefijoCPMadrid;
	
	@Override
	public void initialize(CodigoPostalMadrid codigoPostal) {
		
		prefijoCPMadrid=codigoPostal.value();
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		
		boolean codigoOK;
		
		if(arg0!=null) {
			codigoOK=arg0.startsWith(prefijoCPMadrid);//comprueba si el cp del usuario empieza por 28
		}else {
			codigoOK=true;
		}
		
		return codigoOK;
	}
	

}
