package bdo4oBeisbol;

import java.io.File;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import com.db4o.ObjectSet;

public class Ejemplo3 {
	final static String DB4OFILENAME =  "teams.db4o";

	public static void main(String[] args) {

		new File(DB4OFILENAME).delete();
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
		try {
			insertaDatos(db);
			listaTodosDatos(db);
			
		}finally {
			db.close();
		}

	}

	public static void insertaDatos(ObjectContainer dbo) {
//		crear objetos
//		Crea Players
		Player p1 = new Player("Barry Bonds", 25, 0.362f);
		Player p2 = new Player("Marquis Grissom", 9, 0.279f);
		Player p3 = new Player("Ray Durham", 5, 0.282f);
		Player p4 = new Player("Adrian Beltre", 29, 0.334f);
		Player p5 = new Player("Cesar Izturis", 3, 0.288f);
		Player p6 = new Player("Shawn Green", 15, 0.266f);

//		Crea Pitchers
		Player p7 = new Pitcher("Kirk Rueter", 46, 0.131f, 9);
		Player p8 = new Pitcher("Kazuhisa Ishii", 17, 0.127f, 13);


//		Crea Teams
		Team t1 = new Team("Giants", "San Francisco", 91, 71);
		Team t2 = new Team("Dodgers", "Los Angeles", 93, 69);

//		a�ade jugadores a los equipos(Teams)
		t1.addPlayer(p1);
		p1.setTeam(t1);
		t1.addPlayer(p2);
		p2.setTeam(t1);
		t1.addPlayer(p3);
		p3.setTeam(t1);
		t2.addPlayer(p4);
		p4.setTeam(t2);
		t2.addPlayer(p5);
		p5.setTeam(t2);
		t2.addPlayer(p6);
		p6.setTeam(t2);

//		a�ade Pitchers a los equipos (Teams)
		t1.addPlayer(p7);
		p7.setTeam(t1);
		t2.addPlayer(p8);
		p8.setTeam(t2);
//		insertando los equipos se guardan los jugadores de ese equipo

		dbo.store(t1);
		dbo.store(t2);
//		insertando los jugadores y pitchers se guardan los equipos en lo que juegan
//		dbo.store(p1);
//		dbo.store(p2);
//		dbo.store(p3);
//		dbo.store(p4);
//		dbo.store(p5);
//		dbo.store(p6);
//		dbo.store(p7);
//		dbo.store(p8);
// que pasa con los jugadores sin equipo o los equipos sin jugadores en uno y otro caso
		System.out.println("insertados");
		

	}
public static void listaTodosDatos(ObjectContainer dbo) {
//lista equipos
	System.out.println("***************lista equipos************************");
	List<Team> resultTeam = dbo.queryByExample(new Team());
	for (Object object : resultTeam) {
		System.out.println(object.toString());
	}
//	lista pitcher
	System.out.println("***************lista pitcher************************ ");
	List<Pitcher> resultpitc = dbo.queryByExample(new Pitcher());
	for (Object object : resultpitc) {
		System.out.println(object.toString());
	}
//	lista jugadores
		System.out.println("*****************lista jugadores************************* ");
	List<Player> resultplay = dbo.queryByExample(new Player("Barry Bonds",0,0.0f));
	for (Object object : resultplay) {
		System.out.println(object.toString());
	}
//	
	System.out.println("**************************lista todo****************************");
	 ObjectSet<Object> result = dbo.queryByExample(new Object());
	 for (Object object : result) {
		 System.out.println(object);
		
	}
	
		
	}
}
