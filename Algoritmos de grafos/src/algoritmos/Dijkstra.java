package algoritmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {

	private int[] costos;
	private int cantidadDeNodos;
	private int cantidadDeAristas;
	private int[] predecesores;
	private int[][] matrizDeAdyacencia;
	private boolean[] nodosVisitados;
	private static int INFINITO = 100000;

	public Dijkstra(String archivo) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(archivo));
		this.cantidadDeNodos = scanner.nextInt();
		this.cantidadDeAristas = scanner.nextInt();
		this.predecesores = new int[this.cantidadDeNodos];
		this.costos = new int[this.cantidadDeNodos];
		this.nodosVisitados = new boolean[this.cantidadDeNodos];
		this.matrizDeAdyacencia = new int[this.cantidadDeNodos][this.cantidadDeNodos];
		inicializarMatriz();
		for (int i = 0; i < this.cantidadDeAristas; i++) {
			this.matrizDeAdyacencia[scanner.nextInt()][scanner.nextInt()] = scanner.nextInt();
		}
		inicializarVectores();
		scanner.close();
	}

	public void resolver(int nodoInicial) {
		int w = 0;
		int menorCosto;
		this.nodosVisitados[nodoInicial] = true;
		this.predecesores[nodoInicial] = nodoInicial;
		this.costos = this.matrizDeAdyacencia[nodoInicial];
		boolean seguir = true;
		while (seguir) {
			seguir = false;
			menorCosto = INFINITO; 
			for (int i = 0; i < this.nodosVisitados.length; i++) {
				if (!this.nodosVisitados[i] && this.costos[i] < menorCosto) {
					w = i;
					menorCosto = this.costos[i];
					seguir = true;
				}
			}
			this.nodosVisitados[w] = true;
			for (int i = 0; i < this.cantidadDeNodos; i++) {
				if (!this.nodosVisitados[i] && this.matrizDeAdyacencia[w][i] != INFINITO) {
					menorCosto = Math.abs(Math.min(this.costos[i], this.costos[w] + this.matrizDeAdyacencia[w][i]));
					if (menorCosto < this.costos[i]) {
						this.costos[i] = menorCosto;
						this.predecesores[i] = w;
					}
				}
			}
		}

	}

	public boolean todosLosNodosVisitados() {
		for (int i = 0; i < this.nodosVisitados.length; i++) {
			if (!this.nodosVisitados[i])
				return false;
		}
		return true;
	}

	private void inicializarMatriz() {
		this.matrizDeAdyacencia = new int[this.cantidadDeNodos][this.cantidadDeNodos];
		for (int i = 0; i < this.cantidadDeNodos; i++)
			for (int j = 0; j < this.cantidadDeNodos; j++)
				this.matrizDeAdyacencia[i][j] = INFINITO;
	}

	private void inicializarVectores() {
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			this.costos[i] = INFINITO;
			this.predecesores[i] = 0;
			this.nodosVisitados[i] = false;
		}
	}

	public int[] getCostos() {
		return costos;
	}

	public void setCostos(int[] costos) {
		this.costos = costos;
	}

	public int[] getPredecesores() {
		return predecesores;
	}

	public void setPredecesores(int[] predecesores) {
		this.predecesores = predecesores;
	}

	public boolean[] getNodosVisitados() {
		return nodosVisitados;
	}

	public void setNodosVisitados(boolean[] nodosVisitados) {
		this.nodosVisitados = nodosVisitados;
	}

	public static void main(String[] args) throws FileNotFoundException {

		Dijkstra dijkstra = new Dijkstra("Dijkstra.in");
		dijkstra.resolver(0);
		System.out.println(Arrays.toString(dijkstra.getCostos()));
		System.out.println(Arrays.toString(dijkstra.getNodosVisitados()));
		System.out.println(Arrays.toString(dijkstra.getPredecesores()));

	}
}