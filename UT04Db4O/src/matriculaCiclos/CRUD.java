package matriculaCiclos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

public class CRUD {
	final static String DB4OFILENAME = "Matricula.db4o";
	

	@SuppressWarnings("serial")
	public static void main(String[] args) {


		EmbeddedObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
		try {
//			recuperar los datos del alumno con dni 10 y matricularlo en el modulo de Programacion de Servicios y Procesos
//			nota ordinaria y estraordinaria 1
			Alumno alumno =new Alumno();
			alumno.setDni("10");
			ObjectSet<Alumno> alumnos = db.queryByExample(alumno);
			alumno=alumnos.next();
			
			Modulo modulo =new Modulo();
			modulo.setNombre( "Programacion de Servicios y Procesos");
			ObjectSet<Modulo> modulos=db.queryByExample(modulo);
			modulo=modulos.next();
			System.out.println(modulo);
			
			 AlumnoModulo alumnoModulo=new AlumnoModulo(modulo, alumno, 1,1);
			 modulo.getAlumnoNota().add(alumnoModulo);
			 alumno.getModuloNota().add(alumnoModulo); 
				System.out.println(modulo);
				System.out.println(alumnoModulo);
				System.out.println(alumno);
			 db.store(alumnoModulo);
			 db.store(modulo);
			 db.store(alumno);
			 
			 db.commit();
			 
			 
			 
			 
			
			
////		QBE encontrar notas de juan dni 1 en AD
//			
//			
//			Alumno juan = (Alumno) db.queryByExample(new Alumno("1",null,null,null,null)).next();
//			Modulo AD=(Modulo) db.queryByExample(new Modulo("486", null,0,null)).next();
//			System.out.println(juan);
//			System.out.println(AD);
//			ObjectSet<AlumnoModulo> juanAD = db.queryByExample(new AlumnoModulo(AD, juan,0,0));
//			System.out.println("buscamos nota de juan en AD");
//		if (juanAD.hasNext()) {
//			System.out.println("alumno encontarado");
//			System.out.println(juanAD.next());
//			
//		}
//		
//			
//			
////encontrar juanAD soda
//		System.out.println("encontrar a juan en acceso a datos con soda");
//			Query q =db.query();
//			q.constrain(AlumnoModulo.class);
//			Constraint constr=q.descend("alumno").descend("dni").constrain(new String("1")).equal();
//			q.descend("modulo").descend("codigo").constrain(new String("486")).equal().and(constr);
//			ObjectSet<AlumnoModulo> alumnoModulo=q.execute();
//			for (AlumnoModulo am : alumnoModulo) {
//				System.out.println(am);
//				am.setOrdinaria(10);
//				db.store(am);
//				
//			}
////encontrar a juan query nativa
//			System.out.println("ecnotrar a juan con query nativa");
//			Predicate<Alumno> dni1 = new Predicate<Alumno>() {
//				public boolean match(Alumno alumno) {
//					return alumno.getDni()=="1";
//				}
//			};
//			ObjectSet<Alumno> alumnos=db.query(dni1);
//			for (Alumno alumno : alumnos) {
//				System.out.println(alumno);
//			}
//						
////encontrar el objeto alumnoModulo correspondiente a dni1 matriculado en 486
//			System.out.println("encontrar las notas de juan en acceso a datos");
//			Predicate <AlumnoModulo> d1m486= new Predicate<AlumnoModulo>() {
//				public boolean match(AlumnoModulo am) {
//					return am.getAlumno().getDni()=="1" && am.getModulo().getCodigo()=="486";
//				}
//				};
//				ObjectSet<AlumnoModulo> notas=db.query(d1m486);
//				for (AlumnoModulo nota : notas) {
//					System.out.println(nota);
//				}
//								
//			
////			listaAlumnos(db);
//			listaModulos(db);
////			
//			
//			
////			qbe Alumno
//			System.out.println("borro alumno catalina sanchez");
//				Alumno patron = new Alumno();
//				patron.setApe1("Sanchez");
//				patron.setNombre("Catalina");
//				ObjectSet<Alumno> result = db.queryByExample(patron);
//				for (Alumno alumno1 : result) {
//					System.out.println(alumno1);
//					db.delete( alumno);
//					borraDeModulo( db, alumno1);
//					
//					db.commit();
//				}
//				System.out.println("listo todos los modulos no debe estar catalina sanchez");
//				listaModulos(db);
//			query soda
//				System.out.println("consulta soda");
//				 q = db.query();
//				q.constrain(Alumno.class);
//				q.descend("ape1").constrain(new String("Ruano")).equal();
//				result = q.execute();
//				for (Alumno alumno : result) {
//					System.out.println(alumno);
//				}
////				query soda queremos alas notas de los alumnos en bases de datos
//					System.out.println("consulta soda");
//					q = db.query();
//					q.constrain(AlumnoModulo.class);
//					q.descend("modulo").descend("nombre").constrain(new String("bases datos")).equal();
//					ObjectSet<AlumnoModulo> resultAM= q.execute();
//					for (AlumnoModulo am : resultAM) {
//						System.out.println(am.getAlumno().getNombre()+am.getOrdinaria()+am.getExtraordinaria());
//					}	
////					query con dos criterios
//					System.out.println("con dos criterios");
//					q = db.query();
//					q.constrain(AlumnoModulo.class);
//					Constraint constr1 = q.descend("modulo").descend("nombre").constrain(new  String("bases datos")).equal();
//					q.descend("alumno").descend("nombre").constrain(new String("Juan")).equal().and(constr1);
//					result = q.execute();
//					for (AlumnoModulo am : resultAM) {
//						System.out.println(am.getAlumno().getNombre()+am.getOrdinaria()+am.getExtraordinaria());
//					}     
				
		} finally {
			db.close();
		}
	}

	private static void borraDeModulo(EmbeddedObjectContainer db, Alumno alumno) {
		List<Modulo> modulo=db.queryByExample(new Modulo());
		Query q =db.query();
		q.constrain(Modulo.class);
		q.descend("alumnoNota").constrain(alumno).contains();
		ObjectSet<?> resultado=q.execute();
		for (Object object : resultado) {
			System.out.println(object);
			
		}
		
				
		
		
	}

	public static void listaAlumnos(EmbeddedObjectContainer db) {
		System.out.println("este es el listado de alumnos");
		ObjectSet<Alumno> result = db.queryByExample(new Alumno());
		for (Alumno a : result) {
			System.out.println(a);
			ArrayList<AlumnoModulo> notas = a.getModuloNota();
			for (AlumnoModulo mn : notas) {
				System.out.println(mn.getModulo().getCodigo()+mn.getModulo().getNombre() + mn.getOrdinaria());

			}

		}

	}

	public static void listaModulos(EmbeddedObjectContainer db) {
		ObjectSet<Modulo> result = db.queryByExample(new Modulo());
		for (Modulo m : result) {
			System.out.println(m.getCodigo()+m.getNombre() + m.getHoras().shortValue() + m.getCiclo().getNombre());
			ArrayList<AlumnoModulo> notas = m.getAlumnoNota();
			for (AlumnoModulo an : notas) {
				System.out.println(an.getAlumno().getNombre() + an.getAlumno().getApe1() + an.getOrdinaria());

			}

		}
	}

}
