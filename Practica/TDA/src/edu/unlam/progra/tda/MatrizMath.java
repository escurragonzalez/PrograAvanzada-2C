package edu.unlam.progra.tda;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class MatrizMath {

	private int dimensionFil;
	private int dimensionCol;
	private double[][] componentes;

	public MatrizMath(int dimensionFil, int dimensionCol) {
		this.setDimensionFil(dimensionFil);
		this.setDimensionCol(dimensionCol);
		this.componentes = new double[dimensionFil][dimensionCol];
	}

	public void setDimensionFil(int dimensionFil) {
		this.dimensionFil = dimensionFil;
	}

	public void setDimensionCol(int dimensionCol) {
		this.dimensionCol = dimensionCol;
	}

	public MatrizMath(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		String linea = sc.nextLine();
		String[] arraySplit = linea.split(" ");
		this.setDimensionFil(Integer.parseInt(arraySplit[0]));
		this.setDimensionCol(Integer.parseInt(arraySplit[1]));
		this.componentes = new double[getDimensionFil()][this.getDimensionFil()];
		while (sc.hasNext()) {
			this.componentes[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		sc.close();
	}

	public void setComponentes(double[][] componentes) {
		this.setDimensionFil(componentes.length);
		this.setDimensionCol(componentes[0].length);
		this.componentes = new double[this.getDimensionFil()][this.getDimensionCol()];
		for (int i = 0; i < this.getDimensionFil(); i++) {
			for (int j = 0; j < this.getDimensionCol(); j++) {
				this.componentes[i][j] = componentes[i][j];
			}
		}
	}

	public int getDimensionFil() {
		return dimensionFil;
	}

	public int getDimensionCol() {
		return dimensionCol;
	}

	public double[][] getComponentes() {
		return this.componentes;
	}

	public String toString() {
		String resultado = "";
		for (int i = 0; i < this.getDimensionFil(); i++) {
			for (int j = 0; j < this.getDimensionCol(); j++) {
				resultado += this.getComponentes()[i][j] + " ";
			}
			resultado += "\n";
		}
		return resultado;
	}

	public MatrizMath clone() {
		MatrizMath matriz = new MatrizMath(this.getDimensionFil(), this.getDimensionCol());
		matriz.setComponentes(this.getComponentes());
		return matriz;
	}

	public boolean equals(Object matriz) {
		if (matriz == null)
			return false;
		if (!(matriz instanceof MatrizMath))
			return false;
		MatrizMath nuevaMatriz = (MatrizMath) matriz;
		if (nuevaMatriz.getDimensionCol() != this.getDimensionCol()
				|| nuevaMatriz.getDimensionFil() != this.getDimensionFil())
			return false;
		for (int i = 0; i < this.getDimensionFil(); i++) {
			for (int j = 0; j < this.getDimensionCol(); j++) {
				if (this.getComponentes()[i][j] != nuevaMatriz.getComponentes()[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private void productoDeUnaFila(double[][] matriz, int fila, double factor) {
		if (fila < 0 || fila >= this.getDimensionFil())
			throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + fila);
		for (int i = 0; i < this.dimensionCol; i++) {
			matriz[fila][i] *= (factor);
		}
	}

	private void intercambiarFilas(double[][] matriz, int filaOrigen, int filaDestino) {
		try {
			if (filaOrigen < 0 || filaOrigen >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaOrigen);
			if (filaDestino < 0 || filaDestino >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaDestino);
			double auxiliar;
			for (int i = 0; i < this.dimensionCol; i++) {
				auxiliar = matriz[filaOrigen][i];
				matriz[filaOrigen][i] = matriz[filaDestino][i];
				matriz[filaDestino][i] = auxiliar;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void sumarFilas(double[][] matriz, int filaOrigen, int filaDestino) {
		try {
			if (filaOrigen < 0 || filaOrigen >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaOrigen);
			if (filaDestino < 0 || filaDestino >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaDestino);
			for (int i = 0; i < this.dimensionCol; i++) {
				matriz[filaDestino][i] += matriz[filaOrigen][i];
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public MatrizMath sumar(MatrizMath matriz) {
		MatrizMath resultado = new MatrizMath(this.getDimensionFil(), this.getDimensionCol());

		if (this.getDimensionFil() != matriz.getDimensionFil() || this.getDimensionCol() != matriz.getDimensionCol())
			throw new DistDimException(" No se pueden sumar matrices de distinta dimension ");
		for (int i = 0; i < this.getDimensionFil(); i++)
			for (int j = 0; j < this.getDimensionCol(); j++)
				resultado.componentes[i][j] = this.componentes[i][j] + matriz.componentes[i][j];

		return resultado;
	}

	public MatrizMath restar(MatrizMath matriz) {

		MatrizMath resultado = new MatrizMath(this.getDimensionFil(), this.getDimensionCol());

		try {

			if (this.getDimensionFil() != matriz.getDimensionFil()
					|| this.getDimensionCol() != matriz.getDimensionCol())
				throw new DistDimException(" No se pueden restar matrices de distinta dimension ");

			for (int i = 0; i < this.getDimensionFil(); i++)
				for (int j = 0; j < this.getDimensionCol(); j++)
					resultado.componentes[i][j] = this.componentes[i][j] - matriz.componentes[i][j];

		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		return resultado;
	}

	public MatrizMath producto(double numero) {

		MatrizMath resultado = new MatrizMath(this.getDimensionFil(), this.getDimensionCol());

		for (int i = 0; i < this.getDimensionFil(); i++)
			for (int j = 0; j < this.getDimensionCol(); j++)
				resultado.componentes[i][j] = this.componentes[i][j] * numero;
		return resultado;
	}

	public VectorMath producto(VectorMath vec) {
		VectorMath resultado = null;
		try {
			if (this.getDimensionCol() != vec.getDimension())
				throw new DistDimException(" Distinta Dimension entre Matriz y Vector ");

			resultado = new VectorMath(this.getDimensionCol());

			double[] componentes = new double[vec.getDimension()];

			for (int i = 0; i < this.getDimensionFil(); i++)
				for (int j = 0; j < this.getDimensionCol(); j++)
					componentes[i] += this.getComponentes()[i][j] * vec.getComponentes()[j];

			resultado.setComponentes(componentes);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}

	public MatrizMath producto(MatrizMath mat) {
		MatrizMath matriz = null;
		try {
			if (this.getDimensionCol() != mat.getDimensionFil())
				throw new DistDimException(" Distinta Dimension ");
			matriz = new MatrizMath(this.getDimensionFil(), mat.getDimensionCol());
			double[][] componentes = new double[this.getDimensionFil()][mat.getDimensionCol()];

			for (int i = 0; i < this.getDimensionFil(); i++) {
				for (int j = 0; j < mat.getDimensionCol(); j++) {
					for (int k = 0; k < this.getDimensionCol(); k++) {
						componentes[i][j] += this.getComponentes()[i][k] * mat.getComponentes()[k][j];
					}
				}
			}
			matriz.setComponentes(componentes);
			return matriz;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return matriz;

	}

	private boolean intercambiarConRenglonNoNuloPorDebajo(double matriz[][], int filaColumna) {
		try {
			if (filaColumna < 0 || filaColumna >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaColumna);
			if (filaColumna < 0 || filaColumna >= this.dimensionCol)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaColumna);
			for (int i = filaColumna + 1; i < this.dimensionFil; i++) {
				if (matriz[i][filaColumna] != 0) {
					this.intercambiarFilas(matriz, filaColumna, i);
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean intercambiarConRenglonNoNuloPorArriba(double matriz[][], int filaColumna) {
		try {
			if (filaColumna < 0 || filaColumna >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaColumna);
			if (filaColumna < 0 || filaColumna >= this.dimensionCol)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaColumna);

			for (int i = filaColumna - 1; i >= 0; i--) {

				if (matriz[i][filaColumna] != 0) {
					this.intercambiarFilas(matriz, filaColumna, i);
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	private void llevarACeroPosicionesPorDebajo(double[][] matriz, int filaColumna) {
		try {
			if (filaColumna < 0 || filaColumna >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaColumna);
			if (filaColumna < 0 || filaColumna >= this.dimensionCol)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaColumna);

			for (int i = filaColumna + 1; i < this.dimensionFil; i++) {

				if (matriz[i][filaColumna] != 0) {
					double factorMultiplicacion = (matriz[i][filaColumna] / matriz[filaColumna][filaColumna]);
					this.diferenciaFilaConMultiploDeOtra(matriz, i, filaColumna, factorMultiplicacion);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void diferenciaFilaConMultiploDeOtra(double[][] matriz, int filaOrigen, int filaDestino,
			double factorMultiplicacion) {
		try {
			if (filaOrigen < 0 || filaOrigen >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaOrigen);
			if (filaDestino < 0 || filaDestino >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaDestino);

			double temp;

			for (int i = 0; i < this.dimensionCol; i++) {
				temp = (factorMultiplicacion) * matriz[filaDestino][i];
				matriz[filaOrigen][i] -= temp;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void llevarACeroPosicionesPorArriba(double[][] matriz, int filaColumna) {
		try {
			if (filaColumna < 0 || filaColumna >= this.dimensionFil)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaColumna);
			if (filaColumna < 0 || filaColumna >= this.dimensionCol)
				throw new ArrayIndexOutOfBoundsException(" Error Valor Indice de Matriz: " + filaColumna);

			for (int i = filaColumna - 1; i >= 0; i--) {

				if (matriz[i][filaColumna] != 0) {
					double factorMultiplicacion = (matriz[i][filaColumna] / matriz[filaColumna][filaColumna]);
					this.diferenciaFilaConMultiploDeOtra(matriz, i, filaColumna, factorMultiplicacion);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private double determinanteCuadrada() {// determinante matriz cuadrada por Gauss											
		double deter = 1;
		double[][] matriz = this.clone().getComponentes();

		for (int i = 0; i < this.dimensionCol; i++) {
			if (matriz[i][i] == 0) {
				if (this.intercambiarConRenglonNoNuloPorDebajo(matriz, i) == true) {
					deter *= (-1);
				}
			}
			this.llevarACeroPosicionesPorDebajo(matriz, i);
			deter *= matriz[i][i];
		}
		return deter;
	}

	public double determinante() {
		if (this.dimensionCol != this.dimensionFil) {
			throw new UnsupportedOperationException(" No Hay Implementacion para Matrices no Cuadradas");
		}

		return this.determinanteCuadrada();
	}

	private void tratarDiagonalPrincipal(double[][] matriz) {
		try {
			for (int i = 0; i < this.getDimensionFil(); i++) {
				if (matriz[i][i] == 0) {
					if (this.intercambiarConRenglonNoNuloPorDebajo(matriz, i) == false) {
						throw new Exception(" No Se Puede Resolver La Inversa " + i);
					}
				}
				this.llevarACeroPosicionesPorArriba(matriz, i);
				this.llevarACeroPosicionesPorDebajo(matriz, i);
				this.productoDeUnaFila(matriz, i, 1 / (matriz[i][i]));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public MatrizMath invertir() {
		MatrizMath inversa = this.clone();
		double[][] matriz = inversa.adjuntaDerechaIdentidad();
		inversa.setComponentes(matriz);
		try {
			inversa.tratarDiagonalPrincipal(matriz);
		} catch (Exception e) {
			e.getMessage();
		}
		double[][] matrizInversa = inversa.tomarMatrizCuadradaALaDerecha(matriz);
		inversa.setComponentes(matrizInversa);
		return inversa;
	}

	private double[][] tomarMatrizCuadradaALaDerecha(double[][] matriz) {
		double[][] matrizCuadrada = null;
		if (this.getDimensionCol() < this.getDimensionFil()) {
			throw new DistDimException(" Se Intenta Operar Con Filas Mayores Que Columnas ");
		}
		matrizCuadrada = new double[this.getDimensionFil()][this.getDimensionFil()];
		for (int i = 0; i < this.getDimensionFil(); i++)
			for (int j = 0; j < this.getDimensionFil(); j++) {
				matrizCuadrada[i][j] = matriz[i][this.getDimensionCol() - this.dimensionFil + j];
			}
		return matrizCuadrada;
	}

	private double[][] adjuntaDerechaIdentidad() {
		double[][] matriz = new double[this.getDimensionFil()][this.getDimensionCol() * 2];
		for (int fila = 0; fila < matriz.length; fila++) {
			for (int col = 0; col < matriz[0].length; col++) {
				if (col >= this.getDimensionCol()) {
					if ((col - fila) == this.getDimensionCol()) {
						matriz[fila][col] = 1;
					} else {
						matriz[fila][col] = 0;
					}
				} else {
					matriz[fila][col] = this.getComponentes()[fila][col];
				}
			}
		}
		return matriz;
	}

	public double normaDos() {
		double sumaCuadrados = 0;
		for (int i = 0; i < this.componentes.length; i++) {
			for (int j = 0; j < this.componentes[0].length; j++) {
				sumaCuadrados += Math.pow(this.componentes[i][j], 2);
			}
		}
		return (double) Math.sqrt(sumaCuadrados);
	}

	public void setIdentidad() {
		if (this.dimensionCol != this.dimensionFil) {
			throw new UnsupportedOperationException(" No Hay Implementacion para Matrices no Cuadradas");
		}
		double[][] identidad = new double[this.dimensionFil][this.dimensionCol];
		for (int i = 0; i < this.getDimensionFil(); i++)
			for (int j = 0; j < this.getDimensionCol(); j++) {
				if (i == j)
					identidad[i][j] = 1;
				else
					identidad[i][j] = 0;
			}
		this.componentes = identidad;
	}
}
