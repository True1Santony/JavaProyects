package tarea;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CCuentaTest {

	@Test
	final void testIngresar() {
		CCuenta cuenta=new CCuenta();
		int resultado=cuenta.ingresar(-100);
		assertEquals(1,resultado);  //metodo devuelve 1
	}
	
	@Test
	final void testIngresar1() {
		CCuenta cuenta=new CCuenta();
		int resultado=cuenta.ingresar(-3);
		assertEquals(2,resultado);  //metodo deberia devolver 2, pero no se usa, fail
	}
	
	@Test
	final void testIngresar2() {
		CCuenta cuenta=new CCuenta();
		int resultado=cuenta.ingresar(300);
		assertEquals(0,resultado); //metodo devuelve 0 si se ha hecho el ingreso.
	}
	
	

}
