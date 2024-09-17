package com.espartaco.SpringSeguridadMaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

	@GetMapping("/")
    public String redirectToInicio() {
        return "redirect:inicio";  // Redirige a /inicio cuando el usuario accede a /
    }

    @GetMapping("/inicio")
    public String muestraInicio() {
        return "inicio";  // Muestra la vista inicio.jsp
    }
	
	
	/**
	 * ruta para administradores
	 */
	@GetMapping("/administradores")
	public String muestraAdministradores() {
		
		return "administradores";
	}
	
	@GetMapping("/managers")
	public String muestraManagers() {
		
		return "managers";
	}
	
	@GetMapping("/usuarios")
	public String muestraUsuarios() {
		
		return "usuarios";
	}
	
	/**
	 * ruta DENEGAR ACCESO
	 */
	@GetMapping("/notacces")
	public String muestraDenegado() {
		
		return "notacces";
	}
	
	
}
