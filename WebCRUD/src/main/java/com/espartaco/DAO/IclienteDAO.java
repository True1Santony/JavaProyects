package com.espartaco.DAO;

import java.util.List;

import com.espartaco.controladorEntity.Cliente;

public interface IclienteDAO {

	public List<Cliente> getClientes();

	public void insertarCliente(Cliente cliente);

	public Cliente getCliente(int id);

	public void eliminarCliente(int id);
	
}
