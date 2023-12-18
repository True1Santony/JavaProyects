package tarea01;

/**
 * Clase que saca caracteres del buffer en bucle hasta un maximo de 15 caracteres y
 * termina el hilo.
 * Imprementa runnable para ser lanzado. Por cada vuelta del bucle realiza no
 * un sleep() para forzar el intento de consumir antes de producir.
 * 
 */
public class Consumidor implements Runnable {


	private Buffer buffer;
	private final int LIMITE=15;
	private int consumido;
	
	/**
	 * @param buffer recibe el objeto buffer compartido
	 * tiene un un contador para limitar su ejecucion a 15 veces. 
	 * 
	 */
	public Consumidor(Buffer buffer) {
		
		this.consumido=0;
		this.buffer=buffer;
	}
	
	@Override
	public void run() {
		
		while(consumido<LIMITE) {
			char a=buffer.sacar();
			consumido++;
			System.out.println("Recogido el carácter " + a + " del buffer---------");
		}
	}

}
