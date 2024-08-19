package com.espartaco.controladorEntity;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.espartaco.DAO.IclienteDAO;

@Aspect
@Component
public class ClienteDAOAspect {
	
	@Autowired
    private IclienteDAO clienteDAO;
	
	
	@Pointcut("execution(public * com.espartaco.DAO.ClienteDAO.insertarCliente(..))")
	private void poinReutilizacion() {
		
	}
	

    @Before("poinReutilizacion()")
    public void antesDeInsertarCliente() {
        System.out.println(" *ASPECT* Antes de insertar un clienteDAO y en el paquete indicado.");
    }
    
    @Before("poinReutilizacion()")
    public void requisitosTabla() {
    	
    	System.out.println("Hay espacio en la tabla");
    	
    }
    
    @Before("poinReutilizacion() && args(cliente)")
    public void requisitosCliente(Cliente cliente) throws Exception {
    	
    	if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            throw new Exception("El nombre del cliente es obligatorio.");
        }
    	
    	
    	System.out.println("Requisitos del cliente cumplidos, procediendo con la inserción.");
    }
    
    
}