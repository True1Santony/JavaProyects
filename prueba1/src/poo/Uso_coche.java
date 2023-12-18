package poo;
import java.util.Scanner;

public class Uso_coche {

	public static void main(String[] args) {
		String lectura;
		Scanner sc=new Scanner(System.in);
		
		Coche micoche=new Coche();
		System.out.println("introduce el color del coche");
		lectura=sc.nextLine();
		micoche.establece_color(lectura);
		
		System.out.println(micoche.dime_datos_generales());
		
		System.out.println(micoche.dime_color());
		
		micoche.configura_asientos("no");
	
		System.out.println(micoche.dime_asientos());
		
		micoche.configura_climatizaor("si");
		
		System.out.println(micoche.dime_climatizador());
		
		System.out.println(micoche.dime_peso_coche());
		
		System.out.println("El precio final del coche es: "+ micoche.precio_coche());
		
		
	}

}
