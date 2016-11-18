package algoritmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import algoritmos.Nodo;

public class Kruskal {

	private int cantidadDeNodos;
	private int cantidadDeAristas;
	private ArrayList<Nodo> listaDeNodos;
	private ArrayList<Nodo> arbolDeCostoMinimo;
	private int costoMinimo;
	private int[] padre;

	public Kruskal(String archivo) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(archivo));

		this.cantidadDeNodos = scanner.nextInt();
		this.cantidadDeAristas = scanner.nextInt();
		this.listaDeNodos = new ArrayList<>();
		this.arbolDeCostoMinimo = new ArrayList<>();
		this.padre = new int[this.cantidadDeNodos + 1];
		for (int i = 1; i < this.cantidadDeNodos; i++)
			this.padre[i] = i;
		for (int i = 0; i < this.cantidadDeAristas; i++) {
			this.listaDeNodos.add(new Nodo(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
		}
		scanner.close();
	}

	public void resolver() {
		ArrayList<Nodo> listaDeNodosOrdenada = ordenarListaDeNodos();
		listaDeNodosOrdenada = ordenarListaDeNodos();
		this.costoMinimo = 0;
		Iterator<Nodo> iterator = listaDeNodosOrdenada.iterator();
		while (iterator.hasNext() && this.arbolDeCostoMinimo.size() < this.cantidadDeNodos - 1) {
			Nodo nodo = iterator.next();
			if (find(nodo.getNodoInicial()) != find(nodo.getNodoFinal())) {
				this.costoMinimo = this.costoMinimo + nodo.getCosto();
				this.arbolDeCostoMinimo.add(nodo);
				this.union(nodo.getNodoInicial(), nodo.getNodoFinal());
			}
		}

	}

	private int find(int x) {
		return x == this.padre[x] ? x : find(padre[x]);
	}

	private void union(int x, int y) {
		this.padre[find(x)] = find(y);
	}

	private ArrayList<Nodo> ordenarListaDeNodos() {
		ArrayList<Nodo> listaAOrdenar = new ArrayList<>();
		clonarListaDeNodos(listaAOrdenar);
		Collections.sort(listaAOrdenar);
		return listaAOrdenar;
	}

	private void clonarListaDeNodos(ArrayList<Nodo> listaAOrdenar) {
		for (Nodo nodo : this.listaDeNodos) {
			listaAOrdenar.add(nodo);
		}
	}

	public ArrayList<Nodo> getListaDeNodos() {
		return listaDeNodos;
	}

	public void setListaDeNodos(ArrayList<Nodo> listaDeNodos) {
		this.listaDeNodos = listaDeNodos;
	}

	public ArrayList<Nodo> getArbolDeCostoMinimo() {
		return arbolDeCostoMinimo;
	}

	public void setArbolDeCostoMinimo(ArrayList<Nodo> arbolDeCostoMinimo) {
		this.arbolDeCostoMinimo = arbolDeCostoMinimo;
	}

	public int getCostoMinimo() {
		return costoMinimo;
	}

	public void setCostoMinimo(int costoMinimo) {
		this.costoMinimo = costoMinimo;
	}

	public int[] getPadre() {
		return padre;
	}

	public void setPadre(int[] padre) {
		this.padre = padre;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Kruskal kruskal = new Kruskal("Kruskal.in");
		kruskal.resolver();
		for (Nodo nodo : kruskal.getArbolDeCostoMinimo()) {
			System.out.println(nodo);
		}
	}

}
