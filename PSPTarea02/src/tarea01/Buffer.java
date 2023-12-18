package tarea01;

/**
 * Clase buffer que sera el objeto compartido por las instancias de 
 * consumidor y productor 
 */
public class Buffer {

	private char[] buffer;//bufer de char
	private int intPuntero;//index
	private boolean buffCompleto, buffVacio;//flags de bufer lleno o vacio
	
	/**
	 * @param tamanioBuffer recibe un entero para inciar el tamaño del buffer
	 * puntero en la posicion 0, se instancia con boolean vacio=true
	 */
	public Buffer(int tamanioBuffer) {
		
		buffer = new char[tamanioBuffer];
		intPuntero = 0;
		buffCompleto = false;
		buffVacio = true;
	}
	
	/**
	 * @param a introduce el char que se le pase por parametro.
	 * Metodo sincronizado, un unico hilo lo ejecuta al mismo tiempo, exclucion mutua
	 * sin paralelismo. Si el buffer esta completo espera, si no introduce el char en la posicion del
	 * puntero y avanza una posicion para el proximo char.
	 */
	public synchronized void introducir(char a) {
		
		while(buffCompleto) {//espera ni esta lleno el buffer
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buffer[this.intPuntero]=a;
		intPuntero++;
		buffVacio=false;
		
		if(intPuntero==buffer.length) {
			
			buffCompleto=true;
		}
		
		notifyAll();
	}
	
	/**
	 * @return el char en la ultima posicion del array en funcion del puntero,
	 * ultima posicion=posicion del ultimo char introducido.
	 * Si el buffer esta vacio ejecuta wait() para que el hilo productro se pueda ejecutar.
	 */
	public synchronized char sacar() {
		
		while(buffVacio) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		intPuntero--;
		buffCompleto=false;
		
		if(intPuntero==0) {
			buffVacio=true;
		}
		
		notifyAll();
		
		return buffer[intPuntero];
	}
	
	
}
