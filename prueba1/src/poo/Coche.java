package poo;

public class Coche {//caracteristicas de la clase

	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int peso_plataforma;
	 
	private String color;
	private int peso_total;
	private boolean asientos_cuero, climatizador;
	
	public Coche() {// el constructor, define lo que hace, propiedades
		ruedas=4;
		largo=2000;
		ancho=300;
		motor=1600;
		peso_plataforma=500;
		
		
	}
	
	public String dime_datos_generales() {//getter tiene que llevar return, no se modifica el dato
		
		return "La plataforma del veiculo tiene " + ruedas +" ruedas "
				+ ".Mide " + largo/1000 + " metros con un ancho de "+ ancho +
				" cm y un peso de plataforma de  "+ peso_plataforma + " kg. " ;
		}
	
	public void establece_color(String color_coche) {//setter no lleva return, se puede modificar el dato
		                           //Entre parentesis obligamos a que se pida un parametro.
		color=color_coche;
	}
	
	public String dime_color() {
		
		return "El color del coche es " + color;
	}
	
	public void configura_asientos(String asientos_cuero) {//setter
		
		if(asientos_cuero.equalsIgnoreCase("si")) {
			
			this.asientos_cuero=true;
		}else {
			this.asientos_cuero=false;
		}
		
		
	}
	public String dime_asientos() {//getter
		
		if(asientos_cuero==true) {
			
			return "El coche tiene asientos de cuero";
		}else {
			
			return "El coche tiene los asientos de serie";
		}
	}
	
	public void configura_climatizaor(String climatizador) {//SETTER
		
		if(climatizador.equalsIgnoreCase("si")) {
			this.climatizador=true;
		}else{
			this.climatizador=false;
			
		}
	}
	public String dime_climatizador() {//GETTER
		if(climatizador==true) {
			
			return "El coche tiene climatizador";
		}else{
			return "El coche lleva aire acondicionado";
			
		}
	}
	
	public String dime_peso_coche() {//setter+getter, no se rocomienda.
		
		int peso_carroceria=500;
		
		peso_total=peso_plataforma + peso_carroceria;
		
		if(asientos_cuero==true) {
			
			peso_total=peso_total+50;
			}
		if(climatizador==true) {
			
			peso_total=peso_total+20;
		}
		
		return "El pesodel coche es " + peso_total;
	
	}
	public int precio_coche() {//guetter
		
		int precio_final=10000;
		
		if(asientos_cuero==true) {
			precio_final+=2000;
		}
		if(climatizador==true) {
			precio_final+=1500;
		}
		
		return precio_final;
	}
}
