package calculadora;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		Scanner miScan = new Scanner(System.in);
        System.out.println("Calculadora que suma dos numeros enteros");
        System.out.println("Introduce el primer numero");
        String sPrimerNum = miScan.nextLine();
        int iPrimerNum = Integer.parseInt(sPrimerNum);
        System.out.println("Introduce el segundo numero");
        String sSegNum = miScan.nextLine();
        int iSegNum = Integer.parseInt(sSegNum);
        int iResul = iPrimerNum + iSegNum;
        System.out.println("El resultado es: " + iResul);
   }
	}


