package com.espartaco.pruebaannotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Spring registra el Bean de la clase sin especificar un id en concreto
 * coge por defecto el nombre de la clase. Para usarlo, a la hora de pedir una instancia 
 * hay que poner en minusculas la primera letra de la clase.
 * Tres formas de inyectar las dependencias. Constructor,metodo y campo de clase
 * 
 * */

@Component
//@Scope("prototype")
public class ComercialExperimentado implements IEmpleados {
	
	//este campo es lo que va a inyectar al objeto Spring
	
	/**
	 * Inyeccion de dependencias con un campo de clase. Usa reflexion.
	 */
	@Autowired
	@Qualifier("informeFinancieroTrim1")//se puede especificar la clase de la que va a obtener la inyeccion
	private ICreacionInformesFinanciero informeFinanciero;
	
	
	

	/**
	 * 1º Opcion: Constuctor que inyecta con annotacions.
	 * @autowired busca si hay alguna clase que implemente la interfaz 
	 * ICreacionInformesFinanciero, si la encuenta obtiene de esa clase la inyeccion de dependencia
	 * Si solo hay un constructor no es necesaria la annotation.
	 * 
	 * @param informeFinanciero
	 */
	/*@Autowired 
	public ComercialExperimentado(ICreacionInformesFinanciero informeFinanciero) {
		
		this.informeFinanciero = informeFinanciero;
		
	}*/
	
	
	/**
	 * 2º Opcion: Inyeccion a traves de un metodo, gracias a autowired se inyecta el metodo de la clase que implementa la interfaz
	 * @param informeFinanciero
	 */
	/*@Autowired
	public void setInformeFinanciero(ICreacionInformesFinanciero informeFinanciero) {
		
		this.informeFinanciero = informeFinanciero;
	}*/

	@Override
	public String getTareas() {
		
		return "Vende por los codos, no va a quedar producto!!!";
	}
	
	/**
	 * El comercial experimentado va a generar un informe de la dependencia InformeFinanciero inyectado por
	 * el constructor.
	 * Devuelve el informe de la clase que implementa la interfaz
	 */
	@Override
	public String getInforme() {
		
		//return "Informe del comercial, las ventas que ha hecho";
		return informeFinanciero.getInformeFinanciero();
	}
	
	/**
	 * Metodo para ejecutar tras creacion del bean
	 */
	@PostConstruct
	public void ejecutaTrasCreacion() {
		
		System.out.println("Me ejecuto tras la creacion del Bean");
		
	}
	
	
	/**
	 * Metodo para ejecutar despues del cierre del contexto de beans
	 */
	@PreDestroy
	public void ejecutaAntesDestruir() {
		
		System.out.println("Me ejecuto antes de cerrar");
		
	}
}
