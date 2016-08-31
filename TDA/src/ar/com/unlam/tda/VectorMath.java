package ar.com.unlam.tda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class VectorMath {

	private int dimension;
	private double[] componentes;

	public VectorMath(int dimension) {
		setDimension(dimension);
		this.componentes = new double[dimension];
	}

	public VectorMath(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		double[] vec = new double[sc.nextInt()];
		setDimension(vec.length);
		for (int i = 0; i < getDimension(); i++) {
			vec[i] = sc.nextDouble();
		}
		setComponentes(vec);
		sc.close();
	}

	public void setDimension(int dim) {
		this.dimension = dim;
	}

	public int getDimension() {
		return this.dimension;
	}

	public double[] getComponentes() {
		return this.componentes;
	}

	public void setComponentes(double[] componentes) {
		setDimension(componentes.length);
		this.componentes = new double[getDimension()];
		for (int i = 0; i < getDimension(); i++) {
			this.componentes[i] = componentes[i];
		}
	}

	public VectorMath sumar(VectorMath vector) {
		VectorMath resultado = new VectorMath(getDimension());
		if (this.getDimension() != vector.getDimension())
			throw new DistDimException("Distinta Dimension");
		for (int i = 0; i < this.getDimension(); i++)
			resultado.componentes[i] = this.componentes[i] + vector.componentes[i];
		return resultado;
	}

	public VectorMath restar(VectorMath vector) {
		VectorMath resultado = new VectorMath(getDimension());
		if (this.getDimension() != vector.getDimension())
			throw new DistDimException("Distinta Dimension");
		for (int i = 0; i < this.getDimension(); i++)
			resultado.componentes[i] = this.componentes[i] - vector.componentes[i];
		return resultado;
	}

	public double productoEscalar(VectorMath vector) {
		double resultado = 0;
		if (this.getDimension() != vector.getDimension())
			throw new DistDimException("Distinta Dimension");
		for (int i = 0; i < this.getDimension(); i++)
			resultado += this.componentes[i] * vector.componentes[i];
		return resultado;
	}

	public VectorMath productoVectorMatriz(MatrizMath matriz) {
		VectorMath resultado = new VectorMath(this.getDimension());
		if (this.getDimension() != matriz.getDimensionFil())
			throw new DistDimException("Distinta Dimension");
		for (int i = 0; i < this.getDimension(); i++)
			for (int j = 0; j < matriz.getDimensionCol(); j++) {
				resultado.componentes[i] += this.componentes[j] * matriz.getComponentes()[j][i];
			}

		return resultado;
	}

	public VectorMath producto(double numero) {
		double[] componentes = new double[this.getDimension()];
		VectorMath vector = new VectorMath(this.getDimension());
		for (int i = 0; i < this.getDimension(); i++) {
			componentes[i] = this.getComponentes()[i] * numero;
		}
		vector.setComponentes(componentes);
		return vector;
	}

	public String toString() {
		String resultado = "";
		resultado += "( ";
		for (int i = 0; i < componentes.length; i++) {
			resultado += componentes[i] + " ";
		}
		resultado += ")";
		return resultado;
	}

	public boolean equals(Object vector) {
		if (vector == null) {
			return false;
		}
		if (!(vector instanceof VectorMath)) {
			return false;
		}
		VectorMath vectorMath = (VectorMath) vector;
		if (vectorMath.getDimension() != this.getDimension()) {
			return false;
		}
		for (int i = 0; i < this.getDimension(); i++) {
			if (this.getComponentes()[i] != vectorMath.getComponentes()[i]) {
				return false;
			}
		}
		return true;
	}

	public VectorMath clone() {
		VectorMath vector = new VectorMath(this.getDimension());
		vector.setComponentes(this.getComponentes());
		return vector;
	}

	public double normaUno() {
		double resultado = 0;
		for (double f : this.getComponentes()) {
			resultado += Math.abs(f);
		}
		return resultado;
	}

	public double normaDos() {
		double resultado = 0;
		for (double f : this.getComponentes()) {
			resultado += Math.pow(f, 2);
		}
		return (double) Math.sqrt(resultado);
	}

	public double normaInfinito() {
		double maximo = Math.abs(this.getComponentes()[0]);
		for (double f : this.getComponentes()) {
			if (maximo < Math.abs(f))
				maximo = Math.abs(f);
		}
		return maximo;
	}
}
