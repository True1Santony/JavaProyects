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

public class ejemplosQN {
	final static String DB4OFILENAME = "formula1.db4o";

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		ObjectContainer db = Db4oEmbedded.openFile( DB4OFILENAME);
		try {
			ObjectSet<Player> result;
			Query q= db.query();
			Constraint constr;
//		QN	jugadores promedio bateo >0.3
//			System.out.println("jugadores promedio bateo >0.3");
//			result=db.query(new Predicate<Player>() {
//				public boolean match(Player player) {
//					// TODO Auto-generated method stub
//					return (player.getBattingAverage()>Float.valueOf(0.3f));
//				}
//				
//			});
//			listaDatos(result);
//		QN pitcher promedio bateo >0.3	 y mas de 5 victorias
//			System.out.println("pitcher promedio bateo <0.3	 y mas de 5 victorias");
//			ObjectSet <Pitcher> resultPit=db.query(new Predicate<Pitcher>() {
//		
//				public boolean match(Pitcher pit) {
//					// TODO Auto-generated method stub
//					return ((pit.getBattingAverage() < Float.valueOf(0.3f))
//							&& (pit.getWins()>Integer.valueOf(5)));
//				}
//				
//		});
//			
//		listaDatos(resultPit);
//QN		 equipos que  tengan	mas de dos jugadores
	
//			System.out.println("equipos que  tengan	mas de dos jugadores");
//			ObjectSet <Team> resultTeam =db.query(new Predicate<Team>() {
//
//				@Override
//				public boolean match(Team equipo) {
//					// TODO Auto-generated method stub
//					return (equipo.getPlayers().size()>2);
//				}
//				
//				
//			});
//			listaDatos(resultTeam);
//qn 		jugadores con promedio de bateo superior a .300 que estén en un equipo con menos de 92 wins
			
			System.out.println("jugadores con promedio de bateo superior a .300 que estén en un equipo con menos de 92 wins");
			result = db.query(new Predicate<Player>() {

				public boolean match(Player jugador) {
					// TODO Auto-generated method stub
					return ((jugador.getBattingAverage() > Float.valueOf(0.3f))
							&& (jugador.getTeam().getWon()<92));
				}
			
			});
			listaDatos(result);
			
			
			
		} finally {
			db.close();
			
		}

	}
	public static void listaDatos(ObjectSet result) {
		for (Object object : result) {
			System.out.println(object);

		}
	}
}