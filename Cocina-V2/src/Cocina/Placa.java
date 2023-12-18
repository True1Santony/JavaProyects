package Cocina;

public class Placa {
	
	private String colorPlaca;
	
	Placa(){
		colorPlaca=setColor();
		
	}
	private String setColor() {   //***REUTILIZADO DE OTRA TAREA***getter(aunque ponga set, xd), para el color aleatorio, lo encapsulo por si da un valor inesperado. 
		
	try {
		double variable = Math.random()*10;
		int num = (int)variable;
		
		if(num==1 || num==2 || num==3) {
			
			colorPlaca="Marrón";
			
			}else if(num==4 || num==5 || num==6){
				
				colorPlaca="Azul";
			}else {
				
				colorPlaca="Verde";
			}
	}catch (Exception e) {
		
		System.out.println("El metodo math ha devueto un valor inesperado, vuelva a ejecutar el programa.");
		
	}
	return colorPlaca;
		
	}
	 String getColor() {     // ha de ser metodo de paquete
		return colorPlaca;
	}
}
