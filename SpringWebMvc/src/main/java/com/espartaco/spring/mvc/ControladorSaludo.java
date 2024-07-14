package com.espartaco.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorSaludo {
	
	private final static String EMPRESA_NUEVA="(Esta empresa acaba de darse de alta)";

	@RequestMapping("/muestraFormulario")
	public String muestraFormulario() {
		
		return "formulario";
		
	}
	@RequestMapping("/procesaFormulario")
	public String procesaFormulario() {
		
		return "formularioProcesado";
		
	}
	@RequestMapping("/procesaFormulario1")
	public String procesaFormulario1(HttpServletRequest request, Model model) {
		
		//recupero los campor del formulario
		String nombre=request.getParameter("nombreEmpresa");
		
		String procesado = nombre+=EMPRESA_NUEVA;
		
		//agrego nuevos datos al modelo
		
		model.addAttribute("empresaNueva", procesado);
		
		return "formularioProcesado";
		
	}
	
	
	
}