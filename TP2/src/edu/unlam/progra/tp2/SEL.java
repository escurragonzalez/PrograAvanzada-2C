package edu.unlam.progra.tp2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class SEL {

	private MatrizMath matrizCoeficiente;
	private VectorMath vectorIncognita;
	private VectorMath terminoIndependiente;
	private int dim;
	private double error;

	public SEL(String archivo) throws FileNotFoundException {

		Scanner sc = new Scanner(new File(archivo));
		this.dim = sc.nextInt();
		this.matrizCoeficiente = new MatrizMath(dim, dim);
		this.terminoIndependiente = new VectorMath(dim);
		this.vectorIncognita = new VectorMath(dim);

		double[][] mat = new double[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				mat[sc.nextInt()][sc.nextInt()] = sc.nextDouble();
			}
		}
		this.matrizCoeficiente.setMatriz(mat);
		double[] vec = new double[dim];
		for (int i = 0; i < dim; i++)
			vec[i] = sc.nextDouble();
		this.terminoIndependiente.setComponentes(vec);
		sc.close();
	}

	public void resolver() throws DistDimException {
		
		Calendar tIni = new GregorianCalendar();
		
		VectorMath result = null;
		result = this.matrizCoeficiente.GaussJordan(this.terminoIndependiente);
		this.vectorIncognita = result;
		
		Calendar tFin = new GregorianCalendar();

		long diff = tFin.getTimeInMillis();
		diff-=tIni.getTimeInMillis();
		System.out.println(diff);
	}
	
	public MatrizMath getMatrizCoeficiente() {
		return matrizCoeficiente;
	}

	public void setMatrizCoeficiente(MatrizMath matrizCoeficiente) {
		this.matrizCoeficiente = matrizCoeficiente;
	}

	public VectorMath getVectorIncognita() {
		return vectorIncognita;
	}

	public void setVectorIncognita(VectorMath vectorIncognita) {
		this.vectorIncognita = vectorIncognita;
	}

	public VectorMath getTerminoIndependiente() {
		return terminoIndependiente;
	}

	public void setTerminoIndependiente(VectorMath terminoIndependiente) {
		this.terminoIndependiente = terminoIndependiente;
	}

	public double getError() {
		return error;
	}

	public void setError(double error) {
		this.error = error;
	}

	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}
	
	private void calculoError(){
		//Inversa de la matriz por coeficiente X'
		MatrizMath matrizInversa = null;
		matrizInversa =	this.matrizCoeficiente.inversa();
		VectorMath xPrima = matrizInversa.multiplicarPorVector(terminoIndependiente);// Es X'
		VectorMath bPrima = matrizCoeficiente.multiplicarPorVector(xPrima);
		
		error = this.terminoIndependiente.restar(bPrima).normaDos();
	}
}