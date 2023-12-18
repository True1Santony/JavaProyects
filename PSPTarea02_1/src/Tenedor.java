import java.util.concurrent.Semaphore;

/**
 * Clase con semaforo.
 * Regula el acceso a los tenedores que pueden intenar ser compartidos.
 * Regula el momento de coger el tenedor. Además lidia con el interbloqueo
 * que puede producirse si los 5 hilos filosofo cogen el tenedor izquiero o
 * derecho, todos a la vez.
 * 
 */

public class Tenedor {

	private int id;
	private Semaphore semaforo;// un permiso de uso por objeto

	/**
	 * Constructor para Tenedor
	 * @param id se le da un numero al tenedor
	 */
	public Tenedor(int id) {
		this.semaforo  = new Semaphore(1);
		this.id = id + 1; // Ajuste para imprimir desde 1 a 5 en lugar de 0 a 4
	}

	/**
	 * @return id 
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método que se encarga de dar permiso de uso del tenedor n+1.
	 * Cuando se lo invoca adquiere el permiso de uso del  objeto tenedor n+1
	 * para el filosofo que lo invocó, otro filosofo no podra hacer uso de ese tenedor,
	 * otro se quedará donde se invocó el medoto bloqueado.
	 */
	public void coger() {
		//boolean adquirido=false;
		try {
            // adquiere el permiso y devuelve true, no lo adquiere false, no usar si hay otros semaforos, no es equitativo, irrumpe el primero
          //  boolean adquirido1 = this.semaforo.tryAcquire(3, java.util.concurrent.TimeUnit.SECONDS);
          //adquirido=adquirido1;
		//boolean exito;
		//exito=	semaforo.tryAcquire();
		
			semaforo.acquire();
           // if (!adquirido) {
                // No se pudo adquirir el permiso en el tiempo especificado, por lo que se libera automáticamente
             //   soltar();
               // System.out.println("se dejado de tratar de coger el tenedor: "+id +" porque ya lo tiene otro filosofo");
           // }

      } catch (InterruptedException e) {
          e.printStackTrace();
       }
	//	return adquirido;
   }

	
	/**
	 * Se suelta el tenedor. Se devuelve el permiso de uso para otro uso.
	 */
	public void soltar() {// se libera el tenedor para otros hilos.
		semaforo.release();
	}

	/*//al final no se usa, primer intento de uso availablePermits() desde filosofo.
	public Semaphore getSemaforo() {
		return semaforo;
	}*/

}
