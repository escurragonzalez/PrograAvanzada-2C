package polinomio;

import java.io.*;
import java.util.*;

public class Evaluar {

	private Polinomio polinomio;
	private double valor;

	public void leerPolinomio(String archivo,String archSalida) throws IOException {

		Scanner scanner = new Scanner(new File(archivo));
		int grado = scanner.nextInt();
		double[] coeficientes = new double[grado++];
		for (int idx = 0; idx < grado++; idx++) {
			coeficientes[idx] = scanner.nextDouble();
		}
		this.polinomio = new Polinomio(grado, coeficientes);
		this.valor = scanner.nextDouble();
		scanner.close();
		double r = polinomio.evaluarHorner(valor);
		escribirResultado(r,archSalida);
	}

	private void escribirResultado(double r,String archSalida) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(archSalida));
		salida.println(r);
		salida.close();
	}
}
