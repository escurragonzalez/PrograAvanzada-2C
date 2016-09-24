package taller;

public class Orco extends Personaje {

	int cantidadDeAtaques;

	@Override
	protected void despuesDeAtacar() {
		cantidadDeAtaques++;
	}

	@Override
	protected int calcularPuntosDeAtaque() {
		return 10 + cantidadDeAtaques;
	}

	@Override
	protected boolean puedeAtacar() {
		return energia >= calcularPuntosDeAtaque();
	}

	public int obtenerPuntosDeAtaque(){
		return 1;
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		// TODO Auto-generated method stub
		return 0;
	}
}
