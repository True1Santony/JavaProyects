package com.espartaco.proyectoRest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc //conversion de POJO a Json, config archvos estaticos....
@ComponentScan("com.espartaco.proyectoRest")// busca las anotaciones 
public class AppConfig {

	
	
}
