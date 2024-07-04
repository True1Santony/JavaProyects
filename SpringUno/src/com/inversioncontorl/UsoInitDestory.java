package com.inversioncontorl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsoInitDestory {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext contexto= new ClassPathXmlApplicationContext("applicationContext3.xml");
		
		Empleados secretario = contexto.getBean("miEmpleado", Empleados.class);
		
		System.out.println(secretario.getInforme());

		contexto.close();
	}

}
