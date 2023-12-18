package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_empleado {

	public static void main(String[] args) {
		
		/*Empleado empleado1 = new Empleado("Espartaco Nassekine", 90000, 2022, 12, 3);
		
		Empleado empleado2 = new Empleado("Mario Patricio", 95000, 2000, 10, 7);
		
		Empleado empleado3 = new Empleado("Maria Jose Sanchez", 190000, 2010, 5, 24);
		
		empleado1.subeSueldo(5);
		
		empleado2.subeSueldo(5);
		
		empleado3.subeSueldo(5);
		
		System.out.println("Nombre: "+ empleado1.dameNombre() + " Sueldo: "+ empleado1.dameSueldo()+ " Fecha de Alta: " + empleado1.dameFechaContrato());

		System.out.println("Nombre: "+ empleado2.dameNombre() + " Sueldo: "+ empleado2.dameSueldo()+ " Fecha de Alta: " + empleado2.dameFechaContrato());
		
		System.out.println("Nombre: "+ empleado3.dameNombre() + " Sueldo: "+ empleado3.dameSueldo()+ " Fecha de Alta: " + empleado3.dameFechaContrato());*/
		
		
		Empleado[] misEmpleados=new Empleado[3];
		
		misEmpleados[0]=new Empleado("Espartaco Nassekien",90000, 2022, 12, 3 );
		misEmpleados[1]=new Empleado("Mario Patricio", 95000, 2000, 10, 7);
		misEmpleados[2]=new Empleado("Maria Jose Sanchez", 190000, 2010, 5, 24);
		
		for (int i=0;i<3;i++) {
			
			misEmpleados[i].subeSueldo(5);
			
		}
		
		for(int i=0;i<3;i++) {
			
			System.out.println("Nombre: "+misEmpleados[i].dameNombre()+ " Sueldo: " + misEmpleados[i].dameSueldo()+ " La fecha del alta contrato es: "+ misEmpleados[i].dameFechaContrato());
			
		}
	}

}


class Empleado{
	
	public Empleado(String nom,double sue, int agno, int mes, int dia){
	
		nombre=nom;
		
		sueldo=sue;
		
		GregorianCalendar calendario= new GregorianCalendar(agno,mes-1,dia);
		
		altaContrato=calendario.getTime();
	
	}
	
	public String dameNombre() {//getter
		
		return nombre;
	}
	
	public double dameSueldo() {//getter
		
		return sueldo;
	}
	
	public Date dameFechaContrato() {//getter
		
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) {//setter
		
		double aumento=sueldo*porcentaje/100;
		sueldo+=aumento;
	}
	
	
	private String nombre;
	
	private double sueldo;
	
	private Date altaContrato;
}