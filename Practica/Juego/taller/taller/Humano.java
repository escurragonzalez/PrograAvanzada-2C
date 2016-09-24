package taller;

public class Humano extends Personaje {

	@Override
	protected int calcularPuntosDeAtaque() {
		return 1;
	}

	@Override
	protected boolean puedeAtacar() {
		return energia >= 10;
	}

	public int obtenerPuntosDeAtaque(){
		return calcularPuntosDeAtaque();
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return 0;
	}
}
