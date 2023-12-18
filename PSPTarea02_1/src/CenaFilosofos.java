/**
 * CenaFilosofos.java
 * 
 * Representa la clase principal del proyecto
 * Los filósofos compiten por hacerse con los dos tenedores necesarios para comer.
 * Hay 5 tenedores y 5 filósofos, si el filósofo 1 está comiendo el 2 y el 5 no pueden 
 * comer, ya que los los tenedores 1 y 5 estan en uso. 
 * 
 * @author espar
 * @version 1001.0
 * 
 */
public class CenaFilosofos {
    

	public static void main(String[] args) {
        
		Tenedor[] tenedores = new Tenedor[5];

        for (int i = 0; i < 5; i++) {
            tenedores[i] = new Tenedor(i);
        }

        Filosofo[] filosofos = new Filosofo[5];

        // Se asigna específicamente los tenedores a los filósofos
        filosofos[0] = new Filosofo(0, tenedores[0], tenedores[4]);
        filosofos[1] = new Filosofo(1, tenedores[1], tenedores[0]);
        filosofos[2] = new Filosofo(2, tenedores[2], tenedores[1]);
        filosofos[3] = new Filosofo(3, tenedores[3], tenedores[2]);
        filosofos[4] = new Filosofo(4, tenedores[4], tenedores[3]);

        // Se lanzan los 5 hilos 
        for (Filosofo filosofo : filosofos) {
            new Thread(filosofo, "Filósofo " + filosofo.getId()).start();
        }
    }
}