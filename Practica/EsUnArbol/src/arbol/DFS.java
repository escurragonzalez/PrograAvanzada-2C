package arbol;

import java.util.Stack;

public class DFS {

	private static int NO_ARISTA = 9999;
	private int dim;
	private int[][] matAdy;
	private int[] estados;

	public DFS(int nodos) {
		dim = nodos;
		estados = new int[dim];
		matAdy = new int[dim][dim];
		inicializarMatriz(matAdy);
	}

	public void inicializarMatriz(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				m[i][j] = NO_ARISTA;
			}
		}
	}

	public int[] busquedaProfundidad(int[][] mat, int nodoQueMeInteresa) {
		Stack<Integer> pila = new Stack<Integer>();
		int v = 0, orden = 1;
		estados[nodoQueMeInteresa] = orden; // cambio el estado
		pila.push(nodoQueMeInteresa); // apilo
		while (!pila.empty()) {
			// desapilo
			v = pila.pop();
			if (estados[v] == 0) {
				orden++;
				estados[v] = 1;
			}
			for (int i = 0; i < mat.length; i++) {
				if (mat[v][i] != NO_ARISTA) {
					if (estados[i] == 0){
						pila.push(i); // si es un adyacente, apilo
					}
				}
			}
		}
		return estados;
	}

	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}

	public int[][] getMatAdy() {
		return matAdy;
	}

	public void setMatAdy(int[][] matAdy) {
		this.matAdy = matAdy;
	}

	public int[] getEstados() {
		return estados;
	}

	public void setEstados(int[] estados) {
		this.estados = estados;
	}	
}
