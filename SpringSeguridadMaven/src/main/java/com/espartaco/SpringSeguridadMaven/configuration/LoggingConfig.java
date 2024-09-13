package com.espartaco.SpringSeguridadMaven.configuration;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class LoggingConfig {

	 @PostConstruct
	    public void init() {
	        // Configura el nivel de logging para las categorías especificadas
	        ((ch.qos.logback.classic.Logger) LoggerFactory.getLogger("org.springframework.security")).setLevel(ch.qos.logback.classic.Level.DEBUG);
	        ((ch.qos.logback.classic.Logger) LoggerFactory.getLogger("org.springframework.web.servlet")).setLevel(ch.qos.logback.classic.Level.DEBUG);
	        ((ch.qos.logback.classic.Logger) LoggerFactory.getLogger("org.springframework.web")).setLevel(ch.qos.logback.classic.Level.DEBUG);
	    }
	
}
