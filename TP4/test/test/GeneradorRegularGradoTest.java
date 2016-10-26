package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp4.GeneradorRegularGrado;

public class GeneradorRegularGradoTest {

	@Test
	public void test() {
		GeneradorRegularGrado g = new GeneradorRegularGrado(8,4);
		g.escribirArchivo("GeneradorRegularGrado.out");
	}

}
