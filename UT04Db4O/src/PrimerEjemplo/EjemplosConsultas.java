package PrimerEjemplo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

public class EjemplosConsultas {

	public static void main(String[] args) {

// Creamos la conexión
		ObjectContainer db = Db4oEmbedded.openFile("personas.db4o");
//qbe lista todos 	
		Persona p = new Persona();
		ObjectSet<Persona> result = db.queryByExample(p);
		listaDatos(result);

//qbe	busca persona con nombre Pepe
		p.setNombre("Pepe");
		result = db.queryByExample(p);
		listaDatos(result);
//soda busca persona con nombre Pepe
		Query q = db.query();
		q.constrain(Persona.class);
		q.descend("nombre").constrain("Pepe").equal();
		result = q.execute();
		listaDatos(result);
//nq busca persona con nombre Pepe
		result = db.query(new Predicate<Persona>() {
			public boolean match(Persona persona) {
				return persona.getNombre().equals("Pepe");

			}
		});

		listaDatos(result);
		db.close();

	}

	private static void listaDatos(ObjectSet<Persona> result) {
		for (Object object : result) {
			System.out.println(object.toString());
		}
	}

}
