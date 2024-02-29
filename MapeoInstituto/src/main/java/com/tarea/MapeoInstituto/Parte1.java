package com.tarea.MapeoInstituto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class Parte1 {

	
	
	public static void main(String[] args) {
		
		  SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();
	      Session session = sessionFactory.getCurrentSession();
	      
	      Transaction transaction = session.beginTransaction();
	      
	      
	      //se piden los datos por teclado, se validan y se da formato a Date.
	      Scanner scanner = new Scanner(System.in);
	      //Pedir por teclado por teclado: id de actividad, fecha, hora y lugar del encuentro y mostrar :
	      System.out.println("Introduce el ID de la actividad(Ej.1):");
          
          String sIdActividad= scanner.nextLine();
          int iIdActividad=0;
          try {
        	  iIdActividad=Integer.parseInt(sIdActividad);
          }catch(Exception e) {
        	  e.printStackTrace();
        	  System.out.println("Tiene que ser un número entero.");
          }
          
          System.out.println("Introduce la fecha (dd/MM/yyyy)(Ej.12/02/2007):");
          String fechaStr = scanner.nextLine();
          System.out.println("Introduce la hora (HH:mm:ss)(Ej. 17:00:00):");
          String hora = scanner.nextLine();
          System.out.println("Introduce el lugar(Ej. Pista 1):");
          String lugar = scanner.nextLine();
          
          
          SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
          Date dataFormateada=null;
          try {
        	  
			dataFormateada = formato.parse(fechaStr);
			
		} catch (ParseException e) {
			
			System.out.println("La fecha es erronea, el formato ha de ser: dd/MM/yyyy ");
			e.printStackTrace();
		}
          
       // Se construye un objeto CalendarioId con los datos proporcionados
          CalendarioId calendarioId = new CalendarioId(iIdActividad, dataFormateada, hora, lugar);

          // Se recupera el calendario utilizando CalendarioId
         Calendario calendario = session.get(Calendario.class, calendarioId);
          
         System.out.println("Nombre de la actividad: " + calendario.getActividad().getActividad()+
        		 				"\n"+calendario.getEquipoA().getNombre()+" vs "+calendario.getEquipoB().getNombre());
         
         Query<Participante> query = session.createQuery("FROM Participante", Participante.class);
         
         // todos los participantes y se filtra por los equipos. Tratando de no usar OneToMany en las clases asociadas a Calendario
         List<Participante> participantes = query.getResultList();
         
         for(Participante participane:participantes) {
        	 
        	 if(participane.getId().getParticipanteEquipo()==calendario.getEquipoA().getIdEquipo()) {
        		System.out.println("Expediente de equipo A: "+ participane.getAlumno().getExpediente()+
        				"\nFecha de nacimiento del equipo A: "+participane.getAlumno().getFechaNacimineto() );
        	 }
        	 if(participane.getId().getParticipanteEquipo()==calendario.getEquipoB().getIdEquipo()) {
        		 System.out.println("Expediente de equipo B: "+ participane.getAlumno().getExpediente()+
         				"\nFecha de nacimiento del equipo B: "+participane.getAlumno().getFechaNacimineto() );
        	 }
         }

	      // a partir de aqui se hace uso de OneToMany, facilita mucho las consultas sin HQL.
	      System.out.println("Introduce el ID del profesor(Ejemplo 4): ");
          String sIdProfesor = scanner.nextLine();
	      
          int iIdProfesor=0;
          try {
        	  iIdProfesor=Integer.parseInt(sIdProfesor);
          }catch(Exception e) {
        	  e.printStackTrace();
        	  System.out.println("Tiene que ser un número entero.");
          }
          
          //recupero el profesor por su id, primaryKey
          Profesor profesor=session.get(Profesor.class, iIdProfesor);
          
          
          Set<Tutoria> setTutoria =profesor.getTutorias();//recupero las tutorias del profesor
          List<Tutoria> listTutorias = new ArrayList<>(setTutoria);//las paso de set a list para acceder a la primera posicion
          
          
          
          System.out.println("Profesor:\n "+profesor.getNombre()+" "+profesor.getApellido()+
					", del departamento: "+profesor.getIdDepartamento()+
					"\n El día y la hora de la tutoria: "+listTutorias.get(0).getDiaSemana()+" "+listTutorias.get(0).getHoraTutoria()+
					"\n Para el Gupo: "+ listTutorias.get(0).getCurso().getIdCurso());
          
          
          /*A continuación, pedir por teclado los datos de un encuentro. Si el encuentro ya existiese, 
           * actualizar los datos de resultado de los equipos. (mostrar un mensaje de aviso por pantalla)*/
          
          System.out.println("***********************************************\nIntroduce el ID de la actividad:");
          
          sIdActividad= scanner.nextLine();
          iIdActividad=0;
          try {
        	  iIdActividad=Integer.parseInt(sIdActividad);
          }catch(Exception e) {
        	  e.printStackTrace();
        	  System.out.println("Tiene que ser un número entero.");
          }
          
          System.out.println("Introduce la fecha (dd/MM/yyyy):");
          fechaStr = scanner.nextLine();
          System.out.println("Introduce la hora (HH:mm):");
          hora = scanner.nextLine();
          System.out.println("Introduce el lugar:");
          lugar = scanner.nextLine();
          
          
          formato = new SimpleDateFormat("dd/MM/yyyy");
          dataFormateada=null;
          try {
        	  
			dataFormateada = formato.parse(fechaStr);
			
		} catch (ParseException e) {
			
			System.out.println("La fecha es erronea, el formato ha de ser: dd/MM/yyyy ");
			e.printStackTrace();
		}
          
          // Se construye un objeto CalendarioId con los datos proporcionados
         calendarioId = new CalendarioId(iIdActividad, dataFormateada, hora, lugar);

          // Se recupera el calendario utilizando CalendarioId
         calendario = session.get(Calendario.class, calendarioId);
          
         try{
        	 System.out.println("Equipo A: "+calendario.getResultadoEquipoA()+
        			 "\nEquipo B: "+calendario.getResultadoEquipoB());
        			 
         }catch(NullPointerException e) {
        	 e.printStackTrace();
        	 System.err.println("No existe el evento");
         }
        		 
         System.out.println("Introduzca el nuevo resultado para el Equipo A:");
         String nuevoResultadoA=scanner.nextLine();
         int inuevoResultadoA= Integer.parseInt(nuevoResultadoA);
         System.out.println("Introduzca el nuevo resultado para el Equipo B:");
         String nuevoResultadoB=scanner.nextLine();
         
         calendario.setResultadoEquipoA(inuevoResultadoA);
         calendario.setResultadoEquipoB(nuevoResultadoB);


         session.saveOrUpdate(calendario);
         
         transaction.commit();
         System.out.println("Actualizado.");
         
         scanner.close();
         session.close();
         sessionFactory.close();
	}

}
