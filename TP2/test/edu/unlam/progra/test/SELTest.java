package edu.unlam.progra.test;

import java.util.*;

import org.junit.*;

import edu.unlam.progra.tp2.SEL;

public class SELTest {

	@Ignore
	public void constructorSELtest() throws Exception {
		SEL s = new SEL("Matriz1000.in");
		System.out.println(s.getMatrizCoeficiente().toString());
		System.out.println(s.getTerminoIndependiente().toString());
		s.resolver();
		System.out.println("\n" + s.getVectorIncognita());
		s.grabarSolucion("Matriz1000.out");
	}

	@Ignore
	public void pruebasTomarTiempoTest() throws Exception {
		SEL s = new SEL("test/pruebas/in/matriz1000.in");
		s.resolver();
	}

	@Test
	public void resolverSel() throws Exception {

		SEL s = new SEL("pruebaIncompatible.in");
		Calendar tIni = new GregorianCalendar();

		s.resolver();

		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();

		s.calculoError();
		System.out.println(diff);

		System.out.println("Error: " + s.getError());
//-Xmx512M
		s.grabarSolucion("pruebaIncompatible.out");
	}
}
