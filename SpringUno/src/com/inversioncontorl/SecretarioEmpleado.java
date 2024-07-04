package com.inversioncontorl;

public class SecretarioEmpleado implements Empleados {

	private CreacionInformes informeNuevo;
	
	private String mail, nombreEmpresa;
	
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getNombreEmpresa() {
		return nombreEmpresa;
	}



	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}


	public void setInformeNuevo(CreacionInformes informeNuevo) {
		
		this.informeNuevo = informeNuevo;
		
	}

	
	@Override
	public String getTareas() {
		
		return "Gestiono la agenda de los Jefes";
	}

	@Override
	public String getInforme() {
		
		return "Soy el Secretario, doy el informe: "+ informeNuevo.getInforme();
	}

}
