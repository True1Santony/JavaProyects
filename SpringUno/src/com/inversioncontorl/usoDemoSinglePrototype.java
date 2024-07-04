package com.inversioncontorl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class usoDemoSinglePrototype {

	public static void main(String[] args) {
		
		// cargo el xml de configuracion
		ClassPathXmlApplicationContext contexto= new ClassPathXmlApplicationContext("applicationContext2.xml");

		//peticion de beans al contenedor de Spring
		
		Empleados jose = contexto.getBean("miSecretario", Empleados.class);
		Empleados pedro = contexto.getBean("miSecretario", Empleados.class);
		
		System.out.println(jose+"\n"+(SecretarioEmpleado)pedro);
		
	}

}
