package selMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrizMath {

	private int fila;
	private int columna;
	private double[][] matriz;

	public MatrizMath(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
		this.matriz = new double[fila][columna];

	}

	public MatrizMath(String archivoMatriz) throws FileNotFoundException {

		String miPath = "\\gus\\programas\\workspace\\";
		Scanner sc = new Scanner(new File(miPath + archivoMatriz));

		this.setFila(sc.nextInt());
		this.setcolumna(sc.nextInt());

		this.matriz = new double[this.getFila()][this.getColumna()];

		int cantidadDeValores = this.getFila() * this.getColumna();

		for (int idx = 0; idx < cantidadDeValores; idx++)
			this.setValorDeMatriz(sc.nextInt(), sc.nextInt(), sc.nextDouble());

		sc.close();

	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public double getValorMatrizMath(int fila, int columna) {
		return this.matriz[fila][columna];
	}

	public void setcolumna(int columna) {
		this.columna = columna;
	}

	public void setValorDeMatriz(int fila, int columna, double valor) {
		this.matriz[fila][columna] = valor;
	}

	public void dividirFila(int fila, int pivoteColumna) {
		for (int i = 0; i < this.fila; i++) {

			if (i == fila) {
				double divisor = this.matriz[i][pivoteColumna];
				for (int j = pivoteColumna; j < this.columna; j++) {
					this.matriz[i][j] /= divisor;
				}
			}
		}
	}

	public boolean sinPivote(int pivoteFila, int pivoteColumna) {
		for (int i = pivoteFila; i < this.fila; i++) {
			if (this.matriz[i][pivoteColumna] != 0)
				return false;
		}
		return true;
	}

	public void restarFila(int pivoteFila, int pivoteColumna, int fila) {
		for (int i = 0; i < this.fila; i++) {

			if (i == fila) {

				for (int j = pivoteColumna; j < this.columna; j++) {
					this.matriz[i][j] -= this.matriz[pivoteFila][j];
				}
			}
		}
	}

	public void restarFilaConNumero(int pivote, int fila) {
		for (int i = 0; i < this.fila; i++) {

			if (i == fila) {
				double numero = this.matriz[i][pivote];
				for (int j = pivote; j < this.columna; j++) {

					this.matriz[i][j] -= this.matriz[pivote][j] * numero;
				}
			}
		}
	}

	public double determinante() throws DistintaDimensionException {
		if (this.columna != this.fila)
			throw new DistintaDimensionException(" Matriz no Cuadrada ");

		int pivoteColumna = 0;
		int pivoteFila = 0;

		if (this.sinPivote(pivoteFila, pivoteColumna) == true) // det = 0
			return 0;

		MatrizMath m = this.generarMatriz(); // copio matriz
		double det = 1;

		while (pivoteColumna != m.columna && pivoteFila != m.fila) {

			for (int i = pivoteFila; i < m.fila; i++) {

				if (m.matriz[i][pivoteColumna] != 0) {

					if (m.matriz[i][pivoteColumna] != 1) {

						det *= m.matriz[i][pivoteColumna]; // cada vez q divido
															// una
															// fila por un
						// numero tengo q multiplicar el
						// determinante por ese numero
						m.dividirFila(i, pivoteColumna);
					}
					if (i != pivoteFila) {
						det *= -1; // cada vez q permuto fila la determinante
									// cambia de signo
						double aux[];
						aux = m.matriz[pivoteColumna];
						m.matriz[pivoteColumna] = m.matriz[i];
						m.matriz[i] = aux;
					}
					i = m.fila; // para q salga del for
				}
			}

			if (m.sinPivote(pivoteFila, pivoteColumna) == true)
				return 0;

			for (int i = pivoteFila; i < m.fila; i++) {

				if (m.matriz[i][pivoteColumna] != 0) {

					if (m.matriz[i][pivoteColumna] != 1) {

						det *= m.matriz[i][pivoteColumna]; // cada vez q divido
															// una
															// fila por un
						// numero tengo q multiplicar el
						// determinante por ese numero
						m.dividirFila(i, pivoteColumna);
					}
					if (i != pivoteFila)
						m.restarFila(pivoteFila, pivoteColumna, i);
				}
			}

			pivoteColumna++;
			pivoteFila++;
		}
		return det;
	}

	public MatrizMath inversa() throws DistintaDimensionException {
		if (this.columna != this.fila)
			throw new DistintaDimensionException(" Matriz no Cuadrada ");

		int pivoteColumna = 0;
		int pivoteFila = 0;

		MatrizMath m = this.generarMatrizAmpliada(); // copio matriz

		while (pivoteColumna != m.columna && pivoteFila != m.fila) {

			for (int i = pivoteFila; i < m.fila; i++) {

				if (m.matriz[i][pivoteColumna] != 0) {

					if (m.matriz[i][pivoteColumna] != 1)
						m.dividirFila(i, pivoteColumna);

					if (i != pivoteFila) {
						double aux[];
						aux = m.matriz[pivoteColumna];
						m.matriz[pivoteColumna] = m.matriz[i];
						m.matriz[i] = aux;
					}
					i = m.fila; // para q salga del for
				}
			}

			for (int i = pivoteFila; i < m.fila; i++) {

				if (m.matriz[i][pivoteColumna] != 0) {

					if (m.matriz[i][pivoteColumna] != 1)
						m.dividirFila(i, pivoteColumna);

					if (i != pivoteFila)
						m.restarFila(pivoteFila, pivoteColumna, i);
				}
			}
			pivoteColumna++;
			pivoteFila++;
		}

		int pivote = 1;
		int pivoteaux = 1;

		for (int i = 0; i < m.fila && pivote != m.fila; i++) {
			for (int j = i + 1; j < m.columna / 2; j++) {
				if (m.matriz[i][j] != 0)
					m.restarFilaConNumero(pivote, i);

				pivote++;
			}
			pivoteaux++;
			pivote = pivoteaux;
		}

		MatrizMath mat = new MatrizMath(this.fila, this.columna);
		mat = m.generarMatrizInversa();

		return mat;
	}

	public MatrizMath traspuesta() {

		MatrizMath mat = new MatrizMath(this.columna, this.fila);

		for (int j = 0; j < this.columna; j++) {
			for (int i = 0; i < this.fila; i++) {
				mat.matriz[j][i] = this.matriz[i][j];
			}
		}
		return mat;
	}

	public MatrizMath adjunta() throws DistintaDimensionException {

		MatrizMath m = new MatrizMath(this.fila, this.columna);

		m = this.matrizCofactores();

		return m.traspuesta();
	}

	public MatrizMath matrizCofactores() throws DistintaDimensionException {

		MatrizMath m = new MatrizMath(this.fila, this.columna);

		for (int i = 0; i < this.matriz.length; i++) {
			for (int j = 0; j < this.matriz.length; j++) {

				MatrizMath det = new MatrizMath(this.fila - 1, this.columna - 1);

				double detValor;
				for (int k = 0; k < matriz.length; k++) {
					if (k != i) {
						for (int l = 0; l < matriz.length; l++) {
							if (l != j) {
								int indice1 = k < i ? k : k - 1;
								int indice2 = l < j ? l : l - 1;
								det.matriz[indice1][indice2] = matriz[k][l];
							}
						}
					}
				}
				detValor = det.determinante();
				m.matriz[i][j] = detValor * (double) Math.pow(-1, i + j + 2);
			}
		}
		return m;
	}

	public MatrizMath generarMatriz() {

		MatrizMath m = new MatrizMath(this.fila, this.columna);

		for (int i = 0; i < this.fila; i++) {
			for (int j = 0; j < this.columna; j++)
				m.matriz[i][j] = this.matriz[i][j];
		}

		return m;
	}

	public MatrizMath generarMatrizAmpliada() {
		MatrizMath m = new MatrizMath(this.fila, this.columna * 2);

		for (int i = 0; i < this.fila; i++) {
			for (int j = 0; j < this.columna * 2; j++) {
				if (j < this.columna)
					m.matriz[i][j] = this.matriz[i][j];
				else {
					if (j == this.columna + i)
						m.matriz[i][j] = 1;
					else
						m.matriz[i][j] = 0;
				}
			}
		}

		return m;
	}

	public MatrizMath generarMatrizInversa() {
		MatrizMath m = new MatrizMath(this.fila, this.columna / 2);

		for (int i = 0; i < this.fila; i++) {
			for (int j = this.columna / 2; j < this.columna; j++) {
				m.matriz[i][(j - (this.columna / 2))] = this.matriz[i][j];
			}
		}

		return m;
	}

	public VectorMath multiplicacion(VectorMath vectorMath) throws DistintaDimensionException {
		if (this.getColumna() != vectorMath.getDimension())
			throw new DistintaDimensionException("Las dimensiones son distintas");
		VectorMath vectorAuxiliar = new VectorMath(this.getFila());
		double calculoMultiplicacion;
		for (int idx = 0; idx < this.fila; idx++) {
			calculoMultiplicacion = 0;
			for (int jdx = 0; jdx < this.columna; jdx++) {
				calculoMultiplicacion += this.getValorMatrizMath(idx, jdx) * vectorMath.getValorVectorMath(jdx);
			}
			vectorAuxiliar.setValorVectorMath(idx, calculoMultiplicacion);
		}
		return vectorAuxiliar;

	}

}
