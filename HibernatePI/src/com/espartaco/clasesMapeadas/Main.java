package com.espartaco.clasesMapeadas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
        org.hibernate.Session session = sf.openSession();
        
        try {
        	
        	//insertaCliente(session, new Clientes("Paco", "Mozo", "Calle de los palos"));
        	
        	consultaClientePorID(session, 1);
        	
        }finally {
        	
        	session.close();
        	
        }
        
        
	}
	
	
	public static void consultaClientePorID(Session session, int id) {
		
		Clientes cliente1 = new Clientes();
		
    	cliente1.setId(id);
    	
    	session.beginTransaction();
    	
    	Clientes clienteInsertado = session.get(Clientes.class, cliente1.getId());
    	
    	System.out.println("Registro : "+ clienteInsertado);
    	
    	session.getTransaction().commit();
		
	}
	
	
	public static void insertaCliente(Session session, Clientes clinete) {
		
		session.beginTransaction();
    	
    	session.save(clinete);
    	
    	session.getTransaction().commit();
    	
    	System.out.println("Insertado");
		
	}

}
