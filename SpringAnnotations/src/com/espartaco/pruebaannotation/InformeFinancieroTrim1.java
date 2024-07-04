package com.espartaco.pruebaannotation;

import org.springframework.stereotype.Component;

/**
 * Registro esta clase Bean en el contenedor de Spring para que 
 * lo pueda usar. Sera inyectado a las clases que se anote  
 */


@Component
public class InformeFinancieroTrim1 implements ICreacionInformesFinanciero {
	
	@Override
	public String getInformeFinanciero() {
		
		return "Presento el informe financiero del trimestre 1";
	}

}
