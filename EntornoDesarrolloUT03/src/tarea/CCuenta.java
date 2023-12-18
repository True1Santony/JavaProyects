package tarea;

public class CCuenta {
	
	double dSaldo; //variable de paquete para pruebas unitarias.
	public static int contador=0; // para que se pare a la tercera ejecucion
		public static void main(String[] args) {
			         // Depuracion. Se detiene siempre
		         CCuenta miCuenta = new CCuenta();
			         System.out.println("Saldo Incial: " + miCuenta.dSaldo + " euros");
			         // Depuracion. Provoca parada por ingreso con cantidad menor de 0
			         miCuenta.ingresar(100);
			         System.out.println("Saldo Incial: " + miCuenta.dSaldo + " euros");
			         miCuenta.ingresar(100);
			         System.out.println("Saldo tras ingreso: " + miCuenta.dSaldo + " euros");
			         miCuenta.ingresar(200);
		         System.out.println("Saldo tras ingreso: " + miCuenta.dSaldo + " euros");
			         // Depuracion. Provoca parada con codicion de tercer ingreso
			         miCuenta.ingresar(300);
			         System.out.println("Saldo tras ingreso: " + miCuenta.dSaldo + " euros");
			         miCuenta.retirar(701);
			         System.out.println("Saldo tras retirada: " + miCuenta.dSaldo + " euros");
			}
		
		public int ingresar(double cantidad) {
			      int iCodErr;
			       if (cantidad < 0)
			      {
			               System.out.println("No se puede ingresar una cantidad negativa");
			               iCodErr = 1;
			       }
			       else if (cantidad == -3)
			      {
			               System.out.println("Error detectable en pruebas de caja blanca");
			               iCodErr = 2;
			       }
			       else
			      {
			              // Depuracion. Punto de parada. Solo en el 3 ingreso
			              dSaldo = dSaldo + cantidad;
			              contador++; //contador para el breakpoint de la tarea
			              iCodErr = 0;
			       }
			       // Depuracion. Punto de parada cuando la cantidad  es menor de 0
			       return iCodErr;
			}
		public int retirar(double cantidad) {
			int error;
			if(cantidad<=0) {
				System.out.println("No se puede retirar '0' o una cantidad negativa");
				error=1;
			}else if(cantidad>dSaldo) {
				System.out.println("No se puede retirar una cantidad mayor al saldo disponible");
				error=2;
			}else {
				error=0;
				dSaldo=dSaldo-cantidad;
			}
			
			return error;
			
		}
}
