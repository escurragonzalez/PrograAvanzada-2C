package ar.com.unlam.test;

import java.io.FileNotFoundException;

import org.junit.Ignore;

import ar.com.unlam.tda.MatrizMath;

public class MatrizMathTest {

	@Ignore
	public void toStringTest() throws FileNotFoundException {
		MatrizMath mat = new MatrizMath("pruebas/pruebaMAtriz.in");
		System.out.println(mat);
	}
	
	
}
