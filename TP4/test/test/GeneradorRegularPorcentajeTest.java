package test;

import org.junit.Test;

import tp4.GeneradorRegularPorcentaje;

public class GeneradorRegularPorcentajeTest {
	
	@Test
	public void test() {
		GeneradorRegularPorcentaje g = new GeneradorRegularPorcentaje(6,0.5);
		g.escribirArchivo("GeneradorRegularPorcentaje.out");
	}


}
