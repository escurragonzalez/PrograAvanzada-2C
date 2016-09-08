package edu.unlam.progra.test;

import java.io.FileNotFoundException;

import org.junit.*;

import edu.unlam.progra.tp2.VectorMath;

public class VectorMathTest {

	@Ignore
	public void toStringTest() throws FileNotFoundException {
		VectorMath vec = new VectorMath("pruebas/pruebaVector.in");
		System.out.println(vec);
	}

	@Test
	public void sumaDeVectoresTest() throws FileNotFoundException {
		VectorMath v = new VectorMath("pruebas/pruebaVector.in");
		VectorMath v2 = new VectorMath("pruebas/pruebaVector.in");
		VectorMath v3 = new VectorMath(5);
		double comp[] = { 2, 2, 10, 10, 6 };
		v3.setComponentes(comp);
		Assert.assertEquals(v3, v.sumar(v2));
	}

	@Test
	public void restaDeVectoresTest() throws FileNotFoundException {
		VectorMath v = new VectorMath("pruebas/pruebaVector.in");
		VectorMath v2 = new VectorMath("pruebas/pruebaVector.in");
		VectorMath v3 = new VectorMath(5);
		double comp[] = { 0, 0, 0, 0, 0 };
		v3.setComponentes(comp);
		Assert.assertEquals(v3, v.restar(v2));
	}

	@Test
	public void productoEscalarDeVectoresTest() throws FileNotFoundException {
		VectorMath v = new VectorMath("pruebas/pruebaVector.in");
		VectorMath v2 = new VectorMath("pruebas/pruebaVector.in");
		Assert.assertEquals(61.0, v.producto(v2),0.0);
	}

	@Test
	public void productoPorUnEscalarTest() throws FileNotFoundException {
		VectorMath v = new VectorMath("pruebas/pruebaVector.in");
		VectorMath v3 = new VectorMath(5);
		double comp[] = { 2, 2, 10, 10, 6 };
		v3.setComponentes(comp);
		Assert.assertEquals(v3, v.producto(2));
	}
}
