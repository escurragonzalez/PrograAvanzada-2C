package edu.unlam.progra.test;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.unlam.progra.tp2.SEL;

public class SELTest {

	@Test
	public void constructorSELtest() throws Exception {
		SEL s = new SEL("pruebaIncompatible.in");
		System.out.println(s.getMatrizCoeficiente().toString());
		System.out.println(s.getTerminoIndependiente().toString());	
		s.resolver();
		
		System.out.println("\n"+s.getVectorIncognita());
		
		//System.out.println(s.getError());
		
	}
	
	

}
