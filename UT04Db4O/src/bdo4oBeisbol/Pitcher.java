package bdo4oBeisbol;

public class Pitcher extends Player {
	private int wins;

	public Pitcher(String name, int squadNumber, float battingAverage, int wins) {
		super(name, squadNumber, battingAverage);
		this.wins = wins;
	}

	public void setWins(final int w) {
		this.wins = w;
	}

	public int getWins() {
		return this.wins;
	}

	public Pitcher(String name, int squadNumber, float battingAverage) {
		super(name, squadNumber, battingAverage);
		// TODO Auto-generated constructor stub
	}
	

	public Pitcher() {
		super();
	}

	public String toString() {
		return name + ":" + battingAverage  +" dorsal "
				+squadNumber+ "victorias "+ wins+" equipo "+ team.toString();
	}
}
