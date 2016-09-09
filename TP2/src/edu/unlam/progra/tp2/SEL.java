package sel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

	public void resolver() throws Exception {

		Calendar tIni = new GregorianCalendar();

		VectorMath result = null;
		result = this.matrizCoeficiente.gaussJordan(this.terminoIndependiente);
		this.vectorIncognita = result;

		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		this.calculoError();
		System.out.println("TIEMPO DE EJECUCIÓN: " + diff);
		System.out.println("Error: " + this.getError());
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

	private void calculoError() {
		// Inversa de la matriz por coeficiente X'
		MatrizMath matrizInversa = null;
		matrizInversa = this.matrizCoeficiente.inversa();
		VectorMath xPrima = matrizInversa.producto(terminoIndependiente);// Es
																			// X'
		VectorMath bPrima = matrizCoeficiente.producto(xPrima);

		error = this.terminoIndependiente.restar(bPrima).normaDos();
	}

	public void grabarSolucion(String nombreArchivo) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo));

		salida.println(this.getVectorIncognita().getDimension());
		for (int i = 0; i < this.getVectorIncognita().getDimension(); i++) {
			salida.println(this.getVectorIncognita().getComponentes()[i]);
		}
		salida.println(this.getError());

		salida.close();
	}

}
