package com.espartaco.pruebaannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotations {

	public static void main(String[] args) {
		
		//cargo la configuracion
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//lectura de clase de configuracion
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuracion.class);
		
		//pedir un bean
		IEmpleados espartaco  = context.getBean("comercialExperimentado", IEmpleados.class);
		
		
		//usar el bean
		System.out.println(espartaco.getInforme()+"\n"+ espartaco.getTareas());
		
		System.out.println("--------------Prototype objetos distintos, apuntado a memoria distinto--------------------------");
		
		IEmpleados cesar  = context.getBean("comercialExperimentado", IEmpleados.class);

		if(espartaco==cesar) {
			
			System.out.println("Apunta a la misma seccion en memoria (Singleton)");
			
		}else {
			
			System.out.println("Apunta a distintas secciones de memoria (Prototype)");
			
		}
		
		context.close();

	}

}
