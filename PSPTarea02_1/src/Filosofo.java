/**
 * 
 * Clase que representa a un filósofo en la cena de los folosofos.
 * Implementa la interfaz Runnable para permitir su ejecución en un hilo.
 * 
 */
public class Filosofo implements Runnable {
	/** Identificador único del filósofo. */
    private final int id;
    
    /** Tenedor a la izquierda del filósofo. */
    private final Tenedor tenedorIzquierdo;
    
    /** Tenedor a la derecha del filósofo. */
    private final Tenedor tenedorDerecho;

    /**
     * Constructor de la clase Filosofo.
     *
     * @param id Identificador del filósofo.
     * @param tenedorIzquierdo Tenedor a la izquierda del filósofo.
     * @param tenedorDerecho Tenedor a la derecha del filósofo.
     */
    public Filosofo(int id, Tenedor tenedorIzquierdo, Tenedor tenedorDerecho) {
        this.id = id + 1; // para imprimir desde 1 a 5 en lugar de 0 a 4
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorDerecho = tenedorDerecho;
    }

    
    /**
     * Obtiene el identificador del filósofo.
     *
     * @return Identificador del filósofo.
     */
    public int getId() {
        return id;
    }

    /**
     * Método que simula el pensamiento del filósofo.
     * El filósofo imprime un mensaje de pensamiento y luego espera durante 2 segundos.
     */
    private void pensar() {
        System.out.println("Filósofo " + getId() + " Pensando");
        try {
            Thread.sleep(2000); // Pausa de 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Filósofo " + getId() + " Hambriento");
    }

    /**
     * Método que simula el acto de comer del filósofo.
     * El filósofo intenta coger los tenedores, come durante 3 segundos y luego suelta los tenedores.
     * no se usa por bloques sincronizados para evitar perdida de paralelismo ni metodo completo.
     * El orden de llamamiento a los metodos coger, soltar y la impresion por pantalla es imprescindible seguir un orden concreto de estos.
     */
    private void comer() {
    	//si no sincronizo este metodo no hay manera de que se imprima en pantalla como tiene que ir, aunque no haya inconguencia real
    	//synchronized (tenedorIzquierdo) {
    		this.tenedorIzquierdo.coger();
    		//	synchronized (tenedorDerecho) {
    				this.tenedorDerecho.coger();
       
    				System.out.println("Filósofo " + getId() + " ha cogido los tendedores: " + tenedorIzquierdo.getId() + "," + tenedorDerecho.getId());

					System.out.println("Filósofo " + getId() + " Comiendo+++++++++++++++++++++");
    					try {
 
    						Thread.sleep(3000); // Pausa de 3 segundos mientras come
    						
    					} catch (InterruptedException e) {
    						e.printStackTrace();
    					}

        
    			//		this.tenedorDerecho.soltar();movido mas abajo
    			//						}
    		//	this.tenedorIzquierdo.soltar();movido mas abajo
        System.out.println("Filósofo " + getId() + " Termina de comer, ha dejado los tendedores: " + tenedorIzquierdo.getId() + "," + tenedorDerecho.getId()+"-----------------");
    	//}
        this.tenedorIzquierdo.soltar();
        this.tenedorDerecho.soltar();
    }

    /**
     * Implementación del método run de la interfaz Runnable.
     * El filósofo entra en un bucle infinito de pensar y comer.
     */
    @Override
    public void run() {
        while (true) {
            pensar();
            comer();
        }
    }
}
