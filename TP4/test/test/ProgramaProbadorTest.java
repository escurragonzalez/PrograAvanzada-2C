package test;

import java.io.FileNotFoundException;

import org.junit.Test;

import tp4.ProgramaProbador;

public class ProgramaProbadorTest {

	@Test
	public void test() throws FileNotFoundException {
		ProgramaProbador p = new ProgramaProbador("GrafoNDNP.in","GrafoNDNP.out");
		p.escribirSalida("salidaProador");
	}

}
