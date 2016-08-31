package ar.com.unlam.tda;

public class Complejo implements Comparable<Complejo> {

	private double real;
	private double img;

	public Complejo() {
		this.real = 0; // otra forma de hacerlo -> this(0,0);
		this.img = 0;
	}

	public Complejo(double r, double i) {
		this.real = r;
		this.img = i;
	}

	public Complejo(Complejo c) {
		this.real = c.real;
		this.img = c.img;
	}

	public Complejo clone() { // busca crear un nuevo objeto con las
								// caracteristicas del objeto llamador
		Complejo resul = new Complejo();
		resul.real = this.real;
		resul.img = this.img;
		return resul;
	}

	public String toString() {
		return "(" + real + "," + img + "i)";
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImg() {
		return img;
	}

	public void setImg(double img) {
		this.img = img;
	}

	public Complejo suma(Complejo c) {
		Complejo result = new Complejo(this);
		result.real += c.real;
		result.img += c.img;
		return result;
	}

	public Complejo resta(Complejo c) {
		Complejo result = new Complejo(this);
		result.real -= c.real;
		result.img -= c.img;
		return result;
	}

	public Complejo multiplicacion(Complejo c) { // EN FORMA BINOMICA(?)
		Complejo resul = new Complejo();
		resul.real += (this.real * c.real);
		resul.real += (this.img * c.img) * (-1);
		resul.img += (this.real * c.img);
		resul.img += (this.img * c.real);
		return resul;
	}

	public double modulo() {
		double res;
		double a = Math.pow(this.real, 2);
		double b = Math.pow(this.img, 2);
		res = Math.sqrt(a + b);
		return res;
	}

	@Override
	public int compareTo(Complejo o) {
		double modA = this.modulo();
		double modB = o.modulo();
		if (modA > modB)
			return 1;
		else if (modA < modB)
			return -1;
		return 0;
	}
}
