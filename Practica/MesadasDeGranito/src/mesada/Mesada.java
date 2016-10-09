package mesada;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mesada {

	private int cantidadMesadas;
	ArrayList<Mesa> lista;
	public int result;

	public Mesada(int c) {
		setCantidadMesadas(c);
		lista = new ArrayList<Mesa>();
	}

	public int getCantidadMesadas() {
		return cantidadMesadas;
	}

	public void setCantidadMesadas(int cantidadMesadas) {
		this.cantidadMesadas = cantidadMesadas;
	}

	public List<Mesa> getLista() {
		return lista;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int r) {
		this.result = r;
	}

	public void addMesa(int a, int b) {
		Mesa m = new Mesa(a, b);
		this.lista.add(m);
	}

	public void procesarMesadas() {
		Collections.sort(this.lista);
		int cont = 0;
		int actual = 0;
		boolean vec[] = new boolean[this.cantidadMesadas];
		for (int i = 0; i < this.cantidadMesadas; i++) {
			if (!vec[i]) {
				actual = this.lista.get(i).getPos2();
				vec[i] = true;
				cont++;
				for (int j = i + 1; j < this.cantidadMesadas; j++) {
					if (!vec[j] && actual >= this.lista.get(j).getPos2()) {
						vec[j] = true;
						actual = this.lista.get(j).getPos2();
					}
				}
			}
		}
		this.setResult(cont);
	}
}
