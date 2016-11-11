package tp4;

import java.io.FileNotFoundException;

public class AnalisisEstadistico {

	public AnalisisEstadistico(int nodos, double adyacencia) {
		GeneradorAleatorioPorcentaje generador = new GeneradorAleatorioPorcentaje(nodos, adyacencia);
		generador.escribirArchivo("coloreo.out");
	}

	public void secuenciaAleatorio() throws FileNotFoundException {
		int cantMenorColor = 0;
		int corridaMenorColor = 0;
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

	public static void main(String[] args) throws FileNotFoundException {
		AnalisisEstadistico analisis = new AnalisisEstadistico(600, 0.4);
		analisis.secuenciaAleatorio();
	}
}