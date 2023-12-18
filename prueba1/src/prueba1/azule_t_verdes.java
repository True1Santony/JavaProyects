package prueba1;

import java.util.Scanner;

public class azule_t_verdes {
	public static void main(String[] args) {
		
	
		Scanner teclado = new Scanner( System.in );
		int iEntUno = 0;
		int iEntDos = 0;
		int iEntTres = 0;
		String sEnt= "";
		String sSalida = "";
		String [] sDat= new String[3];
		
		System.out.print("Introduce el numero de las tres entradas: ");
		sEnt = teclado.nextLine();
		sDat = sEnt.split(" ");
		
		for(int i=0; i<sDat.length; i++) {
			System.out.print(sDat[i]);
			System.out.print(" ");
		}
		
		
		teclado.close();
	}
	

}
