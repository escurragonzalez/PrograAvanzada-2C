package tarzan;

import java.util.ArrayList;

public class DFS {

	private int[][] matAdyacencia;
	private ArrayList<Integer> precedentes;
	private boolean superSalto;
	private int nodos;

	public DFS(int nodos) {
		this.nodos = nodos;
		matAdyacencia = new int[nodos][nodos];
		precedentes = new ArrayList<Integer>();
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

	public boolean isSuperSalto() {
		return superSalto;
	}

	public void setSuperSalto(boolean superSalto) {
		this.superSalto = superSalto;
	}

	public void resolver(int origen, int destino) {
		ArrayList<Integer> auxPrecedente = new ArrayList<Integer>();
		int indice = 1, salto = 0;
		auxPrecedente.add(origen);
		int menor = Integer.MAX_VALUE;
		while (!auxPrecedente.isEmpty()) {
			for (int i = indice; i < this.nodos; i++) {
				if (matAdyacencia[auxPrecedente.get(auxPrecedente.size() - 1)][i] != 0) {
					if (matAdyacencia[auxPrecedente.get(auxPrecedente.size() - 1)][i] == 1) {
						auxPrecedente.add(i);
						salto++;
					}
					if (matAdyacencia[auxPrecedente.get(auxPrecedente.size() - 1)][i] == 2) {
						if (!superSalto) {
							superSalto = true;
							auxPrecedente.add(i);
							salto++;
						}
					}
					if (auxPrecedente.get(auxPrecedente.size() - 1) == destino) {
						if (menor >= salto) {
							menor = salto;
							this.precedentes = new ArrayList<Integer>(auxPrecedente);
							if (matAdyacencia[auxPrecedente.get(auxPrecedente.size() - 2)][auxPrecedente
									.get(auxPrecedente.size() - 1)] == 2)
								superSalto = false;
							indice = auxPrecedente.get(auxPrecedente.size() - 1) + 1;
							auxPrecedente.remove(auxPrecedente.size() - 1);
							salto--;
						}
					}
				}

			}

			if (auxPrecedente.size()>=2 && matAdyacencia[auxPrecedente.get(auxPrecedente.size() - 2)][auxPrecedente
					.get(auxPrecedente.size() - 1)] == 2)
				superSalto = false;
			indice = auxPrecedente.get(auxPrecedente.size() - 1) + 1;
			auxPrecedente.remove(auxPrecedente.size() - 1);
			salto--;
		}

	}

	public void mostrarPrecedente() {
		for (int i = 0; i < precedentes.size(); i++) {
			System.out.println(precedentes.get(i));
		}
	}

	public void mostrarMatriz() {
		for (int i = 0; i < matAdyacencia.length; i++) {
			for (int j = 0; j < matAdyacencia.length; j++) {
				System.out.print(" " + matAdyacencia[i][j]);
			}
			System.out.println();
		}
	}
}
