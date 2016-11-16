package rescate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Rescate {

	private static boolean estaIntersectado = false;
	private static boolean noHayCamino;
	private Dijkstra d;
	private String salida = "";
	private int[][] matrizAdyacencia;
	private int nodoInicial;
	private int nodoFinal;
	private int[] nodosConDragones;

	public Rescate(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		int nodos = sc.nextInt();
		int aristas = sc.nextInt();
		int dragones = sc.nextInt();
		nodoFinal = sc.nextInt() - 1;
		nodoInicial = sc.nextInt() - 1;
		nodosConDragones = new int[nodos];
		matrizAdyacencia = new int[nodos][nodos];
		for (int i = 0; i < dragones; i++) {
			nodosConDragones[sc.nextInt() - 1] = 1;
		}
		for (int i = 0; i < nodos; i++) {
			for (int j = 0; j < nodos; j++) {
				matrizAdyacencia[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < aristas; i++) {
			matrizAdyacencia[sc.nextInt() - 1][sc.nextInt() - 1] = sc.nextInt();
		}
		sc.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		Rescate r = new Rescate("entrada.in");
		Dijkstra d = new Dijkstra();
		d.dijkstra(r.matrizAdyacencia, r.nodoInicial);
		int indice = r.nodoFinal;
		Stack<Integer> pila = new Stack<Integer>();
		if (d.getDistancias()[r.nodoFinal] == Integer.MAX_VALUE) {
			r.salida = "No hay camino";
			noHayCamino = true;
		} else {
			pila.push(r.nodoFinal + 1);
			while (d.getPrecedentes()[indice] != r.nodoInicial) {
				if (r.nodosConDragones[d.getPrecedentes()[indice]] == 1) {
					estaIntersectado = true;
				}
				pila.push(d.getPrecedentes()[indice] + 1);
				indice = d.getPrecedentes()[indice];
			}
			pila.push(r.nodoInicial + 1);
		}
		if (estaIntersectado) {
			pila.clear();
			indice=r.nodoFinal;
			r.salida = "Intersectado";
			r.tratarMatriz();
			d.dijkstra(r.matrizAdyacencia, r.nodoInicial);
			if (d.getDistancias()[r.nodoFinal] == Integer.MAX_VALUE) {
				r.salida = "Intersectado";
			} else {
				estaIntersectado = false;
				
				pila.push(r.nodoFinal + 1);
				while (d.getPrecedentes()[indice] != r.nodoInicial) {
					pila.push(d.getPrecedentes()[indice] + 1);
					indice = d.getPrecedentes()[indice];
				}
				pila.push(r.nodoInicial + 1);
			}
		}
		if (!estaIntersectado && !noHayCamino) {
			r.salida = "";
			while (!pila.isEmpty()) {
				r.salida += pila.pop() + " ";
			}
		}
		System.out.println(r.salida);
	}

	private void tratarMatriz() {
		for (int i = 0; i < this.nodosConDragones.length; i++) {
			if (this.nodosConDragones[i] == 1) {
				for (int j = 0; j < this.matrizAdyacencia.length; j++) {
					this.matrizAdyacencia[i][j] = Integer.MAX_VALUE;
					this.matrizAdyacencia[j][i] = Integer.MAX_VALUE;
				}
			}
		}
	}
}
