package taller;

import taller.Personaje;

public class ConAnilloDraupnir extends PersonajeEquipado {

	public ConAnilloDraupnir(Personaje sigmund) {
		super(sigmund);
	}

	@Override
	protected boolean puedeAtacar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected int calcularPuntosDeAtaque() {
		return 0;
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque()*2;
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return 0;
	}
}
