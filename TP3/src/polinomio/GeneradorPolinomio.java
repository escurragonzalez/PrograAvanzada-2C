package polinomio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GeneradorPolinomio {

	public GeneradorPolinomio(int grado, double numeroAEvaluar, String nombreArchivo) throws IOException {

		Random random = new Random();
		double[] coeficientes = new double[grado + 1];

		for (int i = 0; i < grado + 1; i++) {
			double numeroRandom = random.nextInt() + random.nextDouble();
			coeficientes[i] = numeroRandom;
		}
		// this.valorAEvaluar = random.nextDouble();

		escribirArchivoSalida(nombreArchivo, grado, numeroAEvaluar, coeficientes);
	}

	public void escribirArchivoSalida(String nombreArchivo, int grado, double valorAEvaluar, double[] coeficientes)
			throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo));

		salida.println(grado);
		for (int i = 0; i <= grado; i++)
			salida.println(coeficientes[i]);
		salida.println(valorAEvaluar);
		salida.close();

	}
}
