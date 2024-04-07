package bdo4oBeisbol;

import java.io.File;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

public class Ejemplo4 {
	final static String DB4OFILENAME = "formula1.db4o";

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		ObjectContainer db = Db4oEmbedded.openFile( DB4OFILENAME);
		try {
			ObjectSet<Object> result;
			Query q= db.query();
			Constraint constr;
//		qbe listar datos del jugador Barri Bonds
			Player patronJugador =new Player();
			patronJugador.setName("Barry Bonds");
			result=db.queryByExample(patronJugador);
			System.out.println("datos de Barri Bonds");
			listaDatos(result);
//			cambio dorsal Barry Bons 
//			actualizacion 
			Player resPlayer =(Player) result.next();
			resPlayer.setSquadNumber(8);
			db.store(resPlayer);
			result=db.queryByExample(patronJugador);
			System.out.println("datos de Barri Bonds actualizados");
			listaDatos(result);
//			
////		qbe	equipos juegan San Francisco
//			Team patronTeam= new Team();
//			patronTeam.setStadium("San Francisco");
//			result=db.queryByExample(patronTeam);
//			System.out.println("datos equipo que juega en San FFrancisco");
//			listaDatos(result);
////	soda jugadores promedio bateo >0.3
//					
			System.out.println("----jugadores con battinaverage mayor de 0,3:\n");
			q.constrain(Player.class);
			q.descend("battingAverage").constrain(0.3f).greater();
			result = q.execute();
			listaDatos(result);
//	soda con dos criterios promedio bateo mayor 0.13 y mas de 5 victorias		
			q = db.query();
			q.constrain(Player.class);
			System.out.println("pitcher  promedio bateo mayor 0.13 y mas de 5 victorias");
			constr = q.descend("battingAverage").constrain(0.13f).greater();
			q.descend("wins").constrain(5).greater().and(constr);
			result = q.execute();
			listaDatos(result);
//	soda juegadores promedio de bateo <0,3 y juegue en Giants
			System.out.println("pitcher promedio bateo <0.3 juegue en Giants ");
			q=db.query();
			q.constrain(Player.class);
			constr =q.descend("battingAverage").constrain(Float.valueOf(0.3f)).smaller();
			q.descend("team").descend("name").constrain("Giants").equal().and(constr);
			result = q.execute();
			listaDatos(result);
//			soda "jugadores con un promedio de bateo por encima de .130 
//			que sean pitchers con más de 5 wins "
			System.out.println("-------------jugadores con un promedio de bateo por encima de .130 que sean pitchers con más de 5 wins-------------------------------- ");
			q = db.query();
			q.constrain(Pitcher.class);
			constr = q.descend("battingAverage").constrain(0.13f).greater();
			q.descend("wins").constrain(5).greater().and(constr);
			result = q.execute();
			listaDatos(result);
//soda jugadores con nombre que empiece por K
//			System.out.println("jugadores con nombre que empiece por K");
//			q = db.query();
//			q.descend("name").constrain("K").startsWith(true);
//			result = q.execute();
//			listaDatos(result);
		System.out.println("/*/*/*/probamos otra consulta*/*//");
//			soda ordena salida
			q = db.query();
			q.constrain(Player.class);
			q.descend("battingAverage").orderAscending();
			result = q.execute();
			listaDatos(result);
//	soda listar ordenado por dorsal jugadores que jueguen en Giants
//			
//			q=db.query();
//			q.constrain(Player.class);
//			q.descend("squadNumber").orderAscending();
//			q.descend("team").descend("name").constrain("Giants").equal();
//		
//			result = q.execute();
//			System.out.println("soda listar ordenado por dorsal jugadores que jueguen en Giants");
//			listaDatos(result);
//			soda "\"jugadores con promedio de bateo superior
//			a .300 que est�n en un equipo con menos de 92 wins\". ");
//			System.out.println("jugadores con promedio de bateo superior a .300 que estén en un equipo con menos de 92 wins\". ");
//			q = db.query();
//			q.constrain(Player.class);
//			constr = q.descend("battingAverage").constrain( Float.valueOf(0.3f)).greater();
//			q.descend("team").descend("won").constrain( Integer.valueOf(92)).smaller().and(constr);
//			result = q.execute();
//			listaDatos(result);
			System.out.println("/**/*/jugadores con promedio de bateo superior a .300 que estén en un equipo con menos de 92 wins\". /*/*/*/*");
			q = db.query();
			q.constrain(Player.class);

			constr = q.descend("battingAverage").constrain(0.3f).greater();
			q.descend("team").descend("won").constrain(92).smaller().and(constr);

			result = q.execute();
			listaDatos(result);
			
//soda equipos que  tengan	mas de dos jugadores	
			q=db.query();
			q.constrain(Team.class);
//			q.descend("players").constrain(2)
			
			
			
			
////			query nativa
//			System.out.println("query nativa");
//			
//			List<Player> player = db.query(new Predicate<Player>() {
//			     public boolean match(Player player) {
//			         return player.getName().equals("Barry Bonds");
//			     }
//			 });
//			
//			listaLista(player);
//			
//			//
//			

		} finally {
			db.close();
			
		}

	}

	
	public static void listaDatos(ObjectSet result) {
		for (Object object : result) {
			System.out.println(object);

		}
		System.out.println("******************FIN CONSULTA*******************\n");
	}
}
