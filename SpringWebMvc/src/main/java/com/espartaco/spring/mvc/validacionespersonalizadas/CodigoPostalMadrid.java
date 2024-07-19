package com.espartaco.spring.mvc.validacionespersonalizadas;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=CodigoPostalMadridValidacion.class)//contiene la lógica de la validación, la clase que la implementa
@Target({ElementType.METHOD, ElementType.FIELD})//validacion para metodos y campos
@Retention(RetentionPolicy.RUNTIME)//cuando se va a chequear la validacion, runtime en tiempo de ejecucion.
public @interface CodigoPostalMadrid {

	public String value() default "28";

	public String message() default "El codigo postal de Madrid empieza por 28...";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
