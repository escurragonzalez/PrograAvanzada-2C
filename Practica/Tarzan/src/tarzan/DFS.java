package tarzan;

import java.util.ArrayList;

public class DFS {

	private int[][] matAdyacencia;
	private ArrayList<Integer> precedentes;
	private int salto;
	private boolean superSalto;
	private int nodos;

	public DFS(int nodos) {
		this.nodos = nodos;
		matAdyacencia = new int[nodos][nodos];
		precedentes = new ArrayList<Integer>();
		salto = 0;
		superSalto = false;
	}

	public int[][] getMatAdyacencia() {
		return matAdyacencia;
	}

	public void setMatAdyacencia(int[][] matAdyacencia) {
		this.matAdyacencia = matAdyacencia;
	}

	public ArrayList<Integer> getPrecedentes() {
		return precedentes;
	}

	public void setPrecedentes(ArrayList<Integer> precedentes) {
		this.precedentes = precedentes;
	}

	public int getSalto() {
		return salto;
	}

	public void setSalto(int salto) {
		this.salto = salto;
	}

	public boolean isSuperSalto() {
		return superSalto;
	}

	public void setSuperSalto(boolean superSalto) {
		this.superSalto = superSalto;
	}

	public void resolver(int origen, int destino) {
		ArrayList<Integer> auxPrecedente = new ArrayList<Integer>();
		auxPrecedente.add(origen);
		int menor = Integer.MAX_VALUE;
		while (!auxPrecedente.isEmpty()) {
			for (int i = 0; i < this.nodos; i++) {
				if (matAdyacencia[auxPrecedente.get(i)][i] != 0) {
					auxPrecedente.add(i);
					salto++;
					if (matAdyacencia[auxPrecedente.get(i)][i] == 2 && !superSalto) {
						superSalto = true;
					} else {
						auxPrecedente.remove(i);
						salto--;
					}
					if (i == destino) {
						if (menor < salto) {
							menor = salto;
							this.precedentes = new ArrayList<Integer>(auxPrecedente);
							auxPrecedente.remove(i);
							salto--;
						}
					}
				}
			}
		}
	}
}
