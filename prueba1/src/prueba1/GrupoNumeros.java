package prueba1;
import java.util.Scanner;
import java.io.IOException;
public class GrupoNumeros
{
	public static void main(String args[]) throws IOException
	{
		Scanner teclado = new Scanner( System.in );
		final int MAYORES = 65;
		final int MENORES = 18;
		int iMayores = 0;
		int iIntermedios = 0;
		int iMenores = 0;
		String sVal [];
		int iValorAct = 0;
		
		String sEnt = teclado.nextLine();
		sVal = sEnt.split(" ");
		
		iValorAct = Integer.parseInt(sVal[0]);
		iMayores = (iValorAct > MAYORES) ? (iMayores + 1) : iMayores;
		iMenores = (iValorAct < MENORES) ? (iMenores + 1) : iMenores;
		iIntermedios = ((iValorAct >= MENORES) && (iValorAct <= MAYORES)) ? (iIntermedios + 1) : iIntermedios;
		
		iValorAct = Integer.parseInt(sVal[1]);
		iMayores = (iValorAct > MAYORES) ? (iMayores + 1) : iMayores;
		iMenores = (iValorAct < MENORES) ? (iMenores + 1) : iMenores;
		iIntermedios = ((iValorAct >= MENORES) && (iValorAct <= MAYORES)) ? (iIntermedios + 1) : iIntermedios;

		iValorAct = Integer.parseInt(sVal[2]);
		iMayores = (iValorAct > MAYORES) ? (iMayores + 1) : iMayores;
		iMenores = (iValorAct < MENORES) ? (iMenores + 1) : iMenores;
		iIntermedios = ((iValorAct >= MENORES) && (iValorAct <= MAYORES)) ? (iIntermedios + 1) : iIntermedios;
	
		/*
		// Una alternativa a la lectura usando el metodo next de Scanner podria ser:
		String sEnt = teclado.next();
		iValorAct = Integer.parseInt(sEnt);
		iMayores = (iValorAct > MAYORES) ? (iMayores + 1) : iMayores;
		iMenores = (iValorAct < MENORES) ? (iMenores + 1) : iMenores;
		iIntermedios = ((iValorAct >= MENORES) && (iValorAct <= MAYORES)) ? (iIntermedios + 1) : iIntermedios;
		
		sEnt = teclado.next();
		iValorAct = Integer.parseInt(sEnt);
		iMayores = (iValorAct > MAYORES) ? (iMayores + 1) : iMayores;
		iMenores = (iValorAct < MENORES) ? (iMenores + 1) : iMenores;
		iIntermedios = ((iValorAct >= MENORES) && (iValorAct <= MAYORES)) ? (iIntermedios + 1) : iIntermedios;

		sEnt = teclado.next();
		iValorAct = Integer.parseInt(sEnt);
		iMayores = (iValorAct > MAYORES) ? (iMayores + 1) : iMayores;
		iMenores = (iValorAct < MENORES) ? (iMenores + 1) : iMenores;
		iIntermedios = ((iValorAct >= MENORES) && (iValorAct <= MAYORES)) ? (iIntermedios + 1) : iIntermedios;
		*/
		// Tambien se podrian haber leido con nextInt de Scanner
		
		System.out.println("Los numeros menores son: " + iMenores);
		System.out.println("Los numeros intermedios son: " + iIntermedios);
		System.out.println("Los numeros mayores son: " + iMayores);
		teclado.close();
	} //fin main
} //fin class