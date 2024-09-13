package com.espartaco.SpringSeguridadMaven.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


/**
 * Registro de Filtros: Al extender AbstractSecurityWebApplicationInitializer, 
 * Spring Security se encarga de registrar el filtro de seguridad (SpringSecurityFilterChain) 
 * en el contenedor de servlets (como Tomcat, Jetty, etc.). 
 * Este filtro es responsable de aplicar las configuraciones de seguridad definidas en la aplicación.
 * Intercepta las peticiones http
 *
 * Configuración Automática: La clase AbstractSecurityWebApplicationInitializer se asegura de que el filtro de seguridad se registre con la cadena de filtros del contenedor web,
 * lo que permite que las configuraciones de seguridad de Spring se apliquen a todas las solicitudes HTTP.
 */
public class SeguridadInicializador extends AbstractSecurityWebApplicationInitializer {

	

}
