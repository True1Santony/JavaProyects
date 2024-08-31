package com.espartaco.controladorEntity;

import java.util.List;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.espartaco.DAO.IclienteDAO;

@Aspect
@Component
@Order(3)
public class ClienteDAOAspect {
	
	@Autowired
    private IclienteDAO clienteDAO;
	
	
	@Pointcut("execution(* com.espartaco.DAO.*.*(..))")
	public void poinReutilizacion() {
		
	}
	
	@Pointcut("execution(* com.espartaco.DAO.*.getClientes(..))")
	private void poinGetClientes() {
		
	}
	
	@Pointcut("execution(* com.espartaco.DAO.*.inserta*(..))")
	private void poinEntityInsertaCliente() {
		
	}
	
	/*no es buena idea usar el punto de corte en entidades de tablas
	 * @Pointcut("execution(* com.espartaco.controladorEntity.*.set*(..))")
	private void poinReutilizacionEntitySet() {
		
	}*/
	

    @Before("poinReutilizacion()")
    public void antesDeInsertarCliente() {
        System.out.println(" *3*ASPECT--* Antes de insertar un clienteDAO y en el paquete indicado.");
    }
    
    @Before("poinGetClientes()")
    public void antesDeConsultaParametrosClienteGet() {
        System.out.println(" *3*ASPECT--getClientes* Antes de consultar todos los clientes");
    }
    
    @Before("poinEntityInsertaCliente()")
    public void antesDeConsultaParametrosClienteSet() {
        System.out.println(" *3*ASPECT--Inserta cliente* Antes de INSERTAR UN CLIENTE");
    }
    
    @AfterReturning(pointcut="poinGetClientes()", returning="listaClientes")
    public void despuesDeConsultaTodosClienteGet(List<Cliente> listaClientes) {
    	
        System.out.println(" *3*ASPECT--* DESPUES de consultar todos los clientes");
        
        int index=0;
        
	        for (Cliente cliente : listaClientes) {
				        	
	        	if(cliente.getNombre().equalsIgnoreCase("ESPARTACO")) {index++;}
	        	
			}
        
        System.out.println("Hay "+index+" clientes con el nombre de Espartaco" );
        
    }
}
