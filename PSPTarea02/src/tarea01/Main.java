package tarea01;

/**
 * Clase principar desde la que se lanzan los hilos.
 * Se le da una ventaja al hilo productor para que haya contenido en el buffer
 * antes de que el hilo consumidor los intente consumir.
 * 
 * @author espar
 * @version 2.0
 */
public class Main {

	public static void main(String[] args) {
		
		Buffer b=new Buffer(5);

		Thread t1=new Thread(new Productor(b));
		Thread t2=new Thread(new Consumidor(b));
		
		
		
		t1.start();
		// sleep para que pueda proiducir hasta 6 char, si se elimana se ve el comportamiento real.
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
	}

}
