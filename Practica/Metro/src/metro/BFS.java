package metro;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	private int[] estado;
	private Queue<Integer> cola;
	private int[][] matrizDeAdyacencia;
	private int cantidadDeNodos;
	private int cantidadDeAristas;

	public BFS(int nodos, int aristas) {
		this.cantidadDeNodos = nodos;
		this.cantidadDeAristas = aristas;
		this.estado = new int[this.cantidadDeNodos];
		this.cola = new LinkedList<>();
		this.matrizDeAdyacencia = new int [nodos][nodos];
	}

	public void algoritmoBFS(int nodoInicial) {
		this.estado[nodoInicial] = 1;
		this.cola.offer(nodoInicial);
		int nodoU;
		while (!cola.isEmpty()) {
			nodoU = cola.poll();
			for (int j = 0; j < this.cantidadDeNodos; j++) {
				if (this.getMatrizDeAdyacencia()[nodoU][j] == 1 && this.estado[j] == 0) {
					this.estado[j] = 1;
					this.cola.offer(j);
				}
			}
		}
	}

	public int getCantidadDeNodos() {
		return this.cantidadDeNodos;
	}

	public int[] getEstado() {
		return this.estado;
	}

	public int[][] getMatrizDeAdyacencia() {
		return matrizDeAdyacencia;
	}

	public void setMatrizDeAdyacencia(int[][] matrizDeAdyacencia) {
		this.matrizDeAdyacencia = matrizDeAdyacencia;
	}
}
