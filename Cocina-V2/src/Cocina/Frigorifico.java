package Cocina;

public class Frigorifico {

	private String marcaFrigo;
	
	 public Frigorifico(){
		 marcaFrigo="";
	 }
	
	
	public void setMarca(String marca) {// ha de ser metodo de paquete
		marcaFrigo=marca;
	}
	
	public String getMarca() {          // ha de ser metodo de paquete
		return marcaFrigo;
	}
}
