package tp4;

public class MatrizSimetrica {

	private int n;// Orden de la matriz
	private int tam;// Tamaño del vector
	private boolean matrizDeAdyacencia[];

	public MatrizSimetrica(int n) {
		this.n = n;
		this.tam = (int) ((Math.pow(n, 2) - n) / 2);// tamaño del vector
		this.matrizDeAdyacencia = new boolean[this.tam];
	}

	public boolean getValor() {
		return false;
	}

	public void setValor(int fila, int columna, boolean valor) {
		int i = getPos(fila, columna);
		matrizDeAdyacencia[i] = valor;
	}

	public boolean getValor(int fila, int columna) {
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
		i = fila * this.n + columna - (int) ((Math.pow(fila, 2) + 3 * fila + 2)) / 2;
		return i;
	}
}
