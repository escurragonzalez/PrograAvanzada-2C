package test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import polinomio.GeneradorPolinomio;

public class GeneradorTest {

	@Test
	public void test() throws IOException {
		GeneradorPolinomio g = new GeneradorPolinomio(1000, 0.5, "1000");
		Assert.assertNotNull(g);
	}

}
