package algoritmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Warshall {

	private int cantidadDeNodos;
	private int cantidadDeAristas;
	private int[][] matrizDeAdyacencia;
	private int[][] matrizResultado;

	public Warshall(String archivo) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(archivo));
		this.cantidadDeNodos = scanner.nextInt();
		this.cantidadDeAristas = scanner.nextInt();
		inicializarMatrices();
		for (int i = 0; i < this.cantidadDeAristas; i++) {
			this.matrizDeAdyacencia[scanner.nextInt() - 1][scanner.nextInt() - 1] = 1;
			scanner.nextInt(); // Lectura adicional para eliminar el peso de la
								// arista
		}
		scanner.close();
	}

	public void resolver() {
		clonarMatrices();
		for (int k = 0; k < this.cantidadDeNodos; k++) {
			for (int i = 0; i < this.cantidadDeNodos; i++) {
				for (int j = 0; j < this.cantidadDeNodos; j++) {
					if (i != j && i != k && j != k)
						if (this.matrizResultado[i][j] == 1
								|| (this.matrizResultado[i][k] == 1 && this.matrizResultado[k][j] == 1))
							this.matrizResultado[i][j] = 1;
				}
			}
		}
	}

	private void clonarMatrices() {
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			for (int j = 0; j < this.cantidadDeNodos; j++) {
				this.matrizResultado[i][j] = this.matrizDeAdyacencia[i][j];
			}
		}
	}

	private void inicializarMatrices() {
		this.matrizDeAdyacencia = new int[this.cantidadDeNodos][this.cantidadDeNodos];
		this.matrizResultado = new int[this.cantidadDeNodos][this.cantidadDeNodos];
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			for (int j = 0; j < this.cantidadDeNodos; j++) {
				this.matrizDeAdyacencia[i][j] = 0; // Es tomado como el infinito
			}
		}
	}

	public int[][] getMatrizDeAdyacencia() {
		return matrizDeAdyacencia;
	}

	public void setMatrizDeAdyacencia(int[][] matrizDeAdyacencia) {
		this.matrizDeAdyacencia = matrizDeAdyacencia;
	}

	public int[][] getMatrizResultado() {
		return matrizResultado;
	}

	public void setMatrizResultado(int[][] matrizResultado) {
		this.matrizResultado = matrizResultado;
	}

	public int getCantidadDeNodos() {
		return this.cantidadDeNodos;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Warshall warshall = new Warshall("Warshall.in");
		warshall.resolver();
		for (int i = 0; i < warshall.getCantidadDeNodos(); i++)
			System.out.println(Arrays.toString(warshall.getMatrizResultado()[i]));
	}

}
