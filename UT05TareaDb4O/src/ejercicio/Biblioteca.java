package ejercicio;

import java.io.File;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;
import com.db4o.reflect.jdk.JdkMethod;

import modelo.*;

public class Biblioteca {final static String DB4OFILENAME = "Biblioteca.db4o";

public static void main(String[] args) throws ParseException {

	new File(DB4OFILENAME).delete();
	//EmbeddedObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
	ObjectContainer db = Db4oEmbedded.openFile( DB4OFILENAME);
	
	try {
		
		insertaDatos(db);
//		
//		
//		�qu� libros ha prestado "Pablo", "Santos"?
// Ire desde prestamo>copia>libro(toString()) y prestamo>lector(nombre apellidos), usare operador AND para la segunda condicion
		
		
		
		
		Query query =db.query();
		query.constrain(Prestamo.class);
		/*Constraint constr =*/ query.descend("lector").descend("nombre").constrain("Pablo").equal();
		//query.descend("ape1").constrain("Santos").equal().and(constr);
		//query.constrain(constr);
	    ObjectSet<Prestamo> result =query.execute();
		
		for(Prestamo prestamo:result) {
			System.out.println(prestamo);
		}
		
		
//		�que lectores no ha devuelto algun prestamo? 
//		Un prestamo no devuelto es el que tiene fecha de devolucion  (ffin) a null
		
		
//		�qu� lectores tienen o han tenido libros en frances
		
		
//		lista los datos de todas las copias de un libro: id, estado, titulo, autor, editorial, etc...
		
		
//		registra una devolucion de un prestamo pendiente, debes modificar el estado del libro a biblioteca.



	} finally {
		db.close();
	}
}
//completa el metodo
//inserta 15 prestamos ten en cuenta las consultas que se piden y asi obtener resultados al aplicarlas.
//
public static void insertaDatos(ObjectContainer db)  {	
	Lector a1 = new Lector(1, "1", "Juan", "Cornejo", "Lopez");
	Lector a2 = new Lector(2, "2", "Pablo", "Santos", "");
	Lector a3 = new Lector(3, "3", "Dolores", "Ruano", "Go�i");
	Lector a4 = new Lector(4, "4", "Leonor", "Carvajal", "Noguera");
	Lector a5 = new Lector(5, "5", "Catalina", "Sanchez", "Pol");
	Lector a6 = new Lector(6, "6", "Ada", "Cabezas", "Diaz");
	Lector a7 = new Lector(7, "7", "Ruth", "Guerrero", "Sanchez");
	Lector a8 = new Lector(8, "8", "Anton", "Carballo", "Lopez");
	Lector a9 = new Lector(9, "9", "Vicente", "Parrilla", "Godoy");
	Lector a10 = new Lector(10, "10", "Elena", "Diaz", "de la Cruz");
	Lector a11 = new Lector(11, "11", "Carlos", "Ruano", "Guerrero");
	Lector a12 = new Lector(12, "12", "Sandra", "Alvarado", "Arranz");
	Lector a13 = new Lector(13, "13", "Brais", "Blanco", "Rivas");
	Lector a14 = new Lector(14, "14", "Miriam", "Olmedo", "");
//	libros
	Libro l1 =new Libro("El conde de Montecristo","novela contemporanea","ALMA EUROPA", "castellano",2022);
	Libro l2 =new Libro("MITOS NORDICOS","ensayo","BRIDGE", "castellano",2021);

	Libro l3 =new Libro("El conde de Montecristo","novela contemporanea","ALMA EUROPA", "castellano",2022);

	Libro l4 =new Libro("SUPERVIVIR. VUELVE AL ORIGEN Y RECUPERA TU SALUD","Medicina divulgativa","GRIJALBO", 
			"castellano",2020);

	Libro l5 =new Libro("REVOLUCION","novela historica","ALFAGUARA", "castellano",2022);


	Libro l6 =new Libro("LA AUTOPISTA LINCOLN","novela contemporanea","SALAMANDRA", "castellano",2022);
	Libro l7 =new Libro("LOS ABRAZOS LENTOS","novela contemporanea","SUMA", "castellano",2021);

	Libro l8 =new Libro("El conde de Montecristo","novela contemporanea","ALMA EUROPA", "castellano",2022);

	Libro l9 =new Libro("NOSTALGIA MILENIAL: SOBREVIVIR�","humor","RANDOM COMICS", "castellano",2018);
	Libro l10 =new Libro("THE LAST CHAIRLIFT","novela contemporanea","SIMON & SCHUSTER UK ", "ingles",2019);
	Libro l11 =new Libro("IT ENDS WITH US","novela contemporanea","SIMON & SCHUSTER UK", "ingles",2022);
	Libro l12 =new Libro(" Hamlet","teatro","Oberon Books", "ingles",2018);
	Libro l13 =new Libro("King Lear","teatro","Oberon Books", "ingles",2019);
	Libro l14 =new Libro("Les Pr�cieuses ridicules","teatro","Les Editions Bilboquet", "frances",2018, "Moli�re");
	Libro l15 =new Libro("Cyrano de Bergerac","teatro","ANACROUSE editions", "frances",2018, "Moli�re");
	Libro l16 =new Libro("Les Mis�rables","novela","Les Editions Bilboquet", "frances",2019, "Victor Hugo");	
	Libro l17 =new Libro("Les Feuilles d'automne","poesia","ANACROUSE editions", "frances",2019, "Moli�re");
//copias
	Copia c1 = new Copia(1,"biblioteca", l1);
	Copia c2 = new Copia(2,"biblioteca", l1);
	Copia c3 = new Copia(3,"biblioteca", l1);
	Copia c4 = new Copia(4,"biblioteca", l2);
	Copia c5 = new Copia(5,"biblioteca", l2);
	Copia c6 = new Copia(6,"biblioteca", l3);
	Copia c7 = new Copia(7,"biblioteca", l4);
	Copia c8 = new Copia(8,"biblioteca", l5);
	Copia c9 = new Copia(9,"biblioteca", l6);
	Copia c10 = new Copia(10,"biblioteca", l7);
	Copia c11= new Copia(11,"biblioteca", l7);
	Copia c12= new Copia(12,"biblioteca", l7);
	Copia c13= new Copia(13,"biblioteca", l8);
	Copia c14= new Copia(14,"biblioteca", l8);
	Copia c15= new Copia(15,"biblioteca", l9);
	Copia c16= new Copia(16,"biblioteca", l10);
	Copia c17= new Copia(17,"biblioteca", l11);
	Copia c18=new Copia(18,"biblioteca", l11);
	Copia c19= new Copia(19,"biblioteca", l12);
	Copia c20=new Copia(20,"biblioteca", l13);
	Copia c21 =new Copia(21,"biblioteca", l13);
	Copia c22 = new Copia(22,"biblioteca", l13);
	Copia c23 = new Copia(23,"biblioteca", l13);
	Copia c24 = new Copia(24,"biblioteca", l14);
	Copia c25 = new Copia(25,"biblioteca", l15);
	Copia c26 = new Copia(26,"biblioteca", l15);
	Copia c27 = new Copia(27,"biblioteca", l16);
	Copia c28 = new Copia(28,"biblioteca", l16);
	Copia c29 = new Copia(29,"biblioteca", l17);
	Copia c30 = new Copia(30,"biblioteca", l17);
	
	LocalDate fechaInicioPrestamo= LocalDate.of(2024, 03, 27);
	
	
	
	Prestamo p1 = new Prestamo(c1,a1,fechaInicioPrestamo );
	p1.getCopia().setEstado("prestado");
	
	Prestamo p2 = new Prestamo(c4,a1, fechaInicioPrestamo);
	p2.getCopia().setEstado("prestado");
	
	Prestamo p3 = new Prestamo(c6,a1, fechaInicioPrestamo);
	p3.getCopia().setEstado("prestado");
	
	Prestamo p4 = new Prestamo(c2,a2, fechaInicioPrestamo);
	p4.getCopia().setEstado("prestado");
	
	Prestamo p5 = new Prestamo(c5,a2, fechaInicioPrestamo);
	p5.getCopia().setEstado("prestado");
	
	Prestamo p6 = new Prestamo(c3,a3, fechaInicioPrestamo);
	p6.getCopia().setEstado("prestado");
	
	Prestamo p7 = new Prestamo(c7,a3, fechaInicioPrestamo);
	p7.getCopia().setEstado("prestado");
	
	Prestamo p8 = new Prestamo(c8,a4, fechaInicioPrestamo);
	p8.getCopia().setEstado("prestado");
	
	Prestamo p9 = new Prestamo(c9,a5, fechaInicioPrestamo);
	p9.getCopia().setEstado("prestado");
	
	Prestamo p10 = new Prestamo(c10,a5, fechaInicioPrestamo);
	p10.getCopia().setEstado("prestado");
	
	Prestamo p11 = new Prestamo(c11,a6, fechaInicioPrestamo);
	p11.getCopia().setEstado("prestado");
	
	Prestamo p12 = new Prestamo(c12,a7, fechaInicioPrestamo);
	p12.getCopia().setEstado("prestado");
	
	Prestamo p13 = new Prestamo(c13,a6, fechaInicioPrestamo);
	p13.getCopia().setEstado("prestado");
	
	Prestamo p14 = new Prestamo(c14,a7, fechaInicioPrestamo);
	p14.getCopia().setEstado("prestado");
	
	Prestamo p15 = new Prestamo(c15,a6, fechaInicioPrestamo);
	p15.getCopia().setEstado("prestado");
	
	Prestamo p16 = new Prestamo(c16,a7, fechaInicioPrestamo);
	p16.getCopia().setEstado("prestado");
	
	Prestamo p17 = new Prestamo(c17,a5, fechaInicioPrestamo);
	p17.getCopia().setEstado("prestado");
	
	Prestamo p18 = new Prestamo(c18,a4, fechaInicioPrestamo);
	p18.getCopia().setEstado("prestado");
	
	Prestamo p19 = new Prestamo(c19,a8, fechaInicioPrestamo);
	p19.getCopia().setEstado("prestado");
	
	Prestamo p20 = new Prestamo(c20,a9, fechaInicioPrestamo);
	p20.getCopia().setEstado("prestado");
	
	Prestamo p21 = new Prestamo(c21,a10, fechaInicioPrestamo);
	p21.getCopia().setEstado("prestado");
	
	Prestamo p22 = new Prestamo(c22,a11, fechaInicioPrestamo);
	p22.getCopia().setEstado("prestado");
	
	Prestamo p23 = new Prestamo(c23,a12, fechaInicioPrestamo);
	p23.getCopia().setEstado("prestado");
	
	Prestamo p24 = new Prestamo(c24,a13, fechaInicioPrestamo);
	p24.getCopia().setEstado("prestado");
	
	Prestamo p25 = new Prestamo(c25,a14, fechaInicioPrestamo);
	p25.getCopia().setEstado("prestado");
	
	
//	prestamos completar
// 	incluye prestamos no devueltos
//	ten en cuenta que al registrar un prestamo no devuelto debes cambiar el estado del libro a prestado


    
    //guardo las copias que no se han prestado, con ellas los libros
    
    db.store(c26);
    db.store(c27);
    db.store(c28);
    db.store(c29);
    db.store(c30);
    
    db.store(p1);
    db.store(p2);
    db.store(p3);
    db.store(p4);
    db.store(p5);
    db.store(p6);
    db.store(p7);
    db.store(p8);
    db.store(p9);
    db.store(p10);
    db.store(p11);
    db.store(p12);
    db.store(p13);
    db.store(p14);
    db.store(p15);
    db.store(p16);
    db.store(p17);
    db.store(p18);
    db.store(p19);
    db.store(p20);
    db.store(p21);
    db.store(p22);
    db.store(p23);
    db.store(p24);
    db.store(p25);
   
    db.commit();

//	
}
}
