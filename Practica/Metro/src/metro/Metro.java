package metro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Metro {

	private int nodos;
	private int cantTunel;
	private int puentes;
	private BFS b;
	private int nodoVisita;

	public Metro(String archivoGrafo) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(archivoGrafo));
		nodos = scanner.nextInt();
		cantTunel = scanner.nextInt();
		puentes = scanner.nextInt();
		b = new BFS(nodos, cantTunel);
		for (int i = 0; i < cantTunel; i++) {
			b.getMatrizDeAdyacencia()[(scanner.nextInt()) - 1][(scanner.nextInt()) - 1] = 1;
		}
		scanner.close();
	}

	public void resolver() {
		int cantGrupos = 0;
		nodoVisita = 0;
		do {
			this.b.algoritmoBFS(nodoVisita);
			cantGrupos++;
		} while (!esConexo());
		System.out.println(cantGrupos-1);
	}

	private boolean esConexo() {
		for (int i = 0; i < this.nodos; i++) {
			if (b.getEstado()[i] == 0) {
				nodoVisita = i;
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Metro m = new Metro("metro.in");
		m.resolver();
	}
}
