package Cocina;

import java.util.Scanner;

public class Cocina {
	
	private String nombre;                        //declaro los atributos y los atributos/array de objetos frigorifico y placa.
	private boolean frigorifico;
	private boolean placa;
	private int cantidadFrigorificos;
	private int cantidadPlacas;
	private Frigorifico[] miArrFrig;
	private Placa[] miArrPlaca;

	public static void main(String[] args) {
		
		System.out.println("Introduzca el nombre de la cocina:");
		Scanner sc=new Scanner(System.in);
		Cocina cocina1=new Cocina();
		cocina1.nombre=sc.nextLine();
		
		System.out.println("Introduzca el número de frigoríficos que hay en la cocina:" + cocina1.nombre);
		cocina1.cantidadFrigorificos=sc.nextInt();                            //posible error, no controlado
		sc.nextLine();                                                        // limpieza buffer, porque almacena \n y en bucle for, en la primera iteracion, guarda un espacio en balanco. 
		if (cocina1.cantidadFrigorificos>=1) {                                // Lo que provoca, si borro esta linea, salte a 2º instancia de frigorificos/placas.
			cocina1.miArrFrig=new Frigorifico[cocina1.cantidadFrigorificos];    // dimensiono el array
			cocina1.frigorifico=true;                                        // establezco valor boolean (hay frigorificos)
			
			for (int i=0; i<cocina1.miArrFrig.length; i++ ) {
				cocina1.miArrFrig[i]=new Frigorifico();                      //instancio cada posicion de objeto del array
				System.out.println("¿Cual es la marca del frigorifico: " + (i+1)+" ?");
				String marca="";                                             //String auxiliar para el metodo setMarca
				marca=sc.nextLine();
				cocina1.miArrFrig[i].setMarca(marca);
				
			}
		}else if(!(cocina1.cantidadFrigorificos>=0)) {                       // no intento controlar posible error por introducir un dato no compatible.
			cocina1.frigorifico=false;                                       // establezco valor boolean (no hay frigorificos)
			System.out.println("La cocina: "+ cocina1.nombre + " no va a tener frigorifico.");
		}
		/*for(int i=0;i<cocina1.miArrFrig.length; i++) {
			System.out.println(cocina1.miArrFrig[i].getMarca()); pruebas del array (me daba NULL por no instanciar cada objeto del array), lo dejo para que se vea como he ido 
			                                                      haciendo todo. En matemáticas era tan importante el procedimiento como el resultado y en esto parece que también,
			                                                     si no es necesario, en futuras tareas no lo pongo.
		}*/
		System.out.println("Introduzca el número de placas que hay en la cocina:" + cocina1.nombre);
		cocina1.cantidadPlacas=sc.nextInt();                                  //posible error char, no controlado
		sc.nextLine();                                                                // limpieza buffer, porque almacena \n y en bucle for, en la primera iteracion, guarda un espacio en balanco. 
		if (cocina1.cantidadPlacas>=1) {                                              // Lo que provoca, si borro esta linea, salte a 2º instancia de frigorificos/placas.
			cocina1.miArrPlaca=new Placa[cocina1.cantidadPlacas];
			cocina1.placa=true;
			
			for (int i=0; i<cocina1.miArrPlaca.length; i++ ) {
				cocina1.miArrPlaca[i]=new Placa();	                                 // parte placa, copia y pega del codigo de frigorificos. solo que el constructor establece
			}                                                                        //automaticamente el color, asi que no hago mas.
		}else if(!(cocina1.cantidadPlacas>=0)) {                              //no intento controlar posible error por introducir un dato no compatible.
			cocina1.placa=false;
			System.out.println("La cocina: "+ cocina1.nombre + " no va a tener placa.");
		}
		
		cocina1.inforMob();                              //llama al metodo infoMob()
		sc.close();                                   //cierro el Scanner.
	}
	
	private void inforMob () {                       // metodo para mostrar el mobiliario
		if(frigorifico==false && placa==false) {                                                                        // no hay mobiliario
			System.out.println("La cocina " +getNombreCocina()+ " no tiene frigoríficos y no tiene placas.");
		}else if(frigorifico==true && placa==false) {                                                                   //hay frigorifico no hay placa
			System.out.print("La cocina " +getNombreCocina()+" tiene "+getNumFrigos()+" frigoríficos de marcas ( ");
			for (int i=0; i<cantidadFrigorificos; i++) {
				System.out.print(miArrFrig[i].getMarca());                                                                //no se si hay una mejor manera de imprimir seguido  
				System.out.print(" ");                                                                                    //un atributo de un objeto dentro de una posicion
			}                                                                                                             //del array de objetos.
			System.out.print(")"  +" y no tiene placas.");
				
		}else if(frigorifico==false && placa==true) {                                                                   //no hay frigorifico no hay placa
			System.out.print("La cocina " +getNombreCocina()+" no tiene frigoríficos, pero tiene "+ getNumPlacas()+" placas de colores ( " );
			for (int i=0; i<cantidadPlacas; i++) {
				System.out.print(miArrPlaca[i].getColor());
				System.out.print(" ");
				}
			System.out.print(").");
		}else if(frigorifico==true && placa==true) {                                                                    //hay frigorifico y hay placa
			System.out.print("La cocina " +getNombreCocina()+" tiene "+getNumFrigos()+" frigoríficos de marcas ( ");
			for (int i=0; i<cantidadFrigorificos; i++) {
				System.out.print(miArrFrig[i].getMarca());
				System.out.print(" ");
			}
				System.out.print(")"  +" y tiene "+ getNumPlacas()+" placas de colores ( " );
			for (int i=0; i<cantidadPlacas; i++) {
				System.out.print(miArrPlaca[i].getColor());
				System.out.print(" ");
			
			}
			System.out.print(").");
		}
	}
	private String getNombreCocina() {    // getters para devolver los parametros necesarios.
		return nombre; 
	}
	private int getNumFrigos() {
		return cantidadFrigorificos;
	}
	private int getNumPlacas() {
		return cantidadPlacas;
	}
	

}
