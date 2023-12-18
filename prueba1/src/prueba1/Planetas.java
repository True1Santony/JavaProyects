package prueba1;
 


public class Planetas {
	
	enum planetas {Mercurio, Venus, Tierra, Marte, Jupiter, Saturno, Urano, Neptuno}
	enum Talla {MINI, MEDANO, GRANDE, MUY_GRANDE};

	public static void main(String[] args) {
		
		planetas PrimerPlaneta=planetas.Mercurio;
		planetas SegundoPlaneta=planetas.Neptuno;
		
		
		System.out.println("El primer planeta es: " + PrimerPlaneta + "\nEl ultimo planeta es: " + SegundoPlaneta);
		
		System.out.println("La posicion del primer planeta: " + planetas.Mercurio.ordinal());
		System.out.println("La posicion del ultimo planeta: " + planetas.Neptuno.ordinal());
		
		System.out.println("En total hay " + planetas.values().length + " Planetas.");
		
	}
}