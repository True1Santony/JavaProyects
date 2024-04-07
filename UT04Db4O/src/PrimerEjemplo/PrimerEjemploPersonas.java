package PrimerEjemplo;
import java.io.File;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;





public class PrimerEjemploPersonas
{

	public static void main(String[] args) {
		
		// Creamos la conexión
		File persona =new File("personas.db4o");
		persona.delete();
		ObjectContainer db = Db4oEmbedded.openFile("personas.db4o");
		Persona p1 = new Persona("Fernando", 30, 1, 73);
		Persona p2 = new Persona("Pepe", 30, 1.75, 80);
		Persona p3 = new Persona("Alfredo", 20, 1.9, 90);
		Persona p4 = new Persona("Roberto", 35, 1.70, 70);
		Persona p5 = new Persona("Domingo", 30, 1.73, 80);
		db.store(p1);
		db.store(p2);
		db.store(p3);
		db.store(p4);
		db.store(p5);
		Persona p = new Persona();
		ObjectSet<Object> result = db.queryByExample(p);
		System.out.println("CONSULTA qbe PERSONAS PERSONAS ");	 
		while (result.hasNext()) {
			
		    System.out.println(result.next());
		}
	
		p.setNombre("Pepe");
		result= db.ext().queryByExample(p);
		
	
//		int i=0;
		System.out.println("CONSULTA qbe PERSONAS CON NOMBRE PEPE ");
		for (Object object : result) {
			
//			System.out.println(i++);
			System.out.println(object);
		}  
		db.close();

	}

}
