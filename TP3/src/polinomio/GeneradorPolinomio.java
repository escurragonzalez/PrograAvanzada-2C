package polinomio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GeneradorPolinomio {
	private int grado;
	private double valorAEvaluar;
	private double[] coeficientes;

	public GeneradorPolinomio(int grado) {
		this.grado = grado;
		Random random = new Random();
		double[] Coeficientes = new double[grado + 1];

		for (int i = 0; i < grado + 1; i++) {
			double numeroRandom = random.nextInt() + random.nextDouble();
			Coeficientes[i] = numeroRandom;
		}
		this.valorAEvaluar = random.nextDouble();
		this.setCoeficientes(Coeficientes);
	}

	public void setCoeficientes(double[] coeficientes) {
		this.coeficientes = coeficientes;
	}

	public void escribirArchivoSalida(String nombreArchivo) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo));

		salida.println(this.grado);
		for (int i = 0; i <= this.grado; i++)
			salida.println(this.coeficientes[i]);
		salida.println(this.valorAEvaluar);
		salida.close();

	}

	// public static void main(String[] args) {
	// GeneradorPolinomio p = new GeneradorPolinomio(5);
	// p.escribirArchivoSalida("Polinomio_in.txt");
	// }
}
