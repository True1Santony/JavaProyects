
public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleados trabajador1=new Empleados("paco");
		
		Empleados trabajador2=new Empleados("Ana");
		
		Empleados trabajador3=new Empleados("Antonio");

		Empleados trabajador4=new Empleados("Joselito");
		
		trabajador1.cambiaSeccion("RRHH");
		
		
		
		System.out.println(trabajador1.devuelveDatos());
		
		
		
		System.out.println(trabajador2.devuelveDatos());
		
       
		
		System.out.println(trabajador3.devuelveDatos());
		
		System.out.println(trabajador4.devuelveDatos());
		
		
	}

}


class Empleados{
	
	public Empleados(String nom) {
		
		
		nombre=nom;
		
		seccion="Administracion";
		
		Id=IdSiguiente;
		
		IdSiguiente++;
		
	}
	
	public void cambiaSeccion(String seccion) {//setter
		
		this.seccion=seccion;
	}
	
	
	public String devuelveDatos() {//getter
		
		return "El nombre es: " + nombre + " y la seccion es: " + seccion+ ", el ID es: "+ Id;
	}
	
	private final String nombre;
	
	private String seccion;
	
	private int Id;
	
	private static int IdSiguiente=1;
	
}