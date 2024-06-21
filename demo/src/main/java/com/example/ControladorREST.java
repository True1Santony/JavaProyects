package com.example;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorREST {
	

	@Value("${indice.hola2}")
	private String hola2;
	
	@GetMapping("/")
	public String comienzo(Model model) {
		
		String hola="Probando mensajes";
		
		System.out.println("Ejecutando el controlador MVC, método comienzo");
		
		model.addAttribute("hola", hola);
		model.addAttribute("hola2", hola2);
		
		return "indice";
	}

}
