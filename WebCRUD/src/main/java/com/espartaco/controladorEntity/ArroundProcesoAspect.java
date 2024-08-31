package com.espartaco.controladorEntity;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**Logging Seguridad
 * Procesado de datos antes de ejecutar el metodo y despues
 * Auditoria, tiempo de ejecucion
 * 
 */
@Component
@Aspect
@Order(5)
public class ArroundProcesoAspect {

	
	/**
	 * Se hace con el proceso, lo ejecuta y devuelve el tiempo de ejecucion y el objeto al metodo original.
	 * @param joinPoint realiza la ejecucion del proceso, la captura del objeto y su devolucion.
	 * @return devuelve el objeto del proceso original.
	 */
	@Around("execution(* com.espartaco.DAO.*.getClientes(..))")
	public Object mideTiempoEjecucion(ProceedingJoinPoint joinPoint) {
		
		long tiempoInicio = System.currentTimeMillis();
		
		Object resultado= null;
		
		try {
			resultado = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}finally {
			
			long tiempoFinal = System.currentTimeMillis();
			
			long duracion = tiempoFinal - tiempoInicio;
			
			System.out.println("*5*Tiempo de ejecucion de " + joinPoint.getSignature()+ " ha sido de: "+ duracion );
			
		}
		
		return resultado;
		
	}
	
}
