package algoritmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Coloreo {

	private int cantidadDeNodos;
	private int cantidadDeAristas;
	private int[] colores;
	private int[][] matrizDeAdyacencia;
	private int cantidadDeColores;

	public Coloreo(String archivo) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(archivo));
		this.cantidadDeNodos = scanner.nextInt();
		this.cantidadDeAristas = scanner.nextInt();
		inicializarMatriz();
		int fila, columna;
		for (int i = 0; i < this.cantidadDeAristas; i++) {
			fila = scanner.nextInt();
			columna = scanner.nextInt();
			this.matrizDeAdyacencia[fila - 1][columna - 1] = 1;
			this.matrizDeAdyacencia[columna - 1][fila - 1] = 1;
		}
		this.colores = new int[this.cantidadDeNodos];
		scanner.close();

	}

	private boolean sePuedeColorear(int nodo, int color) {

		if (this.colores[nodo] != 0) // Si ya tiene color...
			return false;
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			if (nodo != i && esAdyacente(nodo, i) && this.colores[i] == color)
				return false;
		}
		return true;
	}

	public boolean esAdyacente(int nodoInicial, int nodoFinal) {
		return this.matrizDeAdyacencia[nodoInicial][nodoFinal] == 1
				|| this.matrizDeAdyacencia[nodoFinal][nodoInicial] == 1;
	}

	private int obtenerCantidadDeColores() {
		int colorMaximo = this.colores[0];
		for (int i = 1; i < this.colores.length; i++) {
			colorMaximo = Math.max(this.colores[i], colorMaximo);
		}
		return colorMaximo;
	}

	public void resolver() {
		// int[] secuencial= new int[5];
//		secuencial[0] = 4;
//		secuencial[1] = 3;
//		secuencial[2] = 1;
//		secuencial[3] = 0;
//		secuencial[4] = 2;
		int color = 1;
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			for (int j = i; j < this.cantidadDeNodos; j++) {
				if (sePuedeColorear(j, color)) {
					this.colores[j] = color;
				}
			}
			color++;
		}
		this.cantidadDeColores = obtenerCantidadDeColores();
	}

	private void inicializarMatriz() {
		this.matrizDeAdyacencia = new int[this.cantidadDeNodos][this.cantidadDeNodos];
		for (int i = 0; i < this.cantidadDeNodos; i++) {
			for (int j = 0; j < this.cantidadDeNodos; j++) {
				this.matrizDeAdyacencia[i][j] = 0;
			}
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

	public int[] getColores() {
		return colores;
	}

	public void setColores(int[] colores) {
		this.colores = colores;
	}

	public int getCantidadDeColores() {
		return this.cantidadDeColores;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Coloreo coloreo = new Coloreo("Coloreo.in");
		coloreo.resolver();
		System.out.println(Arrays.toString(coloreo.getColores()));
		System.out.println(coloreo.getCantidadDeColores());
	}

}
