package polinomio;

import java.io.*;
import java.util.*;

public class Evaluar {

	private Polinomio polinomio;
	private double valor;

	public void leerPolinomio(String archivo) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File(archivo));
		int grado = scanner.nextInt();
		double[] coeficientes = new double[grado++];
		for (int idx = 0; idx < grado++; idx++) {
			coeficientes[idx] = scanner.nextDouble();

		}

		this.polinomio = new Polinomio(grado, coeficientes);
		this.valor = scanner.nextDouble();

	}

}
