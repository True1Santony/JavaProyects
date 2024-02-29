package com.tarea.MapeoInstituto;

import java.util.List;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
  public static void main(String[] args) {
	
	  SessionFactory sf =new Configuration().configure().buildSessionFactory();
      org.hibernate.Session session =sf.openSession();
      
      Transaction transaction = session.beginTransaction();
      
     // Scanner sc = new Scanner(System.in);
      
     
      
      
          // Consulta para obtener todos los alumnos
          List<Alumno> alumnos = session.createQuery("FROM Alumno", Alumno.class).list();

          // Muestra los alumnos
          for (Alumno alumno : alumnos) {
        	  System.out.println("----------------------------------------------------");
              System.out.println("Expediente: " + alumno.getExpediente());
              System.out.println("Nombre: " + alumno.getNombre());
              System.out.println("Apellidos: " + alumno.getApellidos());
              System.out.println("Grupo: " + alumno.getGrupo());
              System.out.println("Fecha de nacimiento: " + alumno.getFechaNacimineto());
              // Imprime todos los campos que desees
          }

      sf.close();
      session.close();
     
  }
	  
	  
	  
  }

