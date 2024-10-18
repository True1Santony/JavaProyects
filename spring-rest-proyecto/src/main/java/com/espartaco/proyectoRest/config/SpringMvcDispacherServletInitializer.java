package com.espartaco.proyectoRest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcDispacherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Array de clases de configuracion, contiene contextos, seguridad , bases de datos, beans ...
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Array de clases especifica del servlet dispacher, capa web controladores.
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {AppConfig.class};
	}

	
	/**
	 * Array de cademas string patrones de url del dispacher, solicitudes manejadas por el 
	 * server
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
