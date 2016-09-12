package edu.unlam.progra.test;

import org.junit.Ignore;
import org.junit.Test;

import edu.unlam.progra.tp2.GeneradorMatriz;

public class GeneradorMatrizTest {

	@Ignore
	public void generarMatrizConstructorTest() {
		GeneradorMatriz m1 = new GeneradorMatriz(5);
		System.out.println(m1);
	}

	@Ignore
	public void generarArchivoTest() {
		GeneradorMatriz m1 = new GeneradorMatriz(5);
		m1.escribirArchivoSalida("test/pruebas/out/matriz5x5.out");
	}
	
	@Ignore
	public void generarMatrizOrden500Test() {
		GeneradorMatriz m1 = new GeneradorMatriz(500);
		m1.escribirArchivoSalida("test/pruebas/out/matriz500.out");
	}
	
	@Test
	public void generarMatrizOrden1000Test() {
		GeneradorMatriz m1 = new GeneradorMatriz(3000);
		m1.escribirArchivoSalida("Matriz3000.in");
	}
	
	@Ignore
	public void generarMatrizOrdenTest() {
		GeneradorMatriz m1 = new GeneradorMatriz(10);
		m1.escribirArchivoSalida("test/pruebas/out/mat10.out");		
	}
}
