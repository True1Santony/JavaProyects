package com.espartaco.hibernatePI;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.espartaco.clasesMapeadas.Clientes;
import com.espartaco.clasesMapeadas.Detalles_cliente;


/**
 * Inicia la session de hibernate leyendo el archivo de configuración,
 * lanza 3 métodos de consulta sobre la base de datos.
 * Cierra la session de hibernate.
 * @author espar
 * @version 1.0
 */
public class MainHQL {
	
	private static Scanner scanner= new Scanner(System.in);

	public static void main(String[] args) {


		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
        org.hibernate.Session session = sf.openSession();
        
        try {

        	//imprimeTodosLosClientes(session);
        	
        	//imprimeClientePorApellido(session, "Nassekine");
        	
        	//imprimeClientesPorNombreOapellido(session,"Espartaco","Calle Princesa");
        	
        	//updateClientePorId(session, 1);
        	//imprimeClientePorApellido(session, "Nassekine");
        	
        	//insertaNuevoClienteConDetalles(session,"Marck","Anzony","Av. de la Trifulca","www.losvengadores.com", "659645856", "Poder a topeee");
        	
        	//eliminaClienteConDetallesPorID(session,23);
        	
        }finally {
        	
        	session.close();
        	scanner.close();
        	
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
	  
	  public static void updateClientePorId(Session session, int id) {
	      	
	      	session.beginTransaction();
	      	
	      	Clientes cliente =session.get(Clientes.class, id);
	      	
	      	System.out.println("Que por que nombre quiere aclualizar a: " + cliente);
	      	
	      	String nombre=scanner.nextLine();
	      	
	      	cliente.setNombre(nombre);
		      	
	      	session.getTransaction().commit();
	      	
	      }
	  
	  public static void insertaNuevoClienteConDetalles(Session session,String nombre,String apellido,String direccion,String web, String numero, String comentario) {
		  
		Transaction transaction= null;
		  
		try {
			
			transaction= session.beginTransaction();
			
			Clientes cliente = new Clientes(nombre, apellido, direccion);
	      	
	      	Detalles_cliente detallesCliente = new Detalles_cliente(web,numero,comentario);
	      	
	      	cliente.setDetalles(detallesCliente);
	      	
	      	detallesCliente.setCliente(cliente);
			
	      	session.save(cliente);
	      	
	      	transaction.commit();
			
		}catch(Exception e) {
			
			transaction.rollback();
			
			e.printStackTrace();
			
		}
		  
		
	  }
	  
	  public static void eliminaClienteConDetallesPorID(Session session, int id) {
		  
		  Transaction transaction= null;
		  
		  try {
			  
			  transaction = session.beginTransaction();
			  
			  Clientes cliente = session.get(Clientes.class, id);
			  
			  session.delete(cliente);
			  
			  transaction.commit();
			  
			  System.out.println("COMMIT");
			  
		  }catch(Exception e){
			  
			  e.printStackTrace();
			  
			  System.out.println("ROLLBACK");
			  
			  transaction.rollback();
		  }
		  
	  }
	  
	

}
