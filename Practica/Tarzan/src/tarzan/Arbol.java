package tarzan;

public class Arbol {

	private int x;
	private int y;
	private int orden;

	public Arbol(int x, int y, int o) {
		this.x = x;
		this.y = y;
		this.orden = o;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}
	
	public float distancia(Arbol a){
		return (float) Math.sqrt(Math.pow(this.x-a.x,2)+Math.pow(this.y-a.y,2));
	}
}
