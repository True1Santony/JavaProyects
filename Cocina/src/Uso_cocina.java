import java.util.Scanner;

public class Uso_cocina {

	public static void main(String[] args) {
		        String a;
				Scanner sc=new Scanner(System.in);
				
				Cocina cocina1=new Cocina();
				
				System.out.println("Inroduzca el nombre de la cocina: ");
				
				a=sc.nextLine();
				
				cocina1.asignaNomCocina(a);
				
				System.out.println("Diga si la cocina tiene un frigorífico: (si/no): ");
				
				a=sc.nextLine();
				
				cocina1.preguntaFrigorifico(a);
				
				if(a.equalsIgnoreCase("si")) {
					
					frigorifico frigorifico1=new frigorifico();
					
					System.out.println("Entonces, introduzca la marca del frigorífico:");
					
					a=sc.nextLine();
					
					frigorifico1.setMarca(a);
					
					cocina1.asignaMarcaFrigo(a);
					
				}
					
					System.out.println("Diga si la cocina tiene placa: (si/no): ");
					
					a=sc.nextLine();
					
					cocina1.preguntaPlaca(a);
					
					if(a.equalsIgnoreCase("si")) {
						
						placa placa1=new placa();
						
						placa1.setColor();
						
						cocina1.asignaColorPlaca(placa1.dimeColor());
						
					sc.close();
					}
				
				
		        System.out.println(cocina1.infoMob());
			
	}
}
