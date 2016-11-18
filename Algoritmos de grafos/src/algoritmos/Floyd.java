package algoritmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Floyd {

	private int cantidadDeNodos;
	private int cantidadDeAristas;
	private int matrizDeCostosMinimos[][];
	private int matrizDeAdyacencia[][];
	private static int INFINITO = 1000000;

	public Floyd(String archivo) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(archivo));
		this.cantidadDeNodos = scanner.nextInt();
		this.cantidadDeAristas = scanner.nextInt();
		inicializarMatriz();
		for (int i = 0; i < this.cantidadDeAristas; i++) {
			this.matrizDeAdyacencia[scanner.nextInt() - 1][scanner.nextInt() - 1] = scanner.nextInt();
		}
		scanner.close();
	}

	public void resolver() {
		clonarMatrices();
		for (int k = 0; k < this.cantidadDeNodos; k++) {
			for (int i = 0; i < this.cantidadDeNodos; i++) {
				if (i == k)
					this.matrizDeCostosMinimos[i][i] = 0;
				for (int j = 0; j < this.cantidadDeNodos; j++) {
					if (i != j && i != k && k != j)
						this.matrizDeCostosMinimos[i][j] = Math.min(this.matrizDeCostosMinimos[i][j],
								this.matrizDeCostosMinimos[i][k] + this.matrizDeCostosMinimos[k][j]);
				}
			}
		}
	}

	/**
	 * Clono la matriz de adyacencia en la matriz resultado para su uso en el
	 * algoritmo
	 */
	private void clonarMatrices() {
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			for (int j = 0; j < this.cantidadDeNodos; j++) {
				this.matrizDeCostosMinimos[i][j] = this.matrizDeAdyacencia[i][j];
			}
		}
	}

	/**
	 * Inicializo las matrices
	 */
	private void inicializarMatriz() {
		this.matrizDeAdyacencia = new int[this.cantidadDeNodos][this.cantidadDeNodos];
		this.matrizDeCostosMinimos = new int[this.cantidadDeNodos][this.cantidadDeNodos];
		for (int i = 0; i < this.cantidadDeNodos; i++)
			for (int j = 0; j < this.cantidadDeNodos; j++)
				this.matrizDeAdyacencia[i][j] = INFINITO;
	}

	public int[][] getMatrizDeCostosMinimos() {
		return matrizDeCostosMinimos;
	}

	public void setMatrizDeCostosMinimos(int[][] matrizDeCostosMinimos) {
		this.matrizDeCostosMinimos = matrizDeCostosMinimos;
	}

	public int[][] getMatrizDeAdyacencia() {
		return matrizDeAdyacencia;
	}

	public void setMatrizDeAdyacencia(int[][] matrizDeAdyacencia) {
		this.matrizDeAdyacencia = matrizDeAdyacencia;
	}

	public int getCantidadDeNodos() {
		return cantidadDeNodos;
	}

	public void setCantidadDeNodos(int cantidadDeNodos) {
		this.cantidadDeNodos = cantidadDeNodos;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Floyd floyd = new Floyd("Floyd.in");
		floyd.resolver();
		for (int i = 0; i < floyd.getCantidadDeNodos(); i++)
			System.out.println(Arrays.toString(floyd.getMatrizDeCostosMinimos()[i]));

	}

}
