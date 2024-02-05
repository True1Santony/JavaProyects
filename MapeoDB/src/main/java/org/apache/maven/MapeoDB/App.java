package org.apache.maven.MapeoDB;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

public class App 
{
    public static void main( String[] args )
    {
    	
        SessionFactory sf =new Configuration().configure().buildSessionFactory();
        org.hibernate.Session session =sf.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        Scanner sc = new Scanner(System.in);
        
       
        
        
            // Consulta para obtener todos los alumnos
            List<Alumno> alumnos = session.createQuery("FROM Alumno", Alumno.class).list();

            // Muestra los alumnos
            for (Alumno alumno : alumnos) {
                System.out.println("DNI: " + alumno.getDni());
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Apellido 1: " + alumno.getApe1());
                System.out.println("Apellido 2: " + alumno.getApe2());
                System.out.println("Matrícula: " + alumno.getnMatricula());
                

                System.out.println("--------------------------------------");
            }

            
           // transaction.commit();
        
           
            
       
           
            
        
        
        System.out.println("Introduzca el DNI del Alumno:");
        String dniAlumno = sc.nextLine();
        int idniAlumno= Integer.parseInt(dniAlumno);
        //como el dni es único usamos alumno y un unico objeto.
        Alumno alumno1 =new Alumno();
        alumno1=(Alumno) session.createQuery("select a from Alumno a where a.dni ="+idniAlumno).uniqueResult();
        
        System.out.println(alumno1.getNombre()+"  "+alumno1.getApe1());
        
        
        System.out.println("Introduzca el curso de la práctica:");
        String curso = sc.nextLine();
        
        Practica practica1=new Practica();
        practica1= (Practica)session.createQuery("select p from Practica p where p.alumno="+alumno1.getDni()+"and p.curso='"+curso+"'").uniqueResult();
        
       
        
        //falta toString() para convenio y programa formativo.
        System.out.println("impresion antes de actualizar -----"+practica1);
        
        System.out.println("La valoracion actual del alumno es: "+practica1.getValoracion()+". ¿Que valoracion quiere poner?");
        String valoracionPractica=sc.nextLine();
        practica1.setValoracion(valoracionPractica);
        
        //session.flush();//pofzar 
        System.out.println("impresion despues de actualizar +++++++++++"+practica1);
        
        
        
        //session.saveOrUpdate(practica1);
        //da problemas por la clave compuesta
        
        Practica mergedPractica = (Practica) session.merge(practica1);
        System.out.println("La valoracón ha sido actualizada");
        
        //ver convenio desde practicas ya que tiene los objetos necesarios para la consulta.
        System.out.println("Introduzca el convenio que quiere consultar:");
        
        String sConvenio =sc.nextLine();
        int iconvenio = Integer.parseInt(sConvenio);
        
        Practica practica2=new Practica();
        Query query = session.createQuery("select p from Practica p where p.nConvenio="+iconvenio);
        
        List <Practica> practicas =query.getResultList();
        
        for(Practica p:practicas) {
        	int puntero =1;
        	System.out.println(puntero+". "+p.getConvenio().getEmpresa()+" "+p.getConvenio().getDireccion()+" Tutor: "+p.getnTutor()+":\n    "+
        						p.getAlumno().getDni()+"  "+p.getAlumno().getNombre()+" "+p.getAlumno().getApe1()+" "+p.getAlumno().getApe2()+"  ");
        	puntero++;
        }
        
       // System.out.println("ver que da practicas2 +++++++++++"+practica2);
        //Convenio objConvenio =(Convenio) session.createQuery("select c from Convenio c where c.nConvenio="+iconvenio).uniqueResult();
        
       // System.out.println(objConvenio.getEmpresa()+"  "+objConvenio.getDireccion() );
        
        
        
       transaction.commit();
        
        
        session.close();
        sf.close();
    }
}
