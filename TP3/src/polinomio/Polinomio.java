package polinomio;

public class Polinomio {

	private int grado;
	private double[] coeficientes;

	public Polinomio(int grado, double[] coeficientes) {
		this.setGrado(grado);
		this.coeficientes = new double[++grado];
		for (int idx = 0; idx < this.coeficientes.length; idx++) {
			this.coeficientes[idx] = coeficientes[idx];
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

	/*
	 * Complejidad Computacional: O(n^2)
	 */
	public double evualarMSucesivas(double x) {
		int gradoAuxiliar = this.getGrado();
		double valor;
		double result = this.coeficientes[this.coeficientes.length - 1];
		for (int idx = 0; idx < this.getGrado(); idx++) {
			valor = 1;
			for (int jdx = gradoAuxiliar; jdx > 0; jdx--) {
				valor *= x;
			}
			gradoAuxiliar--;
			result += valor * this.coeficientes[idx];
		}

		return result;

	}

	//
	public double evualarRecursivaSinConsiderar(double x) {

		int gradoAuxiliar = this.getGrado();
		double result = this.coeficientes[this.coeficientes.length - 1];
		for (int idx = 0; idx < this.getGrado(); idx++) {
			result += this.coeficientes[idx] * this.potencia(x, gradoAuxiliar);
			gradoAuxiliar--;
		}

		return result;
	}

	public double evualarRecursivaConsiderando(double x) {

		int gradoAuxiliar = this.getGrado();
		double result = this.coeficientes[this.coeficientes.length - 1];
		for (int idx = 0; idx < this.getGrado(); idx++) {

			// result += this.coeficientes[idx] * this.potencia(x,
			// gradoAuxiliar);
			if (gradoAuxiliar % 2 == 0)
				result += this.coeficientes[idx] * this.potencia(x*x,gradoAuxiliar/2);

			else
				result += this.coeficientes[idx] * this.potencia(x, gradoAuxiliar-1);
			gradoAuxiliar--;
		}

		return result;
	}

	public double potencia(double valor, int grado) {
		if (grado == 1)
			return valor;

		return valor * potencia(valor, grado - 1);
	}

	public double potenciaPar(double valor, int grado) {
		if (grado == 1)
			return valor;

		return potenciaPar(valor * valor, grado / 2);
	}

}
//
// double evualarRecursivaPar(double x) {
//
// }
//
// double evualarProgDinamica(double x) {
//
// }
//
// double evualarMejorada(double x) {
//
// }
//
// double evualarPow(double x) {
//
// }
