package polinomio;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Polinomio {

	private int grado;
	private double[] coeficientes;

	public Polinomio(int grado, double[] coeficientes) {
		this.grado = grado;
		this.coeficientes = new double[grado + 1];
		for (int i = 0; i < this.grado + 1; i++) {
			this.coeficientes[i] = coeficientes[i];
		}
	}

	public Polinomio(String archivo) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(archivo));

		this.setGrado(sc.nextInt());
		double[] Coeficientes = new double[this.grado + 1];

		for (int i = 0; i < this.grado + 1; i++)
			Coeficientes[i] = sc.nextDouble();

		this.setCoeficientes(Coeficientes);
		sc.close();
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public double[] getCoeficientes() {
		return coeficientes;
	}

	public void setCoeficientes(double[] coeficientes) {
		this.coeficientes = coeficientes;
	}

	public String toString() {
		String resultado = "";
		resultado += this.grado + "\n";

		for (int i = 0; i <= this.grado; i++)
			resultado += this.coeficientes[i] + "\n";
		return resultado;
	}

	public double evaluarMSucesivas(double x) {
		double resultado = this.coeficientes[this.grado];
		double aux;
		for (int i = 0; i < this.grado; i++) {
			aux = 1;
			for (int j = 0; j < this.grado - i; j++)
				aux *= x;

			resultado += this.coeficientes[i] * aux;
		}
		return resultado;
	}

	public double potencia(double x, int grado) {
		if (grado == 0)
			return 1;
		if (grado == 1)
			return x;

		return x * this.potencia(x, grado - 1);
	}

	public double potenciaPar(double x, int grado) {
		if (grado == 0)
			return 1;
		if (grado == 1)
			return x;

		return x * this.potencia(x * x, grado / 2);
	}

	public double evaluarRecursivaSinConsiderar(double x, int grado) {
		double resultado;

		if (grado == 0)
			return this.coeficientes[grado] * this.potencia(x, this.grado);

		resultado = evaluarRecursivaSinConsiderar(x, grado - 1);
		resultado += this.coeficientes[grado] * this.potencia(x, this.grado - grado);
		return resultado;
	}

	public double evaluarRecursivaPar(double x, int grado) {
		double resultado;

		if (grado % 2 == 0) {
			if (grado == 0)
				return this.coeficientes[grado] * this.potenciaPar(x, this.grado);

			resultado = evaluarRecursivaPar(x, grado - 1);
			resultado += this.coeficientes[grado] * this.potenciaPar(x, this.grado - grado);
		} else {
			if (grado == 0)
				return this.coeficientes[grado] * this.potencia(x, this.grado);

			resultado = evaluarRecursivaSinConsiderar(x, grado - 1);
			resultado += this.coeficientes[grado] * this.potencia(x, this.grado - grado);
		}
		return resultado;
	}

	public double evaluarProgDinamica1(double x) {

		double resultado = this.coeficientes[this.grado];
		double[] vec = new double[this.grado];

		for (int i = 0; i < this.grado; i++)
			vec[i] = Math.pow(x, this.grado - i);

		for (int i = 0; i < this.grado; i++)
			resultado += this.coeficientes[i] * vec[i];

		return resultado;
	}

	/*
	 * public double evaluarProgDinamica1(double x) { double xm = 1; double
	 * result = this.coeficientes[0];
	 * 
	 * for (int i = 1; i < this.coeficientes.length; i++) { xm *= x; result +=
	 * this.coeficientes[i] * xm; } return result; }
	 */ // el de la profe

	public double evaluarProgDinamica(double x) {
		double xm = 1;
		double result = this.coeficientes[this.grado];

		for (int i = this.coeficientes.length - 2; i >= 0; i--) {
			xm *= x;
			result += this.coeficientes[i] * xm;
		}
		return result;
	}

	/*
	 * public double evaluarProgDinamica2(double x) { double result = 0;
	 * 
	 * for (int i = this.coeficientes.length - 1; i >= 0; i--) { result = result
	 * * x + this.coeficientes[i]; } return result; }
	 */ // el de la profe

	public double evaluarProgDinamicaMejorada(double x) {
		double result = 0;

		for (int i = 0; i < this.coeficientes.length; i++) {
			result = result * x + this.coeficientes[i];
		}
		return result;
	}

	public double evaluarPow(double x) {
		double resultado = this.coeficientes[this.grado];

		for (int i = 0; i < this.grado; i++)
			resultado += this.coeficientes[i] * Math.pow(x, this.grado - i);

		return resultado;
	}

	public double evaluarHorner(double x, int grado) {
		double resultado = this.coeficientes[0];

		for (int i = 1; i <= this.grado; i++)
			resultado = this.coeficientes[i] + (x * resultado);
		return resultado;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Locale.setDefault(new Locale("en", "us"));
		double valorEvaluador = 8;

		Polinomio p = new Polinomio("Polinomio_in.txt");
		System.out.println(p.toString());
		System.out.println("evaluado en 5: " + p.evaluarMSucesivas(valorEvaluador));
		// System.out.println(p.potencia(4, 4));
		System.out.println("evaluado en " + valorEvaluador + " recursiva: "
				+ p.evaluarRecursivaSinConsiderar(valorEvaluador, p.getGrado()));
		System.out.println(
				"evaluado en " + valorEvaluador + " par: " + p.evaluarRecursivaPar(valorEvaluador, p.getGrado()));
		System.out.println("evaluado en " + valorEvaluador + " dinamica: " + p.evaluarProgDinamica(valorEvaluador));
		System.out.println("evaluado en " + valorEvaluador + " pow : " + p.evaluarPow(valorEvaluador));
		System.out
				.println("evaluado en " + valorEvaluador + " Horner: " + p.evaluarHorner(valorEvaluador, p.getGrado()));
		System.out.println("evaluado en " + valorEvaluador + " dinamica 1: " + p.evaluarProgDinamica1(valorEvaluador));
		System.out.println(
				"evaluado en " + valorEvaluador + " dinamica 2: " + p.evaluarProgDinamicaMejorada(valorEvaluador));

	}
}