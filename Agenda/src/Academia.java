
public class Academia {
	
	//public static Object academia2="ingles";
	private String nombre;                 //no puede ser estatico, porque tendría que ser un mismo nombre compartido para todos los objetos (o musica o baile o ingles).
	private int reservaSesUno;             //el nombre no es un valor de clase, si no de objeto.
	private int reservaSesDos;             //ademas en el propio enunciado pone que "instanciemos" las 3 instancias.
	private String alumnUnoSesUno;
	private String alumnDosSesUno;
	private String alumnUnoSesDos;
	private String alumnDosSesDos;
	final int NUMPLAZAS=2;
	
	private int numPlaza;
	private int sesion;
	
	
	public Academia(String nombre) {  //unico constructor.
		 
		this.nombre=nombre;
		int reservaSesUno=0;
		int reservaSesDos=0;
		String alumnUnoSesUno="";
		String alumnDosSesUno="";
		String alumnUnoSesDos="";
		String alumnDosSesDos="";
		final int NUMPLAZAS=2;
	}	
	
	public boolean comprobarDisp(int sesion) {                      //comprueba e incrementa, va al final de cada vuelta, para que la primera vuelta el valor inicial sea 0.
		 boolean plaza=false;
		if(sesion==10 && this.reservaSesUno<NUMPLAZAS) {
			this.reservaSesUno++;
			plaza = true;
		}else if(sesion==10 && this.reservaSesUno>NUMPLAZAS){
			plaza = false;
		}else if(sesion==11 && reservaSesDos<NUMPLAZAS) {
			plaza = true;
			this.reservaSesDos++;
		}else if(sesion==11 && reservaSesDos>NUMPLAZAS){
			plaza = false;
		}
		return plaza;
	}
	
	/*public void  asignaNombre(int posicionArrayList) { PRUEBAS, CODIGO NO EJECUTADO, lo dejo por si en un futuro hace falta.
		if(reservaSesUno==0){
			alumnUnoSesUno=Agenda.asistentes.get(posicionArrayList);
		}else if(reservaSesUno==1) {
			alumnDosSesUno=Agenda.asistentes.get(posicionArrayList);
		}else if(reservaSesDos==0) {
			alumnUnoSesDos=Agenda.asistentes.get(posicionArrayList);
		}else if(reservaSesDos==1) {
			alumnUnoSesUno=Agenda.asistentes.get(posicionArrayList);
		}
		
	}*/
	public void reservaPlaza(int sesion, String nombre) {            //Asigna un alumno en funcion de estado de reservas y la sesion.
		if(sesion==10 && reservaSesUno==0) {
			alumnUnoSesUno=nombre;
		}else if(sesion==10 && reservaSesUno==1) {
			alumnDosSesUno=nombre;
		}else if(sesion==11 && reservaSesDos==0) {
			alumnUnoSesDos=nombre;
		}else if(sesion==11 && reservaSesDos==1) {
			alumnDosSesDos=nombre;
		}
	}
		
	public String infoSesion(int sesion) {                          //da nombre del objeto, usa metodo para asignar hora y usa metodo para mostrar asistentes en funcion de la sesion.
		System.out.println("--------------------------------------------------------------------------------");
		return "Academia: "+nombre+ "--Sesion: "+horaSesion(sesion)+"--Asistentes: "+muestraAsistentes(sesion);
		}
		
	
	public int mostrarSesUno() {                              //main
		return this.reservaSesUno;
	}
	
	public int mostrarSesDos() {                               //main
		return this.reservaSesDos;
	}
	
	/*public String muestraNomAcademia() {                 no se usa
		return nombre;
	}*/  
	
	public String horaSesion(int hora ) {                        //para metodo infoSesion
		if(hora==10) {
			return "10:00";
		}else{
		return "11:00";}
	}
	
	public String muestraAsistentes(int sesion) {               //para metodo infoSesion
		String cadena="";
		if (sesion==10) { 
			cadena=alumnUnoSesUno+" "+alumnDosSesUno;
		}else if(sesion==11) { 
			cadena=alumnUnoSesDos+" "+alumnDosSesDos;
		}
		return cadena;
		}
	}

