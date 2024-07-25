package com.espartaco.hibernatePI;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.espartaco.clasesMapeadas.Clientes;


/**
 * Inicia la session de hibernate leyendo el archivo de configuración,
 * lanza 3 métodos de consulta sobre la base de datos.
 * Cierra la session de hibernate.
 * @author espar
 * @version 1.0
 */
public class MainHQL {

	public static void main(String[] args) {


		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
        org.hibernate.Session session = sf.openSession();
        
        try {

        	imprimeTodosLosClientes(session);
        	
        	imprimeClientePorApellido(session, "Nassekine");
        	
        	imprimeClientesPorNombreOapellido(session,"Espartaco","Calle Princesa");
        	
        }finally {
        	
        	session.close();
        	
        }
        
        
	}
	  
	  /**
	   * Devuelve todos los registros de clientes
	   * @param session
	   */
	  public static void imprimeTodosLosClientes(Session session) {
      	
      	session.beginTransaction();
      	
      	List<Clientes> todosLosClientes = session.createQuery("from Clientes").getResultList();
      	
	      	for (Clientes cliente : todosLosClientes) {
					
	      		System.out.println(cliente);
	      		
				}
	      	
      	session.getTransaction().commit();
      	
      }
	  
	  
	  /**
	   * La clausula where usa un alias de la tabla y el campo de la clase java, no de la tabla de la DDBB
	   * @param session
	   * @param apellido
	   */
	  public static void imprimeClientePorApellido(Session session, String apellido) {
	      	
	      	session.beginTransaction();
	      	
	      	List<Clientes> todosLosClientes = session.createQuery("from Clientes cl where cl.apellidos='"+apellido+"'").getResultList();
	      	
		      	for (Clientes cliente : todosLosClientes) {
						
		      		System.out.println(cliente);
		      		
					}
		      	
		      	session.getTransaction().commit();
	      	
	      }
	  
	  
	  /**
	   * Imprime filtrando por nombre o apellido
	   * @param session
	   * @param nombre
	   * @param direccion
	   */
	  public static void imprimeClientesPorNombreOapellido(Session session, String nombre, String direccion) {
	      	
	      	session.beginTransaction();
	      	
	      	List<Clientes> todosLosClientes = session.createQuery("from Clientes cl where cl.nombre='"+nombre+"'"+" or cl.direccion='"+direccion+"'").getResultList();
	      	
		      	for (Clientes cliente : todosLosClientes) {
						
		      		System.out.println(cliente);
		      		
					}
		      	
		      	session.getTransaction().commit();
	      	
	      }
	  
	

}
