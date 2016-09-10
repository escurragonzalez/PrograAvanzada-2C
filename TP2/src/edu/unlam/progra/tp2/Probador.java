package edu.unlam.progra.tp2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Probador {
	private MatrizMath matrizCoeficiente;
	private VectorMath vectorTerminoIndependiente;
	private VectorMath vectorIncognita;

	public Probador(String pathIn, String pathOut) throws FileNotFoundException {
		// Archivo In
		Scanner scIn = new Scanner(new File(pathIn));
		scIn.useLocale(Locale.ENGLISH);
		int dim = scIn.nextInt();
		this.matrizCoeficiente = new MatrizMath(dim, dim);
		this.vectorTerminoIndependiente = new VectorMath(dim);
		this.vectorIncognita = new VectorMath(dim);

		double[][] mat = new double[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				mat[scIn.nextInt()][scIn.nextInt()] = scIn.nextDouble();
			}
		}
		this.matrizCoeficiente.setMatriz(mat);
		double[] vec = new double[dim];
		for (int i = 0; i < dim; i++)
			vec[i] = scIn.nextDouble();
		this.vectorTerminoIndependiente.setComponentes(vec);
		scIn.close();

		// Archivo Out
		Scanner scOut = new Scanner(new File(pathOut));
		scOut.useLocale(Locale.ENGLISH);
		int cant = scOut.nextInt();
		double[] vecSalida = new double[cant];
		for (int i = 0; i < cant; i++) {
			vecSalida[i] = scOut.nextDouble();
		}
		this.vectorIncognita.setComponentes(vecSalida);
		scOut.close();
	}

	public boolean probarResultado() {
		MatrizMath inversa = null;
		VectorMath xPrima = null;
		VectorMath bPrima = null;
		VectorMath aux = null;
		inversa = this.matrizCoeficiente.inversa();
		xPrima = inversa.producto(this.vectorTerminoIndependiente);
		bPrima = this.matrizCoeficiente.producto(xPrima);
		// Norma 2 de B - B'
		aux = this.vectorTerminoIndependiente.restar(bPrima);
		double error = aux.normaDos();
		System.out.println(error);
		if (error<10E-2){
			return true;
		}
		return false;
	}
}
