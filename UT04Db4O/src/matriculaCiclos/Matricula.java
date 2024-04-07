package matriculaCiclos;

import java.io.File;
import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;

public class Matricula {
	final static String DB4OFILENAME = "Matricula.db4o";

	public static void main(String[] args) {

//		new File(DB4OFILENAME).delete();
		ObjectContainer db = Db4oEmbedded.openFile(DB4OFILENAME);
		try {
//			insertaDatos(db);

			listaAlumnos(db);
//			listaModulos(db);
//			listaCiclos(db);
			listaCualificaciones(db);


		} finally {
			db.close();
		}
	}



	public static void insertaDatos(ObjectContainer db) {
		Ciclo c1 = new Ciclo("IFCS02", "desarrollo aplicaciones multiplataforma", new ArrayList(), "superior", 2000);
		ArrayList<Modulo> mod = new ArrayList<Modulo>();
		c1.setModulos(mod);
		Cualificacion cu1 = new Cualificacion("IFC155_3",
				"Programacion en lenguajes estructurados de aplicaciones de gestion", "completa");
		Cualificacion cu2 = new Cualificacion("IFC080_3",
				"Programacion con lenguajes orientados a objetos y bases de datos relacionales", "completa");
		Cualificacion cu3 = new Cualificacion("IFC363_3",
				"Administracion en sistemas de planificacion de recursos empresariales y gestion de relaciones con clientes",
				"incompleta");
		Cualificacion cu4 = new Cualificacion("IFC303_3", "Programacion de sistemas informaticos", "incompleta");
		ArrayList<Cualificacion> cuDAM = new ArrayList<Cualificacion>();
		cuDAM.add(cu1);
		cuDAM.add(cu2);
		cuDAM.add(cu3);
		cuDAM.add(cu4);
		c1.setCualificaciones(cuDAM);

		Modulo m1 = new Modulo("484", "bases datos", 220, "primero", c1);
		c1.getModulos().add(m1);
		Modulo m2 = new Modulo("483", "Sistemas informaticos", 220, "primero", c1);
		c1.getModulos().add(m2);
		Modulo m3 = new Modulo("485", "Programacion", 0, "primero", c1);
		c1.getModulos().add(m3);
		Modulo m4 = new Modulo("373", "Lenguaje de Marcas", 0, "primero", c1);
		c1.getModulos().add(m4);
		Modulo m5 = new Modulo("487", "Entornos de Desarrollo", 0, "primero", c1);
		c1.getModulos().add(m5);
		Modulo m6 = new Modulo("493", "Fol", 0, "primero", c1);
		c1.getModulos().add(m6);
		Modulo m7 = new Modulo("486", "Acceso a Datos", 0, "segundo", c1);
		c1.getModulos().add(m7);
		Modulo m8 = new Modulo("488", "Desarrollo de Interfaces", 0, "segundo", c1);
		c1.getModulos().add(m8);
		Modulo m9 = new Modulo("490", "Programacion de Servicios y Procesos", 0, "segundo", c1);
		c1.getModulos().add(m9);
		Modulo m10 = new Modulo("491", "Sistemas de Gestion Empresarial", 0, "segundo", c1);
		c1.getModulos().add(m10);
		Modulo m11 = new Modulo("492", "Proyecto de desarrollo de Aplicaciones Multiplataforma", 0, "segundo", c1);
		c1.getModulos().add(m11);
		Modulo m12 = new Modulo("494", "Empresa e Iniciativa Emprendedora", 0, "segundo", c1);
		c1.getModulos().add(m12);
		Modulo m13 = new Modulo("495", "Formacion en Centros de Trabajo", 0, "segundo", c1);
		c1.getModulos().add(m13);
		Modulo m14 = new Modulo("10", "Ingles Tecnico", 0, "segundo", c1);
		c1.getModulos().add(m14);

		Alumno a1 = new Alumno("1", "1", "Juan", "Cornejo", "Lopez");
		Alumno a2 = new Alumno("2", "2", "Pablo", "Santos", "");
		Alumno a3 = new Alumno("3", "3", "Dolores", "Ruano", "Goñi");
		Alumno a4 = new Alumno("4", "4", "Leonor", "Carvajal", "Noguera");
		Alumno a5 = new Alumno("5", "5", "Catalina", "Sanchez", "Pol");
		Alumno a6 = new Alumno("6", "6", "Ada", "Cabezas", "Diaz");
		Alumno a7 = new Alumno("7", "7", "Ruth", "Guerrero", "Sanchez");
		Alumno a8 = new Alumno("8", "8", "Anton", "Carballo", "Lopez");
		Alumno a9 = new Alumno("9", "9", "Vicente", "Parrilla", "Godoy");
		Alumno a10 = new Alumno("10", "10", "Elena", "Diaz", "de la Cruz");
		Alumno a11 = new Alumno("11", "11", "Carlos", "Ruano", "Guerrero");
		Alumno a12 = new Alumno("12", "12", "Sandra", "Alvarado", "Arranz");
		Alumno a13 = new Alumno("13", "13", "Brais", "Blanco", "Rivas");
		Alumno a14 = new Alumno("14", "14", "Miriam", "Olmedo", "");

		altaNota(m1, a1, 1, 1);
		altaNota(m2, a1, 1, 1);
		altaNota(m3, a1, 1, 1);
		altaNota(m4, a1, 1, 1);
		altaNota(m5, a1, 1, 1);
		altaNota(m6, a1, 1, 1);
		altaNota(m7, a1, 1, 1);

		altaNota(m1, a2, 1, 1);
		altaNota(m2, a2, 1, 1);
		altaNota(m3, a2, 1, 1);
		altaNota(m4, a2, 1, 1);
		altaNota(m5, a2, 1, 1);
		altaNota(m6, a2, 1, 1);
		altaNota(m7, a2, 1, 1);

		altaNota(m1, a3, 1, 1);
		altaNota(m2, a3, 1, 1);
		altaNota(m3, a3, 1, 1);
		altaNota(m4, a3, 1, 1);

		altaNota(m7, a4, 1, 1);
		altaNota(m8, a4, 1, 1);
		altaNota(m9, a4, 1, 1);
		altaNota(m10, a4, 1, 1);
		altaNota(m1, a4, 1, 1);
		altaNota(m3, a4, 1, 1);

		altaNota(m7, a5, 1, 1);
		altaNota(m8, a5, 1, 1);
		altaNota(m9, a5, 1, 1);
		altaNota(m10, a5, 1, 1);
		altaNota(m14, a5, 1, 1);

		altaNota(m7, a6, 1, 1);
		altaNota(m8, a6, 1, 1);
		altaNota(m9, a6, 1, 1);
		altaNota(m10, a6, 1, 1);
		altaNota(m14, a6, 1, 1);

		altaNota(m7, a7, 1, 1);
		altaNota(m8, a7, 1, 1);
		altaNota(m9, a7, 1, 1);
		altaNota(m10, a7, 1, 1);

		altaNota(m11, a8, 1, 1);
		altaNota(m13, a8, 1, 1);
		altaNota(m14, a8, 1, 1);

		altaNota(m11, a9, 1, 1);
		altaNota(m13, a9, 1, 1);

		db.store(a1);
		db.store(a2);
		db.store(a3);
		db.store(a4);
		db.store(a5);
		db.store(a6);
		db.store(a7);
		db.store(a8);
		db.store(a9);
		db.store(a10);
		db.store(a11);
		db.store(a12);
		db.store(a13);
		db.store(a14);

		db.store(m1);
		db.store(m2);
		db.store(m3);
		db.store(m4);
		db.store(m5);
		db.store(m6);
		db.store(m7);
		db.store(m8);
		db.store(m9);
		db.store(m10);
		db.store(m11);
		db.store(m12);
		db.store(m13);
		db.store(m14);

	}
	private static void listaCualificaciones(ObjectContainer db) {
		ObjectSet<Cualificacion> result =db.queryByExample(new Cualificacion());
		for (Cualificacion cualificacion : result) {
			System.out.println(cualificacion.getCodigo()+" "+
								cualificacion.getCualifica()+" "+
								cualificacion.getCompleta());
			
		}
		
	}

	public static void altaNota(Modulo m, Alumno a, Integer n1, Integer n2) {
		AlumnoModulo amNota = new AlumnoModulo(m, a, n1, n2);

		m.getAlumnoNota().add(amNota);
		a.getModuloNota().add(amNota);
	}

	public static void listaAlumnos(ObjectContainer db) {
		ObjectSet<Alumno> result = db.queryByExample(new Alumno());
		for (Alumno a : result) {
			System.out.println(a);
			ArrayList<AlumnoModulo> notas = a.getModuloNota();
			for (AlumnoModulo mn : notas) {
				System.out.println(mn.getModulo().getNombre() + mn.getOrdinaria());

			}

		}

	}

	public static void listaModulos(ObjectContainer db) {
		ObjectSet<Modulo> result = db.queryByExample(new Modulo());
		for (Modulo m : result) {
			System.out.println(m.getNombre() + m.getHoras().shortValue() + m.getCiclo().getNombre());
			ArrayList<AlumnoModulo> notas = m.getAlumnoNota();
			for (AlumnoModulo an : notas) {
				System.out.println(an.getAlumno().getNombre() + an.getAlumno().getApe1() + an.getOrdinaria());

			}

		}
	}

	public static void listaCiclos(ObjectContainer db) {
		ObjectSet<Ciclo> result = db.queryByExample(new Ciclo());
		for (Ciclo c : result) {
			System.out.println(c);
			ArrayList<Modulo> modulos = c.getModulos();
			for (Modulo mod : modulos) {
				System.out.println(mod.getNombre() + mod.getHoras() + mod.getCurso());

			}

		}

	}

}
