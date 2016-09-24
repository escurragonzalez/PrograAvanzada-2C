package taller;

public abstract class Personaje implements Atacable {

	protected int energia = 100;
	protected int salud = 100;

	public final void atacar(Atacable atacado) {
		if (puedeAtacar()) {
			atacado.serAtacado(calcularPuntosDeAtaque());
			energia -= calcularPuntosDeAtaque();
			despuesDeAtacar();
		}
	}

	protected void despuesDeAtacar() { }

	protected abstract boolean puedeAtacar();
	protected abstract int calcularPuntosDeAtaque();

	public boolean estaVivo() {
		return this.salud > 0;
	}

	@Override
	public void serAtacado(int dano) {
		this.salud -= dano;
	}

	public void serCurado() {
		this.salud = 100;
	}

	public void serEnergizado() {
		this.energia = 100;
	}

	public int getSalud() {
		return this.salud;
	}

	public abstract int obtenerPuntosDeAtaque();
	public abstract int obtenerPuntosDeDefensa();
}
