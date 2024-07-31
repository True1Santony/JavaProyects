package com.espartaco.hibernatePI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.espartaco.clasesMapeadas.Clientes;
import com.espartaco.clasesMapeadas.Detalles_cliente;
import com.espartaco.clasesMapeadas.Pedido;


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
        	
        	//insertaNuevoClienteConDetalles(session,"Arnold","Swarchneger","Calle California 54 ","www.regresoalpasado.com", "659645856", "Hasta la Vista Baby");
        	
        	//eliminaClienteConDetallesPorID(session,23);
        	
        	//consultaDetalleCliente(session, 1);
        	
        	//eliminaDetallesCliente(session,10);
        	
        	/*ArrayList<Pedido> pedidos= new ArrayList();
        	
        	Pedido pedido1=new Pedido (new Date(124,6,5));
        	Pedido pedido2=new Pedido (new Date(124,6,6));
        	Pedido pedido3=new Pedido (new Date(124,6,7));
        	
        	pedidos.add(pedido1);
        	pedidos.add(pedido2);
        	pedidos.add(pedido3);
        	
        	insertaPedidoAlCliente(session, 26, pedidos);*/
        	
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
	  
	  public static void consultaDetalleCliente(Session session, int idDetalles) {
		  
		  session.beginTransaction();
		  
		  Detalles_cliente detalles = session.get(Detalles_cliente.class, idDetalles);
		  
		  System.out.println(detalles);
		  
		  System.out.println(detalles.getCliente());
		  
		  session.close();
		  
	  }
	  
  public static void eliminaDetallesCliente(Session session, int idDetalles) {
		  
		  Transaction transaction= null;
		  
		  try {
			  
			  transaction = session.beginTransaction();
			  
			  Detalles_cliente detalle = session.get(Detalles_cliente.class, idDetalles);
			  
			  session.delete(detalle);
			  
			  transaction.commit();
			  
			  System.out.println("COMMIT, borrado");
			  
		  }catch(Exception e){
			  
			  e.printStackTrace();
			  
			  System.out.println("ROLLBACK, no se ha eliminado");
			  
			  transaction.rollback();
		  }
		  
	  }
  
 /**
  *  
  * @param session
  * @param idCliente
  * @param fecha new date(año,mes, dia) el año es 1900 + el numero a alcanzar el año deseado 124=2024-1900
  */
  public static void insertaPedidoAlCliente(Session session, int idCliente, Date fecha) {
	  
	  session.beginTransaction();
	  
	  Clientes cliente = session.get(Clientes.class, idCliente);// recupero al cliente solicitado
	  
	  Pedido pedido = new Pedido(fecha);
	  
	  cliente.agregaPedido(pedido);
	  
	  session.save(pedido);
	  
	  session.getTransaction().commit();
  }
  
  /**
   * Metodo sobrecargado que acepta varios pedidos.
   * @param session
   * @param idCliente
   * @param pedido
   */
 public static void insertaPedidoAlCliente(Session session,int idCliente, List<Pedido> pedidos) {
	  
	 session.beginTransaction();
	  
	    Clientes cliente = session.get(Clientes.class, idCliente); // Recupero al cliente solicitado
	    
	    for (Pedido pedido : pedidos) {
	        cliente.agregaPedido(pedido); // Agrega cada pedido al cliente
	        session.save(pedido); // Guarda cada pedido individualmente
	    }
	  
	    session.save(cliente); // Guarda el cliente después de agregar todos los pedidos
	  
	    session.getTransaction().commit();
	
  }
	  
	

}
