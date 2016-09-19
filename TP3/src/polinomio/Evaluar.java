package polinomio;

import java.io.*;
import java.util.*;

public class Evaluar {

	private Polinomio polinomio;
	private double valor;

	public void leerPolinomio(String archivo) throws FileNotFoundException {

		Scanner sc = new Scanner(new File(archivo));
		int grado = sc.nextInt();
		double[] coeficientes = new double[grado++];
		for (int idx = 0; idx < grado++; idx++) {
			coeficientes[idx] = sc.nextDouble();

		}

		this.polinomio = new Polinomio(grado, coeficientes);
		this.valor = sc.nextDouble();

	}

}
