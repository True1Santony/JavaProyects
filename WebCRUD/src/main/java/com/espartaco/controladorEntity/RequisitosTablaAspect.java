package com.espartaco.controladorEntity;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class RequisitosTablaAspect {

	 @Before("com.espartaco.controladorEntity.ClienteDAOAspect.poinReutilizacion()")
	    public void requisitosTabla() {
	    	
	    	System.out.println("*2*ASPECT* Hay espacio en la tabla");
	    	
	    }
	
}
