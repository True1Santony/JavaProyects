package com.espartaco.controladorEntity;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * Especifica la ruta completa al point
 * 
 */
@Aspect
@Component
@Order(1)
public class RequisitosClienteAspect {

	
	/**
	 * 
	 * @param cliente se espera recibir un args de tipo Cliente en etiquetas de Before y After
	 * si no se conoce el tipo de argumento usar JoinPoint como parametro del metodo en vez del Cliente
	 * y posterirmente castearlo.
	 * @throws Exception
	 */
	@Before("com.espartaco.controladorEntity.ClienteDAOAspect.poinReutilizacion() && args(cliente)")
    public void requisitosCliente(Cliente cliente) throws Exception {
    	
    	if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            throw new Exception("*ASPECT* El nombre del cliente es obligatorio.");
        }
    	
    	
    	System.out.println("*1*ASPECT* Requisitos del cliente cumplidos, procediendo con la inserción.");
    	System.out.println(cliente);
    }
	
}
