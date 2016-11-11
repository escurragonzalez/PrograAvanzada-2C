package test;

import java.io.FileNotFoundException;

import org.junit.Test;

import tp4.GeneradorAleatorioPorcentaje;
import tp4.GrafoNDNP;

public class AnalisisEstadistico {

	@Test
	public void secuenciaAleatoria() throws FileNotFoundException {
		int nodos = 600;
		double adyacencia = 0.4;
		int cantMenorColor = 0;
		int corridaMenorColor = 0;
		GeneradorAleatorioPorcentaje generador = new GeneradorAleatorioPorcentaje(nodos, adyacencia);

		generador.escribirArchivo("coloreo.out");
		GrafoNDNP coloreo = new GrafoNDNP("coloreo.out");

		for (int i = 0; i < 100; i++) {

			coloreo.SecuenciaAleatorio();
			if (cantMenorColor < coloreo.getCantColores()) {
				System.out.println(cantMenorColor);
				cantMenorColor = coloreo.getCantColores();
				corridaMenorColor = i + 1;
			}
		}
		System.out.println("Menor Cantidad de color: " + cantMenorColor);
		System.out.println("En la corrida: " + corridaMenorColor);
	}

}
