package tarzan;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class TarzanTest {

	@Test
	public void test() throws IOException {
		Tarzan prueba = new Tarzan("entrada.in");
		prueba.resolver();
		prueba.getDfs().mostrarPrecedente();
		prueba.grabraSolucion("salida.out");
	}	
}
