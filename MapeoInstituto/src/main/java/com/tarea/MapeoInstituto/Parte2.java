package com.tarea.MapeoInstituto;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Parte2 {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();
	      Session session = sessionFactory.getCurrentSession();
	      
	      Transaction transaction = session.beginTransaction();
	      
	      List<Alumno> alumnos = session.createNamedQuery("Alumno.buscaTodosOrdenadosPorExpediente",Alumno.class).getResultList();
	      
	      for(Alumno alumno:alumnos) {
	    	  
	    	  System.out.println(alumno);
	      }
	      
	      
	      Scanner scanner=new Scanner(System.in);
	      System.out.println("Introduzca un apellido de profesor a buscar:");
	      
	      String apellidoPattern=scanner.nextLine();
	      apellidoPattern="%"+apellidoPattern+"%";
	      
	      List<Profesor> profesores = session
	          .createNamedQuery("Profesor.buscaPorApellidoPattern", Profesor.class)
	          .setParameter("apellidoPattern", apellidoPattern)
	          .getResultList();
	      
	      for(Profesor profesor:profesores) {
	    	  
	    	  System.out.println(profesor);
	      }
	      /*List<Calendario> eventos=session.createNamedQuery("Calendario.listaOrdenada", Calendario.class).getResultList();
	      
	      for(Calendario evento:eventos) {
	    	  
	    	  System.out.println(evento);
	    	  
	      }error porqu edevuelve Object[]*/
	      List<Object[]> eventos = session.createNamedQuery("Calendario.listaOrdenada", Object[].class).getResultList();

	      for (Object[] evento : eventos) {
	    	    System.out.println("Nombre de la actividad: " + evento[0]);
	    	    System.out.println("Nombre del Equipo A: " + evento[1]);
	    	    System.out.println("Nombre del Equipo B: " + evento[2]);
	    	    System.out.println("Fecha: " + evento[3]);
	    	    System.out.println("Hora: " + evento[4]);
	    	    System.out.println("Lugar: " + evento[5]);
	    	    System.out.println("----------------------");
	    	}
	      
	      
	      System.out.println("Introduzca deporte a buscar:");
	      
	      String deportePattern=scanner.nextLine();
	      deportePattern="%"+deportePattern+"%";
	      
	      System.out.println(deportePattern);
	      List<Object[]> resultados = session.createNamedQuery("Calendario.resultadosPorDeporte", Object[].class)
                  .setParameter("deporte", deportePattern)
                  .getResultList();

						for (Object[] resultado : resultados) {
							System.out.println(resultado);
								System.out.println("Fecha: " + resultado[0]);
								System.out.println("Hora: " + resultado[1]);
								System.out.println("Equipo A: " + resultado[2]);
								System.out.println("Equipo B: " + resultado[3]);
								System.out.println("Resultado Equipo A: " + resultado[4]);
								System.out.println("Resultado Equipo B: " + resultado[5]);
								System.out.println("----------------------");
						}
	      sessionFactory.close();
	      session.close();
		

	}

}
