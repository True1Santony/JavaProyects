package com.espartaco.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		//agrego al modelo un nuevo cliente.
		Cliente cliente = new Cliente();
		
		model.addAttribute("cliente", cliente);
		
		return "formularioNuevoCliente";
	}
	
	
	/**
	 * Recoge del formularioNuevoCliente los datos del nuevo cliente a insertar en 
	 * el atrituto del modelo e inserta el cliente en la BBDD
	 * @param cliente
	 * @return
	 */
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente cliente, RedirectAttributes redirectAttributes) {
		
		clienteDAO.insertarCliente(cliente);
		
		redirectAttributes.addFlashAttribute("mensaje", "Cliente insertado correctamente");
		
		return "redirect:/cliente/lista";
	}
	
	
}
