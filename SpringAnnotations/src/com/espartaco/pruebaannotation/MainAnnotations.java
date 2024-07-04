package com.espartaco.pruebaannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotations {

	public static void main(String[] args) {
		
		//cargo la configuracion
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//pedir un bean
		IEmpleados espartaco  = context.getBean("comercialExperimentado", IEmpleados.class);
		
		
		//usar el bean
		System.out.println(espartaco.getInforme()+"\n"+ espartaco.getTareas());
		
		context.close();

	}

}
