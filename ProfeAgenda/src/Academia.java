
public class Academia {
	final int NUMPLAZAS = 2;		// Numero maximo de alumnos por sesion
	String nombre;					// Nombre de la actividad. Recibida por el constructor
	private int reservasSesUno;		// Reservas ya realizadas en la sesion uno
	private int reservasSesDos;		// Reservas ya realizadas en la sesion dos
	private String alumUnoSesUno;	// Nombre del primer alumno que asiste a la sesion uno
	private String alumDosSesUno;	// Nombre del segundo alumno que asiste a la sesion uno
	private String alumUnoSesDos;	// Nombre del primer alumno que asiste a la sesion dos
	private String alumDosSesDos;	// Nombre del segundo alumno que asiste a la sesion dos
	
	
	public Academia (String sNombre) {
		if (sNombre.equals("Baile")) {
			nombre = sNombre + " ";	// Anadido un espacio por estetica en la salida resumen final.
		}
		else {
			nombre = sNombre;
		}
			
		reservasSesUno = 0;			// El valor por defecto en la inicializacion tambien seria 0
		reservasSesDos = 0;
		alumUnoSesUno = "";			// El valor por defecto en la incializacion tambien seria ""
		alumUnoSesDos = "";
		alumDosSesUno = "";
		alumDosSesDos = "";
	}
	
	private boolean comprobarDisp (int iSesion) {
		boolean bResul = true;				// Por defecto se considera que hay plazas.
		
		if((iSesion == 1) && reservasSesUno == NUMPLAZAS)	{	// Todas las plazas de la sesion uno ocupadas
			bResul = false;					// Uppps. No quedan plazas
		}

		else if((iSesion == 2) && reservasSesDos == NUMPLAZAS)	{	// Todas las plazas de la sesion dos ocupadas
			bResul = false;					// Uppps. No quedan plazas
		}
		else if (iSesion != 1 && iSesion != 2) {
			bResul = false;			
		}
		
		return bResul;
	}
	
	boolean reservarPlaza (int iSesion, String sNombre) {
		boolean bResul = comprobarDisp(iSesion);	// Comprueba si hay plazas para esa sesion.
		
		if(bResul) {								// Si hay plazas
			if(iSesion == 1) {
				if(reservasSesUno == 0) {			// Primera plaza de la sesion uno no reservada
					alumUnoSesUno = sNombre;
				}
				else {
					alumDosSesUno = sNombre;
				}
				reservasSesUno++;
			}
			else if(iSesion == 2) {
				if(reservasSesDos == 0) {			// Primera plaza de la sesion dos no reservada
					alumUnoSesDos = sNombre;
				}
				else {
					alumDosSesDos = sNombre;
				}
				reservasSesDos++;
			}
		}
		
		return bResul;
	}
	
	String infoSesion(int iSesion) {
		String sResult = "";
		
		if(iSesion == 1) {						// Sesion uno
			if (reservasSesUno == 0) {			// No hay asistentes
				sResult = "Academia: " + nombre + " -- Sesion: 10:00-11:00 -- Asistentes: " + "no hay reservas"; 
			}			
			else if (reservasSesUno == 1) {		// Hay un asistentes
				sResult = "Academia: " + nombre + " -- Sesion: 10:00-11:00 -- Asistentes: " + alumUnoSesUno; 
			}			
			else {								// Dos asistentes
				sResult = "Academia: " + nombre + " -- Sesion: 10:00-11:00 -- Asistentes: " + alumUnoSesUno + ", " + alumDosSesUno; 
			}
			
		}
		else if(iSesion == 2){								// Sesion dos
			if (reservasSesDos == 0) {			// No hay asistentes
				sResult = "Academia: " + nombre + " -- Sesion: 11:00-12:00 -- Asistentes: " + "no hay reservas"; 
			}			
			else if (reservasSesDos == 1) {		// Hay un asistentes
				sResult = "Academia: " + nombre + " -- Sesion: 11:00-12:00 -- Asistentes: " + alumUnoSesDos; 
			}			
			else {								// Dos asistentes
				sResult = "Academia: " + nombre + " -- Sesion: 11:00-12:00 -- Asistentes: " + alumUnoSesDos + ", " + alumDosSesDos; 
			}
		}
		
		return sResult;
	}
}
