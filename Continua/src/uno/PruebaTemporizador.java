package uno;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class PruebaTemporizador {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		DameLaHora oyente=new DameLaHora();
		
		Timer mitemporizador=new Timer(5000,oyente);
		
		mitemporizador.start();
		
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
		
		System.exit(0);
	}

}

 class DameLaHora implements ActionListener{
	 
	 public void actionPerformed(ActionEvent e) {
		 
		 Date ahora=new Date();
		 
		 System.out.println("Tengo la hora cada 5 sg.:" + ahora); 
		 
		 Toolkit.getDefaultToolkit().beep();
	 }
 }