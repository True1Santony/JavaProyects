
public class Cocina {//clase principal

	private String cocina_nombre;    
	
	private boolean si_no_frigo;
	
	private boolean si_no_placa;
	
	private String miFrig;
	
	private String miPlaca;
	
	
	public Cocina(){//constructor
		
		cocina_nombre="";
		si_no_frigo=false;
		si_no_placa=false;
	    miFrig="";
		miPlaca="";
}
	public void asignaColorPlaca(String color) {//setter, para que recoja el color de la clase placa
		
		miPlaca=color;
	}
	
	public void asignaNomCocina(String cocina_nombre) {//setter, para asignar el nombre a la cocina.
		
		this.cocina_nombre=cocina_nombre;
	}
	public void asignaMarcaFrigo(String asigna_marca_frigo) {//setter, para asignar un amarca al frigorifico
		
		miFrig=asigna_marca_frigo;
	}
	
	public void preguntaFrigorifico(String respuesta) {//setter
		
		if(respuesta.equalsIgnoreCase("si")) {
			si_no_frigo=true;
		}else {
			si_no_frigo=false;
		}
	}
	
    public void preguntaPlaca(String respuesta) {//setter, 
		
		if(respuesta.equalsIgnoreCase("si")) {
			si_no_placa=true;
		}else {
			si_no_placa=false;
		}
    }
	public String infoMob() {//getter, mostrar por consola el equipamiento de la cocina.
		
		if(si_no_frigo==false && si_no_placa==false) {
			
			return "La cocina: "+ cocina_nombre+" no tiene frigorífico ni tiene placa. ";
			
		}else if(si_no_frigo==true && si_no_placa==false){
			
			return "La cocina: "+ cocina_nombre+". Tiene un frigorífico de la marca: "+ miFrig+" y no tiene placa." ;
			
		}else if(si_no_frigo==false && si_no_placa==true) {
			
			return "La cocina: "+ cocina_nombre+". No tiene frigorifico "+ " El color de la placa es: " + miPlaca ;
		}else {
			return "La cocina: " + cocina_nombre+ ". Tine el frigorifico de la marca: " + miFrig+" y tiene la placa de color: "+ miPlaca;
		}
	}
}
