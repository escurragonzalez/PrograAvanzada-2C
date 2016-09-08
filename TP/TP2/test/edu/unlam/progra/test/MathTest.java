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
	public void PruebaGaussJordan() throws FileNotFoundException{
		MatrizMath m1 = new MatrizMath("mat1.in");
		VectorMath m2 = new VectorMath("vec1.in");
		System.out.println(m1.GaussJordan(m2));
	}	                       
}
