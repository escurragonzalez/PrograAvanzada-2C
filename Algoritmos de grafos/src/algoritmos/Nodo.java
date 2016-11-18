package algoritmos;

public class Nodo implements Comparable<Nodo> {

	private int nodoInicial;
	private int nodoFinal;
	private int costo;

	public Nodo(int nodoInicial, int nodoFinal, int costo) {
		this.nodoInicial = nodoInicial;
		this.nodoFinal = nodoFinal;
		this.costo = costo;
	}

	@Override
	public int compareTo(Nodo nodo) {
		return this.costo - nodo.costo;
	}

	public int getNodoInicial() {
		return nodoInicial;
	}

	public void setNodoInicial(int nodoInicial) {
		this.nodoInicial = nodoInicial;
	}

	public int getNodoFinal() {
		return nodoFinal;
	}

	public void setNodoFinal(int nodoFinal) {
		this.nodoFinal = nodoFinal;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Nodo [nodoInicial=" + nodoInicial + ", nodoFinal=" + nodoFinal + ", costo=" + costo + "]";
	}

}
