package com.inversioncontorl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoEmpleados {

	public static void main(String[] args) {
		

		/*Empleados Empleado1 = new DirectorEmpleado();
		
		System.out.println(Empleado1.getTareas());
		*/
		
		//contexto que genera los beans
		ClassPathXmlApplicationContext contexto= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//pedir el bean
		//inversion of control desde applicationContext.xml
		Empleados espartaco = contexto.getBean("miEmpleado", Empleados.class);
		
		System.out.println(espartaco.getTareas());
		
		
		// Dependecy Injection D.I.
		//Modularizar las dependencias, al cambiar en el archivo el timo de objeto se le inyecta El informe correspondiente
		
		System.out.println(espartaco.getInforme());
		
		
		System.out.println("------------------hasta aqui inyeccion por constructor, a continuacion por setter---------------------------");
		
		Empleados jose = contexto.getBean("miSecretario", Empleados.class);
		
		System.out.println(jose.getInforme()+"\n"+ jose.getTareas());
		
		System.out.println("--------------------hasta aqui inyeccion por setter, a continuacion inyeccion de campos--------------");
		
		
		Empleados secretario = contexto.getBean("miSecretario", Empleados.class);
		
		System.out.println(secretario.getTareas()+"\n"+ secretario.getInforme()+"\n"+((SecretarioEmpleado)secretario).getMail()+"\n"+((SecretarioEmpleado)secretario).getNombreEmpresa());
		
		contexto.close();

		
	}

}
