package test;

import org.junit.Assert;
import org.junit.Test;

import polinomio.Polinomio;

public class PolinomioTest {

	// USAR TIMEOUT PARA QUE CORTE SI TARDA MUCHO TIEMPO
	@Test
	public void multiplicacionesSucesivasTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(3.5625, p.evaluarMSucesivas(0.5), 0.0005);
	}

	@Test
	public void algoritmoDeHornerTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(3.5625, p.evaluarHorner(0.5), 0.0005);
	}

	@Test
	public void evaluarPowTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(3.5625, p.evaluarPow(0.5), 0.0005);
	}

	@Test
	public void evaluarRecursivaSinConsiderarTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(3.5625, p.evaluarRecursivaSinConsiderar(0.5), 0.0005);
	}

	@Test
	public void evaluarRecursivaSinConsiderarEliasTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(3.5625, p.evaluarRecursivaSinConsiderar(0.5, 4), 0.0005);
	}

	@Test
	public void evaluarRecursivaConsiderandoTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(3.5625, p.evaluarRecursivaConsiderando(0.5), 0.0005);
	}

	@Test
	public void evaluarProgDinamica1Test() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(3.5625, p.evaluarProgDinamica1(0.5), 0.0005);
	}

	@Test
	public void evaluarProgDinamicaTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(3.5625, p.evaluarProgDinamica(0.5), 0.0005);
	}

	@Test
	public void evaluarProgDinamicaMejoradaTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(3.5625, p.evaluarProgDinamicaMejorada(0.5), 0.0005);
	}

	@Test
	public void evaluarRecursivaParTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(3.5625, p.evaluarRecursivaPar(0.5, 4), 0.0005);
	}

	@Test
	public void potenciaTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(Math.pow(25, 3), p.potencia(25, 3), 0);
	}

	@Test
	public void potenciaParTest() {
		double[] d = { 5, 4, 3, 2, 1 };
		Polinomio p = new Polinomio(4, d);
		Assert.assertEquals(Math.pow(25, 3), p.potencia(25, 3), 0);
	}

	// @Test
	// public void recursivaATest() {
	// double[] d = { 5, 4, 3, 2, 1 };
	// Polinomio p = new Polinomio(4, d);
	// Assert.assertEquals(3.5625, p.evualarRecursivaConsiderando(0.5), 0.0005);
	// }

}
