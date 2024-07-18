package com.espartaco.spring.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/empresa")
public class ControladorEmpresa {

	@RequestMapping("/muestraFormulario")
	public String muestraFormulario(Model model) {
		
		//se registra un objeto con los parametros a llevar a la segunda vista
		Empresa empresa = new Empresa();
		empresa.setContactoEmpresa(new ContactoEmpresa());
		empresa.setDireccion(new DireccionEmpresa());
		model.addAttribute("laEmpresa", empresa);
		
		return "formularioRegistroEmpresa";
		
	}
	
	
	/**
	 *  Método que se ejecuta para validar el formulario, se ejecuta tras pulsar enviar. @Valid
	 * @param empresa
	 * @param resultadoValidacion Antes de ser invocado estan los resultados de la validacion de los campos a validar de Empresa.class
	 * @return
	 */
	@RequestMapping("/muestraFormularioProcesado")
	public String muestraFormularioProcesado(@Valid @ModelAttribute("laEmpresa")Empresa empresa, BindingResult resultadoValidacion) {
		
		if(resultadoValidacion.hasErrors()) {//si hay errores devuelve el formulario de registro
			
			return "formularioRegistroEmpresa";
			
		}else {
		
		return "confirmacionRegistroEmpresa";
		
		}
		
	}
	
	
}
