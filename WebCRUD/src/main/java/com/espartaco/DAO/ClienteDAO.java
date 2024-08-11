package com.espartaco.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.espartaco.controladorEntity.Cliente;


@Repository
public class ClienteDAO implements IclienteDAO {

	//instancia de sesion de hibernate, crea un Bean por id
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Cliente> getClientes() {
		
		//sesion
		Session session = sessionFactory.getCurrentSession();
		
		//query
		Query<Cliente> query = session.createQuery("FROM Cliente", Cliente.class);
		
		//devolver la query
		List<Cliente> clientes = query.getResultList();
		
		return clientes;
	}

	@Override
	@Transactional
	public void insertarCliente(Cliente cliente) {
		
		Session session = sessionFactory.getCurrentSession();
		
		//insert cliente
		session.saveOrUpdate(cliente);	
	}

	@Override
	@Transactional
	public Cliente getCliente(int id) {
		
		Session session = sessionFactory.getCurrentSession();

		Cliente cliente = session.get(Cliente.class, id);
		
		return cliente;
	}

	@Override
	@Transactional
	public void eliminarCliente(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Cliente cliente = session.get(Cliente.class, id);
		
		session.delete(cliente);
		
		
	}

}
