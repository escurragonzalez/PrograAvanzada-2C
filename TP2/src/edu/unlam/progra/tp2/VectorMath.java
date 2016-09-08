package edu.unlam.progra.tp2;

import java.io.*;
import java.util.*;

public class VectorMath {

	private int dimension;
	private double[] componentes;

	public VectorMath(int dimension) {
		setDimension(dimension);
		this.componentes = new double[dimension];
	}
	
	public VectorMath() {
		setDimension(1);
		this.componentes = new double[1];
	}

	public VectorMath productoVectorial(VectorMath v){

		if(this.dimension!=3 || v.dimension!=3)
			throw new DistDimException(" Distintas Dimensiones! ");

		VectorMath res = new VectorMath(3);
		double a=0;

		a=(this.componentes[1]*v.componentes[2])-(this.componentes[2]*v.componentes[1]);
		res.componentes[0]=a;

		a=(this.componentes[2]*v.componentes[0])-(this.componentes[0]*v.componentes[2]);
		res.componentes[1]=a;
		a=(this.componentes[0]*v.componentes[1])-(this.componentes[1]*v.componentes[0]);
		res.componentes[2]=a;
		return res;	
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
		if (this.getDimension() != vector.getDimension())
			throw new DistDimException("Distinta Dimension");
		VectorMath resultado = new VectorMath(getDimension());
		for (int i = 0; i < this.getDimension(); i++)
			resultado.componentes[i] = this.componentes[i] + vector.componentes[i];
		return resultado;
	}

	public VectorMath restar(VectorMath vector) {
		if (this.getDimension() != vector.getDimension())
			throw new DistDimException("Distinta Dimension");
		VectorMath resultado = new VectorMath(getDimension());
		for (int i = 0; i < this.getDimension(); i++)
			resultado.componentes[i] = this.componentes[i] - vector.componentes[i];
		return resultado;
	}

	public double producto(VectorMath vector) {
		if (this.getDimension() != vector.getDimension())
			throw new DistDimException("Distinta Dimension");
		double resultado = 0;
		for (int i = 0; i < this.getDimension(); i++)
			resultado += this.componentes[i] * vector.componentes[i];
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
		return Math.sqrt(resultado);
	}

	public double normaInfinito() {
		double maximo = Math.abs(this.getComponentes()[0]);
		for (double f : this.getComponentes()) {
			if (maximo < Math.abs(f))
				maximo = Math.abs(f);
		}
		return maximo;
	}

	public VectorMath multiplicarPorMatriz(MatrizMath m){
		if(dimension != m.getFila() && dimension != m.getColumna())
			throw new DistDimException(" Distintas Dimensiones! ");
		VectorMath res = new VectorMath(this.dimension);
		double acum;
		int a;
		double[][] aux = m.getMatriz();
		for(int i=0; i<m.getFila();i++){
			a=0;
			acum=0;
			for(int j=0; j<m.getColumna(); j++){
				acum+=(this.componentes[a]*aux[j][i]);
				a++;
			}
			res.componentes[i]=acum;
		}
		return res;
	}

}
