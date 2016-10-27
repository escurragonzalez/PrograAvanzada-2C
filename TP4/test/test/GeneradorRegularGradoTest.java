package test;

import org.junit.Test;

import tp4.GeneradorRegularGrado;

public class GeneradorRegularGradoTest {

	@Test
	public void test() {
		GeneradorRegularGrado g = new GeneradorRegularGrado(8,2);
		g.escribirArchivo("GeneradorRegularGrado.out");
	}

}
