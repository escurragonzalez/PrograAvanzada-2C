package batiendoAlMinotauro;

public class MatrizSimetrica {

	private int cantNodos;// Orden de la matriz
	private int tam;// Tamaño del vector
	private int matrizDeAdyacencia[];

	public MatrizSimetrica(int n) {
		this.cantNodos = n;
		this.tam = (int) ((Math.pow(n, 2) - n) / 2);// tamaño del vector
		this.matrizDeAdyacencia = new int[this.tam];
	}

	public void mostrarMatriz() {
		int aux;
		System.out.println("[ ");
		for (int i = 0; i < matrizDeAdyacencia.length; i++) {
			for (int j = 0; j < matrizDeAdyacencia.length; j++) {
				if (i > j) {
					aux = i;
					i = j;
					j = aux;
				}
				i = i * this.cantNodos + j - (int) ((Math.pow(i, 2) + 3 * i + 2)) / 2;
				System.out.println(matrizDeAdyacencia[i]);
			}
			System.out.println();
		}
		System.out.println(" ]");
	}

	public void completarMatriz() {
		for (int i = 0; i < matrizDeAdyacencia.length; i++)
			if (matrizDeAdyacencia[i] == 0)
				matrizDeAdyacencia[i] = (int) Double.POSITIVE_INFINITY;
	}

	public void setValor(int fila, int columna, int valor) {
		int i = getPos(fila, columna);
		matrizDeAdyacencia[i] = valor;
	}

	public int getValor(int fila, int columna) {
		int i = getPos(fila, columna);
		return matrizDeAdyacencia[i];
	}

	private int getPos(int fila, int columna) {
		int aux, i;
		if (fila > columna) {
			aux = fila;
			fila = columna;
			columna = aux;
		}
		i = fila * this.cantNodos + columna - (int) ((Math.pow(fila, 2) + 3 * fila + 2)) / 2;
		return i;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public int[] getMatrizDeAdyacencia() {
		return matrizDeAdyacencia;
	}

	public void setMatrizDeAdyacencia(int[] matrizDeAdyacencia) {
		this.matrizDeAdyacencia = matrizDeAdyacencia;
	}
}
