package tarea01;
/**
 * Clase que produce caracteres y los introduce en el buffer en bucle hasta un maximo de 15 caracteres y
 * termina el hilo.
 * Imprementa runnable para ser lanzado. Por cada vuelta del bucle realiza
 * un sleep() para forzar que el hilo consumidor se detenga antes de que haya char que consumir.
 * 
 */
public class Productor implements Runnable {

	private Buffer buffer;
	private final String letras ="abcdefghijklmnopqrstuvwxyz";
	private final int LIMITE=15;
	private int producidos;
	
	/**
	 * @param buffer recibe el objeto buffer compartido
	 * tiene un un contador para limitar su ejecucion a 15 veces. 
	 */
	public Productor(Buffer buffer) {
		
		producidos=0;
		this.buffer=buffer;
	}
	
	@Override
	public void run() {
		
		while(producidos<LIMITE) {
			
			char a= Character.toUpperCase(letras.charAt((int)(Math.random()*letras.length())));
			System.out.println("Depositado el carácter " + a + " en el buffer++++++++");//antes del metodo introducir() para correcto funcionamiento sin sleep() en main
			
			buffer.introducir(a);
			producidos++;
			
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
