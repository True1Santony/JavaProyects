package com.espartaco.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empresa")
public class ControladorEmpresa {

	@RequestMapping("/muestraFormulario")
	public String muestraFormulario(Model model) {
		//se registra un objeto con los parametros a llevar a la segunda vista
		Empresa enmresa = new Empresa();
		
		model.addAttribute("laEmpresa", enmresa);
		
		return "formularioRegistroEmpresa";
		
	}
	
	@RequestMapping("/muestraFormularioProcesado")
	public String muestraFormularioProcesado(@ModelAttribute("laEmpresa")Empresa empresa) {
		
		return "confirmacionRegistroEmpresa";
		
	}
	
	
}
