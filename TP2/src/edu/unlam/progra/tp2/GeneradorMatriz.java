package edu.unlam.progra.tp2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GeneradorMatriz {

	private MatrizMath matrizCoeficientes;
	private VectorMath vectorTerminosIndependientes;
	private int dimension;

	public GeneradorMatriz(int dimension) {
		this.matrizCoeficientes = new MatrizMath(dimension, dimension);
		this.vectorTerminosIndependientes = new VectorMath(dimension);
		this.dimension= dimension;
		generarVectorRandom();
		generarMatrizRandom();
	}

	private double generarNumeroRandom() {
		double numeroRandom;
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100000);
		double randomDouble = randomGenerator.nextDouble();
		numeroRandom = ((double) randomInt) + randomDouble;
		return numeroRandom;
	}

	private void generarMatrizRandom() {
		double[][] componentes = new double[this.dimension][this.dimension];
		for (int i = 0; i < this.dimension; i++)
			for (int j = 0; j < this.dimension; j++)
				componentes[i][j] = this.generarNumeroRandom();
		this.matrizCoeficientes.setMatriz(componentes);
	}

	private void generarVectorRandom() {
		double[] componentes = new double[this.dimension];
		for (int i = 0; i < this.dimension; i++)
			componentes[i] = this.generarNumeroRandom();
		this.vectorTerminosIndependientes.setComponentes(componentes);
	}

	public void escribirArchivoSalida(String archOut) {
		FileWriter archivo = null;
		PrintWriter pw = null;
		try {
			archivo = new FileWriter(archOut);
			pw = new PrintWriter(archivo);
			pw.println(this.vectorTerminosIndependientes.getDimension());

			for (int i = 0; i < this.matrizCoeficientes.getFila(); i++)
				for (int j = 0; j < this.matrizCoeficientes.getColumna(); j++)
					pw.println(i + " " + j + " " + this.matrizCoeficientes.getMatriz()[i][j]);

			for (int k = 0; k < this.vectorTerminosIndependientes.getDimension(); k++)
				pw.println(this.vectorTerminosIndependientes.getComponentes()[k]);

		} catch (Exception e) {
			System.out.println("Error de Escritura Archivo de Salida - " + e.getMessage());
		} finally {
			if (null != archivo) {
				try {
					archivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
