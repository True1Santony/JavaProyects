package prueba1;

public class Pajaro {
	 
    String nombre;
    int posX, posY;
 
    public Pajaro() {
 
    }
 
    public Pajaro(String nombre, int posX, int posY) {
        this.nombre=nombre;
        this.posX=posX;
        this.posY=posY;
    }
    double volar (int posX, int posY) {
 
        double desplazamiento = Math.sqrt( posX*posX + posY*posY );
        this.posX = posX;
        this.posY = posY;
 
        return desplazamiento;
    }


public static void main(String[] args) {
	 
    Pajaro loro = new Pajaro("Pepe",200,50);
    double d = loro.volar(200,50);
    System.out.print("El desplazamineto del Loro Pepe ha sido: " + d);
}

}