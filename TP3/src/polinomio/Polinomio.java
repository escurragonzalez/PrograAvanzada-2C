package polinomio;

public class Polinomio {

	private int grado;
	private double[] coeficientes;

	public Polinomio(int grado, double[] coeficientes) {
		this.setGrado(grado);
		this.coeficientes = new double[grado + 1];
		for (int i = 0; i < this.grado + 1; i++) {
			this.setValorCoeficientes(coeficientes[i], i);
		}
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

	public void setValorCoeficientes(double valor, int posicion) {
		this.coeficientes[posicion] = valor;
	}

	public String toString() {
		String resultado = "";
		resultado += this.grado + "\n";

		for (int i = 0; i <= this.grado; i++)
			resultado += this.coeficientes[i] + "\n";
		return resultado;
	}

	public double potencia(double x, int grado) {
		if (grado == 0)
			return this.coeficientes[grado];

		return this.coeficientes[grado] + (x * this.potencia(x, grado - 1));
	}

	/**
	 * Complejidad computacional: O(n*m)
	 */
	public double evaluarMSucesivas(double x) {
		double resultado = this.coeficientes[this.grado];
		double valorAuxiliar;
		for (int i = 0; i < this.grado; i++) {
			valorAuxiliar = 1;
			for (int j = 0; j < this.grado - i; j++)
				valorAuxiliar *= x;

			resultado += this.coeficientes[i] * valorAuxiliar;
		}
		return resultado;
	}

	/**
	 * Complejidad Computacional: O(log(n))
	 */
	public double evaluarRecursivaSinConsiderar(double x) {
		return potencia(x, this.grado);
	}

	/**
	 * Complejidad Computacional: O(log(n))
	 */
	public double evaluarRecursivaConsiderar(double x) {
		return potenciaPar(x, this.grado);
	}

	public double potenciaPar(double x, int grado) {
		if (grado == 0)
			return this.coeficientes[grado];
		if (grado % 2 == 0)
			return this.coeficientes[grado] + (this.potenciaPar(x * x, grado / 2));
		return this.coeficientes[grado] + (x * this.potenciaPar(x, grado - 1));
	}

	/**
	 *
	 * Complejidad Computacional: O(n)
	 */
	public double evaluarProgDinamica(double x) {
		double xm = 1;
		double result = this.coeficientes[this.grado];

		for (int i = this.coeficientes.length - 2; i >= 0; i--) {
			xm *= x;
			result += this.coeficientes[i] * xm;
		}
		return result;
	}

	/**
	 * Complejidad Computacional: O(n)
	 */
	public double evaluarProgDinamicaMejorada(double x) {
		double result = 0;

		for (int i = 0; i < this.coeficientes.length; i++) {
			result = result * x + this.coeficientes[i];
		}
		return result;
	}

	/**
	 * Complejidad Computacional: O(n)
	 */
	public double evaluarPow(double x) {
		double resultado = this.coeficientes[this.grado];

		for (int i = 0; i < this.grado; i++)
			resultado += this.coeficientes[i] * Math.pow(x, this.grado - i);

		return resultado;
	}

	/**
	 * Complejidad Computacional: O(n)
	 */
	public double evaluarHorner(double x) {
		double resultado = this.coeficientes[0];

		for (int i = 1; i <= this.grado; i++)
			resultado = this.coeficientes[i] + (x * resultado);
		return resultado;
	}
}