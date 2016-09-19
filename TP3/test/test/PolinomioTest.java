package test;

import org.junit.*;
import polinomio.*;

public class PolinomioTest {

	// USAR TIMEOUT PARA QUE CORTE SI TARDA MUCHO TIEMPO
	@Ignore
	public void MSucesivasTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(3.5625, p.evualarMSucesivas(0.5), 0.0005);
	}

	@Test
	public void potenciaTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(Math.pow(25, 3), p.potencia(25, 3), 0);
	}
	
	@Ignore
	public void potenciaParTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(Math.pow(25, 3), p.potencia(25, 3), 0);
	}

	@Test
	public void recursivaATest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(3.5625, p.evualarRecursivaConsiderando(0.5), 0.0005);
	}

}
