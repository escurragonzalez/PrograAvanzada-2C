package tarzan;

import java.io.FileNotFoundException;

import org.junit.Test;

public class TarzanTest {

	@Test
	public void test() throws FileNotFoundException {
		Tarzan prueba = new Tarzan("entrada.in");
		prueba.resolver();
	}	
}
