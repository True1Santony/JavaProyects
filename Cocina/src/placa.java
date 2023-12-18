
public class placa {//clase principal
	
	private String color;
	
		public placa() {//constructor, aunque parece que se puede prescindir.
			
			color="";
		}
		public String dimeColor() {//getter para devolver el color de la placa.
			
			return color;
		}
		
		public void setColor() {//setter, para el color aleatorio, lo encapsulo por si da un valor inesperado.
			
			try {double variable = Math.random()*10;
			int num = (int)variable;
			
			if(num<3) {
				
				color="Marrón";
				
				}else if(num<6 && num>3){
					
					color="Azul";
				}else {
					
					color="Verde";
				}
		}catch (Exception e) {
			
			System.out.println("El metodo math ha devueto un valor inesperado, vuelva a ejecutar el programa.");
			
		}
		}
		
		public String getColor(String devuelve_color_placa) {//getter para devolver el color aleatorio mas comentario.
			
			return "El color de la placa es: " + color;
		}
	
		
	
	}
