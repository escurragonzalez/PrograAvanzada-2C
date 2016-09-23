package polinomio;

import java.util.Random;
import java.io.*;

public class GeneradorPolinomio {
	private int grado;
	private double[] coeficientes;

	public GeneradorPolinomio(int grado) {
		this.grado = grado;
		Random random = new Random();
		double[] Coeficientes = new double[grado + 1];

		for (int i = 0; i < grado+1; i++) {
			double numeroRandom = random.nextInt() + random.nextDouble();
			Coeficientes[i] = numeroRandom;
		}
		this.setCoeficientes(Coeficientes);
	}

	public void setCoeficientes(double[] coeficientes) {
		this.coeficientes = coeficientes;
	}

	public void escribirArchivoSalida(String archivo) {
		FileWriter fichero = null;
		PrintWriter pw = null;

		try {
			fichero = new FileWriter(archivo);
			pw = new PrintWriter(fichero);

			pw.println(this.grado);
			for (int i = 0; i <= this.grado; i++)
				pw.println(this.coeficientes[i]);

		} catch (Exception e) {
			System.out.println("Error de Escritura de Archivo " + e.getMessage());
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				System.out.println("Error de Escritura de Archivo " + e2.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		GeneradorPolinomio p = new GeneradorPolinomio(5);
		p.escribirArchivoSalida("Polinomio_in.txt");
	}
}
