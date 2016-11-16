package batiendoAlMinotauro;

import java.util.ArrayList;

public class Arista implements Comparable<Arista> {

	private int origen, destino, costo;

	public Arista(int origen, int destino, int costo) {
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
	}

	@Override
	public int compareTo(Arista arista) {
		if (this.costo == arista.costo)
			return 0;
		if (this.costo > arista.costo)
			return 1;
		else
			return -1;

	}

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

}
