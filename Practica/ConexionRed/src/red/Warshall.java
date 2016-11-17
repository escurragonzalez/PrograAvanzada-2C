package red;

public class Warshall {

	private int[][] matAdyacencia;
	private int nodos;

	public Warshall(int nodos) {
		this.nodos = nodos;
		this.matAdyacencia = new int[nodos][nodos];
	}

	public void resolver() {
		for (int w = 0; w < nodos; w++) {
			for (int i = 0; i < nodos; i++) {
				for (int j = 0; j < nodos; j++) {
					if (this.matAdyacencia[i][j] == 0 && i != j) {
						if (this.matAdyacencia[i][w] == 1 && this.matAdyacencia[w][j] == 1)
							this.matAdyacencia[i][j] = 1;
					}
				}
			}
		}
	}

	public int[][] getMatAdyacencia() {
		return matAdyacencia;
	}

	public void setMatAdyacencia(int[][] matAdyacencia) {
		this.matAdyacencia = matAdyacencia;
	}
}
