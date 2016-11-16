package rescate;

public class Dijkstra {
	
	private int[] distancias;
	private int[] precedentes;
	
	public void  dijkstra(int[][] m, int nodoPrincipe) {
		int dim=m[0].length;
		this.distancias= new int[dim];
		this.precedentes= new int[dim];
		int w = 0, cantIteraciones = dim - 1;

		for (int i = 0; i < dim; i++) {
			distancias[i] = m[nodoPrincipe][i];
		}

		for (int i = 0; i < dim; i++) {
			precedentes[i] = nodoPrincipe;
		}

		int[] vMenosS = new int[dim];
		int aux = 0, n = 0;

		for (int i = 0; i < vMenosS.length; i++) {
			if (i != nodoPrincipe)
				vMenosS[i] = i;
			else
				vMenosS[i] = Integer.MAX_VALUE;
		}

		while (cantIteraciones > 0) {
			n = Integer.MAX_VALUE;
			for (int i = 0; i < dim; i++) {
				if (distancias[i] < n)
					if (vMenosS[i] != Integer.MAX_VALUE) {
						w = i;
						n = distancias[i];
					}
			}

			vMenosS[w] = Integer.MAX_VALUE;

			for (int i = 0; i < dim; i++) {
				if (m[w][i] != Integer.MAX_VALUE) {
					aux = distancias[i];
					distancias[i] = Math.min(distancias[i],
							distancias[w] + m[w][i]);
					if (aux != distancias[i])
						precedentes[i] = w;
				}
			}
			cantIteraciones--;
		}
	}

	public int[] getDistancias() {
		return distancias;
	}

	public void setDistancias(int[] distancias) {
		this.distancias = distancias;
	}

	public int[] getPrecedentes() {
		return precedentes;
	}

	public void setPrecedentes(int[] precedentes) {
		this.precedentes = precedentes;
	}
}
