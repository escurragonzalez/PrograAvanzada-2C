package edu.unlam.progra.test;

import java.io.FileNotFoundException;

import org.junit.Ignore;
import org.junit.Test;

import edu.unlam.progra.tda.VectorMath;
import junit.framework.Assert;

public class VectorMathTest {

	@Ignore
	public void toStringTest() throws FileNotFoundException {
		VectorMath vec = new VectorMath("pruebas/pruebaVector.in");
		System.out.println(vec);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void sumaDeVectoresTest() throws FileNotFoundException {
		VectorMath v = new VectorMath("pruebas/pruebaVector.in");
		VectorMath v2 = new VectorMath("pruebas/pruebaVector.in");
		VectorMath v3 = new VectorMath(5);
		double comp[] = { 2, 2, 10, 10, 6 };
		v3.setComponentes(comp);
		Assert.assertEquals(v3, v.sumar(v2));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void restaDeVectoresTest() throws FileNotFoundException {
		VectorMath v = new VectorMath("pruebas/pruebaVector.in");
		VectorMath v2 = new VectorMath("pruebas/pruebaVector.in");
		VectorMath v3 = new VectorMath(5);
		double comp[] = { 0, 0, 0, 0, 0 };
		v3.setComponentes(comp);
		Assert.assertEquals(v3, v.restar(v2));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void productoEscalarDeVectoresTest() throws FileNotFoundException {
		VectorMath v = new VectorMath("pruebas/pruebaVector.in");
		VectorMath v2 = new VectorMath("pruebas/pruebaVector.in");
		Assert.assertEquals(61.0, v.productoEscalar(v2));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void productoPorUnEscalarTest() throws FileNotFoundException {
		VectorMath v = new VectorMath("pruebas/pruebaVector.in");
		VectorMath v3 = new VectorMath(5);
		double comp[] = { 2, 2, 10, 10, 6 };
		v3.setComponentes(comp);
		Assert.assertEquals(v3, v.productoPorUnEscalar(2));
	}
}
