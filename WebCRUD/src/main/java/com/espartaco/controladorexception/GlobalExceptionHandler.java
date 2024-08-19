package com.espartaco.controladorexception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler(Exception.class)
	    public String handleException(Exception ex, RedirectAttributes redirectAttributes) {
	    	
	    	ex.printStackTrace();
	    	
	        redirectAttributes.addFlashAttribute("mensaje", "Faltan datos o son incorrectos");
	        return "redirect:/cliente/formularioAgregarCliente";
	    }
	
}
