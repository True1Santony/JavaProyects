package com.espartaco.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/principal")
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
	
	/**
	 * Método que se ejecuta para validar el formulario, se ejecuta tras pulsar enviar.
	 * @param nombre
	 * @param model
	 * @return
	 */
	@RequestMapping("/procesaFormulario1")
	public String procesaFormulario1(@RequestParam("nombreEmpresa") String nombre, Model model) {
		
		//recupero desde el formulario con variable "nombreEmpresa" en String nombre (binding request)
		//en vez de httpservletrequest.class  
		String procesado = nombre+=EMPRESA_NUEVA;
		
		//agrego nuevos datos al modelo
		
		model.addAttribute("empresaNueva", procesado);
		
		return "formularioProcesado";
		
	}
	
	
	
}
