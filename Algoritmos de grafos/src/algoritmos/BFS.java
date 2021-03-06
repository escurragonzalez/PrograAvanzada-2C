package algoritmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	private int[] estado;
	private int[] distancia;
	private int[] padre;
	private Queue<Integer> cola;
	private int[][] matrizDeAdyacencia;
	private int cantidadDeNodos;
	private int cantidadDeAristas;

	public BFS(String archivoGrafo) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(archivoGrafo));
		this.cantidadDeNodos = scanner.nextInt();
		this.cantidadDeAristas = scanner.nextInt();
		this.estado = new int[this.cantidadDeNodos];
		this.distancia = new int[this.cantidadDeNodos];
		this.padre = new int[this.cantidadDeNodos];
		this.cola = new LinkedList<>();

		inicializarMatriz();
		for (int i = 0; i < cantidadDeAristas; i++) {
			this.matrizDeAdyacencia[(scanner.nextInt()) - 1][(scanner.nextInt()) - 1] = 1;
		}
		inicializarVectores();

		scanner.close();
	}

	public void resolver(int nodoInicial) {
		this.estado[nodoInicial] = 1;
		this.distancia[nodoInicial] = 0;
		this.padre[nodoInicial] = Integer.MIN_VALUE;
		this.cola.offer(nodoInicial);
		int nodoU;
		while (!cola.isEmpty()) {
			nodoU = cola.poll();
			for (int j = 0; j < this.cantidadDeNodos; j++) {
				if (this.matrizDeAdyacencia[nodoU][j] == 1 && this.estado[j] == 0) {
					this.estado[j] = 1;
					this.distancia[j] = this.distancia[nodoU] + 1;
					this.padre[j] = nodoU;
					this.cola.offer(j);
				}
			}
		}
	}

	private void inicializarMatriz() {
		this.matrizDeAdyacencia = new int[this.cantidadDeNodos][this.cantidadDeNodos];
		for (int i = 0; i < this.cantidadDeNodos; i++)
			for (int j = 0; j < this.cantidadDeNodos; j++)
				this.matrizDeAdyacencia[i][j] = 0;
	}

	private void inicializarVectores() {
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			this.padre[i] = -1;
			this.estado[i] = 0;
			this.distancia[i] = Integer.MAX_VALUE;
		}
	}

	public int getCantidadDeNodos() {
		return this.cantidadDeNodos;
	}

	public int[] getEstado() {
		return this.estado;
	}

	public int[] getDistancia() {
		return this.distancia;
	}

	public int[] getPadre() {
		return this.padre;
	}

	public static void main(String[] args) throws FileNotFoundException {
		BFS bfs = new BFS("bfs.in");
		bfs.resolver(0);
		int nodo;
		for (int i = 0; i < bfs.getCantidadDeNodos(); i++) {
			nodo = i + 1;
			System.out.println("Estados del nodo: " + nodo + ": " + bfs.getEstado()[i]);
			System.out.println("Distancia al nodo: " + nodo + ": " + bfs.getDistancia()[i]);
			System.out.println("Padre del nodo: " + nodo + ": " + bfs.getPadre()[i]);
		}
	}

}
