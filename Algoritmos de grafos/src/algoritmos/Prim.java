package algoritmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prim {

	private int cantidadDeNodos;
	private int cantidadDeAristas;
	private int[][] matrizDeAdyacencia;
	private int costoMinimo;
	private ArrayList<Integer> conjuntoV;
	private ArrayList<Integer> conjuntoW;
	private ArrayList<Nodo> arbolDeCostoMinimo;
	private static int INFINITO = 100000;

	public Prim(String archivo) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(archivo));
		this.cantidadDeNodos = scanner.nextInt();
		this.cantidadDeAristas = scanner.nextInt();
		this.arbolDeCostoMinimo = new ArrayList<>();
		inicializarMatriz();
		int fila, columna, costo;
		for (int i = 0; i < this.cantidadDeAristas; i++) {
			fila = scanner.nextInt() - 1;
			columna = scanner.nextInt() - 1;
			costo = scanner.nextInt();
			this.matrizDeAdyacencia[fila][columna] = costo;
			this.matrizDeAdyacencia[columna][fila] = costo;
		}
		this.costoMinimo = 0;
		scanner.close();
	}

	private void inicializarMatriz() {
		this.matrizDeAdyacencia = new int[this.cantidadDeNodos][this.cantidadDeNodos];
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			for (int j = 0; j < this.cantidadDeNodos; j++) {
				this.matrizDeAdyacencia[i][j] = INFINITO;
			}
		}
	}

	public ArrayList<Integer> generarConjuntoW(int nodoInicial) {
		ArrayList<Integer> conjunto = new ArrayList<>();
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			if (i != nodoInicial)
				conjunto.add(i);
		}
		return conjunto;
	}

	private int buscarNodoMasCercano(int nodoInicial) {
		int costo;
		int costoMinimo = INFINITO;
		int nodoASacar = -1;
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			if (nodoInicial != i && this.matrizDeAdyacencia[nodoInicial][i] != INFINITO && this.conjuntoW.contains(i)) {
				costo = this.matrizDeAdyacencia[nodoInicial][i];
				if (costoMinimo > costo) {
					costoMinimo = costo;
					nodoASacar = i;
				}
			}
		}
		return nodoASacar;
	}

	public int obtenerPosicionDelNodo(int NodoASacar) {
		for (int i = 0; i < this.conjuntoW.size(); i++) {
			if (this.conjuntoW.get(i) == NodoASacar)
				return i;
		}
		return -1;
	}

	public void resolver(int nodoInicial) {
		this.conjuntoV = new ArrayList<>();
		this.conjuntoW = generarConjuntoW(nodoInicial);
		this.conjuntoV.add(nodoInicial);
		int nodoAUnir = 0;
		int nodoCandidato;
		int costoParcial;
		while (!this.conjuntoW.isEmpty()) {
			// Busco el nodo mas cercano a alguno del conjunto V
			costoParcial = INFINITO;
			for (int i = 0; i < this.conjuntoV.size(); i++) {
				nodoCandidato = buscarNodoMasCercano(this.conjuntoV.get(i));
				if (nodoCandidato != -1
						&& costoParcial > this.matrizDeAdyacencia[this.conjuntoV.get(i)][nodoCandidato]) {
					nodoInicial = this.conjuntoV.get(i);
					nodoAUnir = nodoCandidato;
					costoParcial = this.matrizDeAdyacencia[nodoInicial][nodoAUnir];
				}
			}
			this.costoMinimo += this.matrizDeAdyacencia[nodoInicial][nodoAUnir];
			this.conjuntoV.add(nodoAUnir);
			this.conjuntoW.remove(obtenerPosicionDelNodo(nodoAUnir));
			this.arbolDeCostoMinimo
					.add(new Nodo(nodoInicial + 1, nodoAUnir + 1, this.matrizDeAdyacencia[nodoInicial][nodoAUnir]));
		}
	}

	public int getCantidadDeNodos() {
		return cantidadDeNodos;
	}

	public void setCantidadDeNodos(int cantidadDeNodos) {
		this.cantidadDeNodos = cantidadDeNodos;
	}

	public int getCantidadDeAristas() {
		return cantidadDeAristas;
	}

	public void setCantidadDeAristas(int cantidadDeAristas) {
		this.cantidadDeAristas = cantidadDeAristas;
	}

	public int[][] getMatrizDeAdyacencia() {
		return matrizDeAdyacencia;
	}

	public void setMatrizDeAdyacencia(int[][] matrizDeAdyacencia) {
		this.matrizDeAdyacencia = matrizDeAdyacencia;
	}

	public int getCostoMinimo() {
		return costoMinimo;
	}

	public void setCostoMinimo(int costoMinimo) {
		this.costoMinimo = costoMinimo;
	}

	public ArrayList<Integer> getConjuntoV() {
		return conjuntoV;
	}

	public void setConjuntoV(ArrayList<Integer> conjuntoV) {
		this.conjuntoV = conjuntoV;
	}

	public ArrayList<Integer> getConjuntoW() {
		return conjuntoW;
	}

	public void setConjuntoW(ArrayList<Integer> conjuntoW) {
		this.conjuntoW = conjuntoW;
	}

	public ArrayList<Nodo> getArbolDeCostoMinimo() {
		return this.arbolDeCostoMinimo;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Prim prim = new Prim("Prim.in");
		prim.resolver(0);
		for (Nodo nodo : prim.getArbolDeCostoMinimo()) {
			System.out.println(nodo);
		}
	}

}
