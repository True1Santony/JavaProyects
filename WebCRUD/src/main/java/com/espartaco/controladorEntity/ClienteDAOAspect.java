package com.espartaco.controladorEntity;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ClienteDAOAspect {

    @Before("execution(* com.espartaco.DAO.ClienteDAO.insertarCliente(..))")
    public void antesDeInsertarCliente() {
        System.out.println("Antes de insertar un clienteDAO y en el paquete indicado.");
    }
}