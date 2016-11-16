package test;

import java.io.FileNotFoundException;

import org.junit.Test;

import batiendoAlMinotauro.Laberinto;

public class LaberintoTest {

	@Test
	public void queAndaElCodigo() throws FileNotFoundException {
		Laberinto laberinto = new Laberinto("archivo.in");
		laberinto.kruskal();
		laberinto.escribirArchivo("archivo.out");
	}

}
