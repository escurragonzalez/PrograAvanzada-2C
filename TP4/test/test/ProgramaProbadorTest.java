package test;

import java.io.FileNotFoundException;

import org.junit.Test;

import junit.framework.Assert;
import tp4.ProgramaProbador;

public class ProgramaProbadorTest {

	@Test
	public void test() throws FileNotFoundException {
		ProgramaProbador p = new ProgramaProbador("GrafoNDNP.in", "GrafoNDNP.out");
		Assert.assertTrue(p.programaProbador());
	}

}
