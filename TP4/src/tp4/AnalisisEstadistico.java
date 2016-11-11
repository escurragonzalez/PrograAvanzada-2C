package tp4;

import java.io.FileNotFoundException;

public class AnalisisEstadistico {

	public static void main(String[] args) throws FileNotFoundException {
		int nodos = 600;
		double adyacencia = 0.4;
		int cantMenorColor = Integer.MAX_VALUE;
		int corridaMenorColor = 0;
		// GeneradorAleatorioPorcentaje generador = new GeneradorAleatorioPorcentaje(nodos, adyacencia);
		GeneradorAleatorioProbabilidad generador = new GeneradorAleatorioProbabilidad(nodos, adyacencia);
		// GeneradorRegularPorcentaje generador = new GeneradorRegularPorcentaje(nodos, adyacencia);

		generador.escribirArchivo("coloreo.out");
		GrafoNDNP coloreo = new GrafoNDNP("coloreo.out");

		for (int i = 0; i < 10; i++) {

			coloreo.SecuenciaAleatorio();
			if (cantMenorColor < coloreo.getCantColores()) {
				cantMenorColor = coloreo.getCantColores();
				corridaMenorColor = i + 1;
			}
		}
		System.out.println("Menor Cantidad de color: " + cantMenorColor);
		System.out.println("En la corrida: " + corridaMenorColor);
	}
}