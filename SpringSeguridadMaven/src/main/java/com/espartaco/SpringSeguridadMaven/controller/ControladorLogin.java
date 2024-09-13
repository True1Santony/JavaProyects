package com.espartaco.SpringSeguridadMaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorLogin {
	
	@GetMapping("/login")
	public String muestraLogin() {
		
		return "login";
	}

}
