package edu.unlam.progra.test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Assert;
import org.junit.Test;

import edu.unlam.progra.tp2.MatrizMath;
import edu.unlam.progra.tp2.VectorMath;

public class MathTest {
	
	@Test
	public void constrictorTest() throws FileNotFoundException{
		MatrizMath m1 = new MatrizMath("test/pruebas/matriz1.in");
		Assert.assertNotNull(m1);
	}
	
	@Test
	public void toStringTest() throws FileNotFoundException{
		MatrizMath m1 = new MatrizMath("test/pruebas/matriz1.in");
		//System.out.println(m1);
		Assert.assertNotNull(m1);
	}
	
	@Test
	public void MatrizPorVerctorTest() throws FileNotFoundException{
		MatrizMath m1 = new MatrizMath("test/pruebas/matriz2.in");
		VectorMath v1 = new VectorMath("test/pruebas/vec1.in");
		VectorMath res = new VectorMath("test/pruebas/result1.in");
		Assert.assertEquals(res, m1.multiplicarPorVector(v1));
	}
	
	@Test
	public void pruebaGaussJordan() throws FileNotFoundException{
		MatrizMath m1 = new MatrizMath("test/pruebas/matriz1.in");
		VectorMath v1 = new VectorMath("test/pruebas/vec2.in");
		VectorMath res = new VectorMath("test/pruebas/resultGauss1.in");
		Assert.assertEquals(res,m1.GaussJordan(v1));
	}	                       
}
