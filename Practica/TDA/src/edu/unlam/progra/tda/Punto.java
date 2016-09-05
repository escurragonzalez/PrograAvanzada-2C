package edu.unlam.progra.tda;

public class Punto {
	private double x;
	private double y;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Punto(double i, double j) {
		setX(i);
		setY(j);
	}

	public Punto(){
		setX(0);
		setY(0);
	}
	public double getx() {
		return this.x;
	}

	public String toString() {
		return String.valueOf(getX()) + " " + String.valueOf(getY());
	}

	public boolean equals(Object p) {
		if (p == null)
			return false;
		if (!(p instanceof Punto))
			return false;
		Punto punto = (Punto) p;
		if (getX() == punto.getX() && getY() == punto.getY())
			return true;
		else
			return false;
	}

	public double modulo() {
		double res = Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2));
		return res;
	}

	public double distancia(Object p) {
		if (p == null)
			return -1;
		if (!(p instanceof Punto))
			return -1;
		Punto punto = (Punto) p;
		double res = Math.sqrt(Math.pow(getX() - punto.getX(), 2) + Math.pow(getY() - punto.getY(), 2));
		return res;
	}

	public String desplazamiento(Object p) {
		if (p == null)
			return "";
		if (!(p instanceof Punto))
			return "";
		Punto punto = (Punto) p;
		setX(getX() + punto.getX());
		setY(getY() + punto.getY());
		return this.toString();
	}
}
