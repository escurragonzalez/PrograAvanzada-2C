package edu.unlam.progra.test;

import org.junit.Test;

import edu.unlam.progra.tp2.GeneradorMatriz;

public class GeneradorMatrizTest {

	@Test
	public void generarMatrizConstructorTest() {
		GeneradorMatriz m1 = new GeneradorMatriz(5);
		System.out.println(m1);
	}

	@Test
	public void generarArchivoTest() {
		GeneradorMatriz m1 = new GeneradorMatriz(5);
		m1.escribirArchivoSalida("test/pruebas/out/matriz5x5.out");
	}

	@Test
	public void generarMatrizOrden100Test() {
		GeneradorMatriz m1 = new GeneradorMatriz(100);
		m1.escribirArchivoSalida("test/pruebas/out/matriz100x100.out");
	}

	@Test
	public void generarMatrizOrden500Test() {
		GeneradorMatriz m1 = new GeneradorMatriz(500);
		m1.escribirArchivoSalida("test/pruebas/out/matriz500.out");
	}
}
