package edu.unlam.progra.test;

import org.junit.Ignore;
import org.junit.Test;

import edu.unlam.progra.tp2.SEL;

public class SELTest {

	@Ignore
	public void constructorSELtest() throws Exception {
		SEL s = new SEL("pruebaIncompatible.in");
		System.out.println(s.getMatrizCoeficiente().toString());
		System.out.println(s.getTerminoIndependiente().toString());
		s.resolver();
		System.out.println("\n" + s.getVectorIncognita());
		s.grabarSolucion("A VER SI ANDA.out");
	}
	
	@Test
	public void pruebasTomarTiempoTest() throws Exception{
		SEL s = new SEL("test/pruebas/in/matriz1000.in");
		s.resolver();
	}
}
