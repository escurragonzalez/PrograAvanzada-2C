package test;

import java.io.FileNotFoundException;

import org.junit.Test;

import tp4.GrafoNDNP;

public class GrafoNDNPTest {

	@Test
	public void queAndaElColoreoSecuenciaAleatorio() throws FileNotFoundException {
		GrafoNDNP grafo = new GrafoNDNP("GrafoNDNP.in");
		grafo.SecuenciaAleatorio();
		grafo.escribirArchivo("GrafoNDNPSecuenciaAleatoria.out");
	}
	
	@Test
	public void queAndaElColoreoWelshPowell() throws FileNotFoundException {
		GrafoNDNP grafo = new GrafoNDNP("GrafoNDNP.in");
		grafo.welshPowell();
		grafo.escribirArchivo("GrafoNDNPWelshPowell.out");
	}

}
