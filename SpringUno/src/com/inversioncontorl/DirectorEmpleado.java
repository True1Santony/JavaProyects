package com.inversioncontorl;

public class DirectorEmpleado implements Empleados {

	//un campo de la interfaz CreacionInformes
	private CreacionInformes informeNuevo;
	
	//constructor que invecta la dependencia
	public DirectorEmpleado (CreacionInformes informeNuevo) {
		
		this.informeNuevo=informeNuevo;
	}
	
	
	@Override
	public String getTareas() {
		
		return "Contrato y despido a la plantilla de la empresa";
	}

	//metodo de la interfaz Empleados que genera un informe
	//lo crea con el objeto Informe, interfaz CreacionInformes
	@Override
	public String getInforme() {
		
		return "Informe creado por el Director: " + informeNuevo.getInforme();
	}

	//metodo init Ejecutar tareas antes de que el Bean este disponible
	
	public void init() {
		
		System.out.println("metod init ejecunandose, antes de que el bean este disponible");
		
	}
	
	//metodo destroy, se ejecuta cuando el biean se ha utilizado
	
    public void destroy() {
		
		System.out.println("metod destroy ejecunandose, despues de utilizar el bean");
		
	}
	
}
