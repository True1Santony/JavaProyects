package com.espartaco.controladorEntity;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(4)
public class AfterProcesoAspect {

	
	/**
	 * Se ejecutara despues de getId, tanto si lanza una excepcion como si no
	 * Para logging, audotoria
	 * @param joinPoint
	 */
	@After("execution(* com.espartaco.DAO.*.getCliente(..))")
	public void procesaDatosAfter(JoinPoint joinPoint) {
		
		System.out.println("*4*ASPECT AFTER TRAS CONSULTA ID");

	}
	
	
}
