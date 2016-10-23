package test;
import java.io.FileNotFoundException;

import org.junit.Test;

import tp4.GeneradorAleatorioProbabilidad;

public class GeneradorAleatorioProbabilidadTest {

	@Test
	public void test() throws FileNotFoundException {
		GeneradorAleatorioProbabilidad g= new GeneradorAleatorioProbabilidad(10, 0.5);
		g.escribirArchivo("01.out");
	}
}
