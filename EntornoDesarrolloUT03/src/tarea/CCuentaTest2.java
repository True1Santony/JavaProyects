package tarea;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CCuentaTest2 {

	@Test
	final void testRetirar0() {
		
		CCuenta cuenta=new CCuenta();
		cuenta.dSaldo=700;                   //establezco el saldo que se hizo en la ejecuccion del programa
		int resultado=cuenta.retirar(25);    //parametro
		assertEquals(0,resultado);           //resultado eserado.
	}
	@Test
	final void testRetirar1() {
		
		CCuenta cuenta=new CCuenta();
		cuenta.dSaldo=700;                   //establezco el saldo que se hizo en la ejecuccion del programa
		int resultado=cuenta.retirar(570);   //parametro
		assertEquals(0,resultado);           //resultado eserado.
	}
	@Test
	final void testRetirar2() {
		
		CCuenta cuenta=new CCuenta();
		cuenta.dSaldo=700;                   //establezco el saldo que se hizo en la ejecuccion del programa
		int resultado=cuenta.retirar(-300);  //parametro
		assertEquals(1,resultado);           //resultado eserado.
	}
	@Test
	final void testRetirar3() {
		
		CCuenta cuenta=new CCuenta();
		cuenta.dSaldo=700;                   //establezco el saldo que se hizo en la ejecuccion del programa
		int resultado=cuenta.retirar(1500);   //parametro
		assertEquals(2,resultado);           //resultado eserado.
	}
	@Test
	final void testRetirar4() {
		
		CCuenta cuenta=new CCuenta();
		cuenta.dSaldo=700;                   //establezco el saldo que se hizo en la ejecuccion del programa
		int resultado=cuenta.retirar(1);     //parametro
		assertEquals(0,resultado);           //resultado eserado.
	}
	@Test
	final void testRetirar5() {
		
		CCuenta cuenta=new CCuenta();
		cuenta.dSaldo=700;                   //establezco el saldo que se hizo en la ejecuccion del programa
		int resultado=cuenta.retirar(700);   //parametro
		assertEquals(0,resultado);           //resultado eserado.
	}
	@Test
	final void testRetirar6() {
		
		CCuenta cuenta=new CCuenta();
		cuenta.dSaldo=700;                   //establezco el saldo que se hizo en la ejecuccion del programa
		int resultado=cuenta.retirar(0);   //parametro
		assertEquals(1,resultado);           //resultado eserado.
	}
	@Test
	final void testRetirar7() {
		
		CCuenta cuenta=new CCuenta();
		cuenta.dSaldo=700;                   //establezco el saldo que se hizo en la ejecuccion del programa
		int resultado=cuenta.retirar(701);   //parametro
		assertEquals(2,resultado);           //resultado eserado.
	}

}
