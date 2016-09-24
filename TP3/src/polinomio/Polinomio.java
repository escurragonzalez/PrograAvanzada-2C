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

	// Tratar de usar el grado auxiliar. Al método solo tiene que llegarle el
	// valor a evaluar.
	public double evaluarRecursivaSinConsiderar(double x, int grado) {
		double resultado;

		if (grado == 0)
			return this.coeficientes[grado] * this.potencia(x, this.grado);

		resultado = evaluarRecursivaSinConsiderar(x, grado - 1);
		resultado += this.coeficientes[grado] * this.potencia(x, this.grado - grado);
		return resultado;
	}

	// Hecha en clase
	public double evaluarRecursivaSinConsiderar(double x) {

		int gradoAuxiliar = this.getGrado();
		double result = this.coeficientes[this.coeficientes.length - 1];
		for (int idx = 0; idx < this.getGrado(); idx++) {
			result += this.coeficientes[idx] * this.potencia(x, gradoAuxiliar);
			gradoAuxiliar--;
		}

		return result;
	}

	// Hecha en clase
	public double evaluarRecursivaConsiderando(double x) {
		int gradoAuxiliar = this.getGrado();
		double result = this.coeficientes[this.coeficientes.length - 1];
		for (int idx = 0; idx < this.getGrado(); idx++) {

			// result += this.coeficientes[idx] * this.potencia(x,
			// gradoAuxiliar);
			if (gradoAuxiliar % 2 == 0)
				result += this.coeficientes[idx] * this.potencia(x * x, gradoAuxiliar / 2);
			else
				result += this.coeficientes[idx] * this.potencia(x, gradoAuxiliar - 1);

			gradoAuxiliar--;
		}

		return result;
	}

	// Tratar de usar el grado auxiliar. Al método solo tiene que llegarle el
	// valor a evaluar.
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

	public double evaluarHorner(double x) {
		double resultado = this.coeficientes[0];

		for (int i = 1; i <= this.grado; i++)
			resultado = this.coeficientes[i] + (x * resultado);
		return resultado;
	}

}