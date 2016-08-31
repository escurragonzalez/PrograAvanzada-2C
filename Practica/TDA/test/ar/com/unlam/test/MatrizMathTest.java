package ar.com.unlam.test;

import java.io.FileNotFoundException;

import org.junit.Test;

import ar.com.unlam.tda.MatrizMath;

public class MatrizMathTest {

	@Test
	public void toStringTest() throws FileNotFoundException {
		MatrizMath mat = new MatrizMath("pruebas/pruebaMatriz.in");
		System.out.println(mat);
	}
}
