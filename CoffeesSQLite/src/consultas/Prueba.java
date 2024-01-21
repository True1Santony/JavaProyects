package consultas;

import java.util.Scanner;

/**
 * <h1>Prueba</h1>
 *<p>En la carpeta <b>lib</b> se encuentra el Driver.</p>
 *<a href="https://github.com/xerial/sqlite-jdbc/releases/tag/3.32.3.2">Enlace a JAR Driver SQLite</a>
 *<p>Clace con método Main, tiene un menú con el que se escoje el número de la opción y ejecuta los metodos de la clase <b>Cafe</b></p>
 *@author espar
 *@version 1.0
 */
public class Prueba {

	public static void main(String[] args) {
		
		Cafes cafe=new Cafes();
		int valor=123;//valor cualquiera para switch
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("********************************************************\n"
					+ " Escoja:\n"
					+ "1. Muestra datos de la tabla.\n"
					+ "2. Buscar cafe por nombre.\n"
					+ "3. Consultar cafe por ID del Proveedor.\n"
					+ "4. Insertar cafe: COF_NAME, SUP_ID, PRICE, SALES, TOTAL\n"
					+ "5. Borrar cafe por nombre.\n"
					+ "6. Salir del programa.");
			try{
				valor=sc.nextInt();
				sc.nextLine();
			}catch(Exception e) {
				
				System.out.println("Valor no válido");
			}
			
			
			switch(valor) {
			
			case 1:
				
				cafe.muestraDatosTabla();
				break;
			case 2:
				
				System.out.println("Introduzca el nombre del cafe(Por ejemplo: Espresso)");
				
				String nombreCafe=sc.nextLine();
				cafe.buscaCafe(nombreCafe);
				
				break;
			case 3:
				
				System.out.println("Introduzca el ID del proveedor(Por ejemplo: 101)");
				
				int prov=sc.nextInt();
				cafe.consultaCafeProveedor(prov);
				sc.nextLine();//clear buffer
				break;
			case 4:
				String cafeN, prove, price,sales,total;
				System.out.println("Introduzca el nombre del cafe");
				cafeN=sc.nextLine();
				System.out.println("Introduzca el ID del proveedor(Por ejemplo: 101)");
				prove=sc.nextLine();
				System.out.println("Introduzca el Price");
				price=sc.nextLine();
				System.out.println("Introduzca el Sales");
				sales=sc.nextLine();
				System.out.println("Introduzca el tolat");
				total=sc.nextLine();

				String respuesta=cafe.insetraFila(cafeN, Integer.parseInt(prove), Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(total));

				System.out.println(respuesta);
				break;
			case 5:
				
				System.out.println("Introduzca el nombre del cafe a borrar.");
				String cafeAborrar=sc.nextLine();
				
				System.out.println(cafe.borrarCafe(cafeAborrar));//borra e imprime el mensaje.
				break;
			case 6:
				
				cafe.liberarRecursos();
				cafe.cerrarConexion();
				
				break;
			default:
				break;
			
			
			}
			
			
		}while(valor!=6);
		
		
		
	}

}
