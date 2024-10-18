package com.espartaco.proyectoRest.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // indica que la clase es un controlador restfull, las respuestas pasan a json o xml, como cuerpo http
@RequestMapping("/prueba")
public class RestControlador {

	@GetMapping("/saludo")
	public String saludoPrueba() {
		
		return "Pagina de prueba que no devielve un .html o .jsp, solo este texto";
	}
	
}
