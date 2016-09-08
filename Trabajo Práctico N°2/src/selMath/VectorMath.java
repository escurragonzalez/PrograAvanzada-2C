package selMath;

import java.util.Arrays;

public class VectorMath {

	private double[] vector;

	public VectorMath(int dimension) {
		this.vector = new double[dimension];
	}

	public VectorMath() {
		this(1);
	}

	public VectorMath resta(VectorMath vectorMath) throws DistintaDimensionException {
		if (this.vector.length != vectorMath.vector.length)
			throw new DistintaDimensionException("Las dimensiones son distintas");
		VectorMath vectorAuxiliar = new VectorMath(this.vector.length);
		for (int idx = 0; idx < this.vector.length; idx++)
			vectorAuxiliar.vector[idx] = this.vector[idx] - vectorMath.vector[idx];
		return vectorAuxiliar;
	}

	public double multiplicacion(VectorMath vectorMath) {
		if (this.vector.length != vectorMath.vector.length)
			throw new DistintaDimensionException("Las dimensiones son distintas");
		double escalar = 0;
		for (int idx = 0; idx < this.vector.length; idx++)
			escalar += this.vector[idx] * vectorMath.vector[idx];
		return escalar;

	}

	public VectorMath multiplicacion(MatrizMath matrizMath) {
		if (this.getDimension() != matrizMath.getFila())
			throw new DistintaDimensionException("Las dimensiones son distintas");
		VectorMath vectorAuxiliar = new VectorMath(matrizMath.getColumna());
		double calculoMultiplicacion;
		for (int idx = 0; idx < matrizMath.getColumna(); idx++) {

			calculoMultiplicacion = 0;
			for (int jdx = 0; jdx < this.getDimension(); jdx++)
				calculoMultiplicacion += this.getValorVectorMath(jdx) * matrizMath.getValorMatrizMath(jdx, idx);

			vectorAuxiliar.setValorVectorMath(idx, calculoMultiplicacion);
		}
		return vectorAuxiliar;
	}

	public double normaUno() {

		double normaUno = 0;
		for (int idx = 0; idx < this.vector.length; idx++)
			normaUno += Math.abs(this.vector[idx]);
		return normaUno;
	}

	public double normaDos() {

		double normaDos = 0;
		for (int idx = 0; idx < this.vector.length; idx++)
			normaDos += Math.abs(this.vector[idx]);
		return Math.pow(normaDos, 2);
	}

	public double normaInfinito() {
		double normaInfinito = Math.abs(this.vector[0]);
		for (int idx = 1; idx < this.vector.length; idx++)
			if (normaInfinito < Math.abs(this.vector[idx]))
				normaInfinito = Math.abs(this.vector[idx]);

		return normaInfinito;

	}

	public String toString() {
		return "VectorMath [dimension=" + this.vector.length + ", vectorMath=" + Arrays.toString(vector) + "]";
	}

	public double[] getVector() {
		return vector;
	}

	public void setVector(double[] vector) {
		this.vector = vector;
	}

	public int getDimension() {
		return this.vector.length;
	}

	public void setValorVectorMath(int posicion, double valor) {
		this.vector[posicion] = valor;
	}

	public double getValorVectorMath(int posicion) {
		return this.vector[posicion];
	}

	public static void main(String[] args) {

		VectorMath vectorMath = new VectorMath(3);
		MatrizMath matrizMath = new MatrizMath(3, 3);

		vectorMath.setValorVectorMath(0, 1);
		vectorMath.setValorVectorMath(1, 2);
		vectorMath.setValorVectorMath(2, 3);

		matrizMath.setValorDeMatriz(0, 0, 1);
		matrizMath.setValorDeMatriz(0, 1, 2);
		matrizMath.setValorDeMatriz(0, 2, 3);
		matrizMath.setValorDeMatriz(1, 0, 4);
		matrizMath.setValorDeMatriz(1, 1, 5);
		matrizMath.setValorDeMatriz(1, 2, 6);
		matrizMath.setValorDeMatriz(2, 0, 7);
		matrizMath.setValorDeMatriz(2, 1, 8);
		matrizMath.setValorDeMatriz(2, 2, 9);

		System.out.println(vectorMath.multiplicacion(matrizMath));

	}

}
