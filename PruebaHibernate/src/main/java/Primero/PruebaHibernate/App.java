package Primero.PruebaHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Comienza" );
        
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        org.hibernate.Session session =sf.openSession();
        
        session.getTransaction().begin();
        
        Usuario user1= new Usuario();
        user1.setName("Pepe");
        
        session.persist(user1);
        
        session.getTransaction().commit();
        
    }
}
