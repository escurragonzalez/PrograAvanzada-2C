package algoritmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DFS {

	private int cantidadDeNodos;
	private int cantidadDeAristas;
	private boolean[] nodosVisitados;
	private int[] padre;
	private int[] distancia;
	private int[][] matrizDeAdyacencia;
	private Stack<Integer> pila;
	private static int INFINITO = 1000000;

	public DFS(String archivo) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(archivo));
		this.cantidadDeNodos = scanner.nextInt();
		this.cantidadDeAristas = scanner.nextInt();
		this.pila = new Stack<Integer>();
		inicializarMatriz();
		inicializarVectores();
		for (int i = 0; i < this.cantidadDeAristas; i++) {
			this.matrizDeAdyacencia[scanner.nextInt() - 1][scanner.nextInt() - 1] = 1;
		}
		scanner.close();
	}

	public void resolver(int nodoInicial) {
		this.nodosVisitados[nodoInicial] = true;
		this.distancia[nodoInicial] = 0;
		this.pila.push(nodoInicial);
		int nodoU;
		while (!pila.isEmpty()) {
			nodoU = pila.remove(0);
			for (int i = 0; i < this.cantidadDeNodos; i++) {
				if (this.matrizDeAdyacencia[nodoU][i] == 1 && !this.nodosVisitados[i]) {
					this.nodosVisitados[i] = true;
					this.padre[i] = nodoU + 1;
					this.distancia[i] = this.distancia[nodoU] + 1;
					this.pila.push(i);
				}
			}
		}
	}

	private void inicializarMatriz() {
		this.matrizDeAdyacencia = new int[this.cantidadDeNodos][this.cantidadDeNodos];
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			for (int j = 0; j < this.cantidadDeNodos; j++) {
				this.matrizDeAdyacencia[i][j] = INFINITO;
			}
		}
	}

	private void inicializarVectores() {
		this.padre = new int[this.cantidadDeNodos];
		this.distancia = new int[this.cantidadDeNodos];
		this.nodosVisitados = new boolean[this.cantidadDeNodos];
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			this.nodosVisitados[i] = false;
			this.distancia[i] = INFINITO;
		}
	}

	public boolean[] getNodosVisitados() {
		return nodosVisitados;
	}

	public void setNodosVisitados(boolean[] nodosVisitados) {
		this.nodosVisitados = nodosVisitados;
	}

	public int[] getPadre() {
		return padre;
	}

	public void setPadre(int[] padre) {
		this.padre = padre;
	}

	public int[] getDistancia() {
		return distancia;
	}

	public void setDistancia(int[] distancia) {
		this.distancia = distancia;
	}

	public boolean verificarVisitasANodo() {
		for (int i = 0; i < this.cantidadDeNodos; i++)
			if (!this.nodosVisitados[i])
				return false;
		return true;
	}

	public int obtenerNodoNoVisitado() {
		for (int i = 0; i < this.cantidadDeNodos; i++)
			if (!this.nodosVisitados[i])
				return i;
		return -1;
	}

	public static void main(String[] args) throws FileNotFoundException {
		DFS dfs = new DFS("DFS.in");
		dfs.resolver(0);
		int veces = 1;
		while (!dfs.verificarVisitasANodo()) {
			dfs.resolver(dfs.obtenerNodoNoVisitado());
			veces++;
		}
		System.out.println(Arrays.toString(dfs.getDistancia()));
		System.out.println(Arrays.toString(dfs.getNodosVisitados()));
		System.out.println(Arrays.toString(dfs.getPadre()));
		System.out.println(veces);
	}

}
