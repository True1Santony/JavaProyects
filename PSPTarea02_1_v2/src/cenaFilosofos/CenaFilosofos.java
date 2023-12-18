package cenaFilosofos;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class CenaFilosofos {

    public static void main(String[] args) {
        int numFilosofos = 5;
        Filosofo[] filosofos = new Filosofo[numFilosofos];
        Semaphore[] tenedores = new Semaphore[numFilosofos];

        for (int i = 0; i < numFilosofos; i++) {
            tenedores[i] = new Semaphore(1);
        }

        for (int i = 0; i < numFilosofos; i++) {
            filosofos[i] = new Filosofo(i, tenedores[i], tenedores[(i + 1) % numFilosofos]);
            new Thread(filosofos[i]).start();
        }
    }
}

class Filosofo implements Runnable {
    private final int id;
    private final Semaphore tenedorIzquierdo;
    private final Semaphore tenedorDerecho;

    public Filosofo(int id, Semaphore tenedorIzquierdo, Semaphore tenedorDerecho) {
        this.id = id;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorDerecho = tenedorDerecho;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // El filósofo piensa
                System.out.println("Filósofo " + id + " está pensando.");

                // El filósofo intenta tomar el tenedor izquierdo
                tenedorIzquierdo.acquire();
                System.out.println("Filósofo " + id + " tiene el tenedor izquierdo.");

                // El filósofo intenta tomar el tenedor derecho
                if (tenedorDerecho.tryAcquire()) {
                    System.out.println("Filósofo " + id + " tiene ambos tenedores y está comiendo.");

                    // Tiempo aleatorio para simular el tiempo que tarda en comer
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));

                    // El filósofo suelta ambos tenedores
                    tenedorIzquierdo.release();
                    tenedorDerecho.release();
                    System.out.println("Filósofo " + id + " ha terminado de comer y ha soltado ambos tenedores.");
                } else {
                    // El filósofo no pudo tomar el tenedor derecho, suelta el izquierdo y vuelve a intentar.
                    tenedorIzquierdo.release();
                    System.out.println("Filósofo " + id + " no pudo tomar el tenedor derecho, soltó el izquierdo y vuelve a intentar.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}