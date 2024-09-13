package com.espartaco.SpringSeguridadMaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

	@GetMapping("/")
	public String muestraInicio() {
		
		return "inicio";
	}
	
	
	
}
