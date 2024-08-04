package com.espartaco.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.espartaco.DAO.IclienteDAO;
import com.espartaco.controladorEntity.Cliente;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	@Autowired
	private IclienteDAO clienteDAO;
	
	@RequestMapping("/lista")
	public String listaClientes(Model modelo) {
		
		//obtener desde DAO
		List<Cliente> clientes = clienteDAO.getClientes();
		
		//agregar a los clinetes al modelo
		modelo.addAttribute("clientes", clientes);
		
		return"lista-clientes";
		
	}
	
	@RequestMapping("/formularioAgregarCliente")
	public String muestraFormularioAgregar(Model model) {
		
		
		return "formularioNuevoCliente";
	}
	
}
