package org.apache.maven.MapeoDB;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml"); // Asegúrate de proporcionar la ruta correcta al archivo de configuración

    	
    	
        SessionFactory sf = configuration.buildSessionFactory();
        org.hibernate.Session session =sf.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        try {
            // Consulta para obtener todos los alumnos
            List<Alumno> alumnos = session.createQuery("FROM Alumno", Alumno.class).list();

            // Muestra los alumnos por pantalla
            for (Alumno alumno : alumnos) {
                System.out.println("DNI: " + alumno.getDni());
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Apellido 1: " + alumno.getApe1());
                System.out.println("Apellido 2: " + alumno.getApe2());
                System.out.println("Matrícula: " + alumno.getnMatricula());
                

                System.out.println("--------------------------------------");
            }

            
            transaction.commit();
        } catch (Exception e) {
            // Si hay un error, realiza un rollback
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Cierra la sesión de Hibernate
            session.close();
            sf.close();
        }
    	
    }
}
