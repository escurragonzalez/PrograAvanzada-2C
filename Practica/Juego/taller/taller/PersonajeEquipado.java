package taller;

public abstract  class PersonajeEquipado extends Personaje {

	protected Personaje personaje;

	public PersonajeEquipado(Personaje p) {
		personaje = p;
	}

	@Override
	protected boolean puedeAtacar() {

		return false;
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return personaje.obtenerPuntosDeAtaque();
	}

	public int obtenerPuntosDeDefensa(){
		return personaje.obtenerPuntosDeDefensa();
	}

}
