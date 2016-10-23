package test;

import java.io.FileNotFoundException;

import org.junit.Test;

import tp4.GeneradorAleatorioPorcentaje;

public class GeneradorAleatorioPorcentajeTest {

	@Test
	public void test() throws FileNotFoundException {
		GeneradorAleatorioPorcentaje g= new GeneradorAleatorioPorcentaje(12, 1);
		g.escribirArchivo("01.out");
	}
}
