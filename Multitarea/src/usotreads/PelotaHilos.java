package usotreads;

import java.awt.Component;

public class PelotaHilos implements Runnable {

	private Pelota pelota;
	private Component componente;
	public PelotaHilos(Pelota unaPelota,Component unComponente) {
		pelota=unaPelota;
		componente=unComponente;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<3000; i++) {
			pelota.mueve_pelota(componente.getBounds());
			componente.paint(componente.getGraphics());
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
