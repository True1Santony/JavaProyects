package prueba1;

import java.text.Normalizer;
import java.util.Scanner;

public class Arays {

	public static void main(String[] args) {
		
		String a="Alberto";
		String b="Albertó Garciá";
		String nombreInterno=Normalizer.normalize(a, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");;
		String nombreDeObjPasado=Normalizer.normalize(b, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		
		System.out.println(nombreInterno);
		System.out.println(nombreDeObjPasado);
	}
}


