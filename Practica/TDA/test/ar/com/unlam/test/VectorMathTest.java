package ar.com.unlam.test;

import java.io.FileNotFoundException;

import org.junit.Ignore;
import org.junit.Test;

import ar.com.unlam.tda.VectorMath;

public class VectorMathTest {

	@Ignore
	public void toStringTest() throws FileNotFoundException {
		VectorMath vec = new VectorMath("pruebas/pruebaVector.in");
		System.out.println(vec);
	}
	
	@Test
	public void sumaDeVectoresTest(){
		
	}
}
