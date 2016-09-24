package taller;

public class ConEspadaSkofnung extends PersonajeEquipado{

	public ConEspadaSkofnung(Personaje p) {
		super(p);
	}

	@Override
	protected boolean puedeAtacar() {
		return false;
	}

	@Override
	protected int calcularPuntosDeAtaque() {
		return 1;
	}

	public int obtenerPuntosDeAtaque(){
		return super.obtenerPuntosDeAtaque()+5;
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return 0;
	}
}
