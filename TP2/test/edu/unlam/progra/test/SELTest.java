package edu.unlam.progra.test;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.unlam.progra.tp2.SEL;

public class SELTest {

	@Test
	public void constructorSELtest() throws FileNotFoundException {
		SEL s = new SEL("prueba.in");
		System.out.println(s.getMatrizCoeficiente().toString());
		System.out.println(s.getTerminoIndependiente().toString());	
		s.resolver();
		System.out.println(s.getVectorIncognita());
		
		System.out.println(s.getError());
		
	}
	
	

}
