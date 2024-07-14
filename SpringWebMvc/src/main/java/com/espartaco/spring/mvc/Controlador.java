package com.espartaco.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controlador {
	

	@RequestMapping("/")
	public String muestraPagina() {
		
		return "index";
		
	}

}
