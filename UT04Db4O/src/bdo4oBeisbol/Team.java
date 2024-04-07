package bdo4oBeisbol;

import java.util.List;
import java.util.ArrayList;
 
public
class Team {
    
    private String name;
    private String city;
    private int won;
    private int lost;
    private List<Player> players;
    
    public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(String name, String city,
                int won, int lost){
        this.name = name;
        this.city = city;
        this.won = won;
        this.lost = lost;
        this.players = new ArrayList<Player>();
    }
    
    public void addPlayer(Player p) {
        players.add(p);
    }
    
    public void setName(String n){this.name =
n;}   
    public String getName(){return
this.name;}  
 
    public void setStadium(String c){this.city
= c;}
    public String getCity(){return this.city;} 
 
    public void setPlayers(List<Player> p){players =
p;}
    public List<Player> getPlayers(){return players;}
    
    public void setWon(int w) {this.won = w;}
    public int getWon(){return this.won;}
 
    public void setLost(int l) {this.lost = l;}
    public int getLost() {return this.lost;}
 
    public String toString() {
        return name+city+lost+won;
    } 
}
