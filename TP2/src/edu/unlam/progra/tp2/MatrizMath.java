package edu.unlam.progra.tp2;

import java.io.*;
import java.util.*;

public class MatrizMath {

	private int fila;
	private int columna;
	private double[][] matriz;
	private String tipoSistema;

	public MatrizMath(int fila, int columna) {
		this.setFila(fila);
		this.setColummna(columna);
		this.matriz = new double[fila][columna];
	}

	public MatrizMath(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		String linea = sc.nextLine();
		String[] arraySplit = linea.split(" ");
		this.setFila(Integer.parseInt(arraySplit[0]));
		this.setColummna(Integer.parseInt(arraySplit[1]));
		this.matriz = new double[getFila()][this.getFila()];
		while (sc.hasNext()) {
			this.matriz[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		sc.close();
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setColummna(int columna) {
		this.columna = columna;
	}

	public void setMatriz(double[][] componentes) {
		this.setFila(componentes.length);
		this.setColummna(componentes[0].length);
		this.matriz = new double[this.getFila()][this.getColumna()];
		for (int i = 0; i < this.getFila(); i++) {
			for (int j = 0; j < this.getColumna(); j++) {
				this.matriz[i][j] = componentes[i][j];
			}
		}
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public double[][] getMatriz() {
		return this.matriz;
	}

	public String toString() {
		String resultado = "";
		for (int i = 0; i < this.getFila(); i++) {
			for (int j = 0; j < this.getColumna(); j++) {
				resultado += this.getMatriz()[i][j] + " ";
			}
			resultado += "\n";
		}
		return resultado;
	}

	public MatrizMath clone() {
		MatrizMath matriz = new MatrizMath(this.getFila(), this.getColumna());
		matriz.setMatriz(this.getMatriz());
		return matriz;
	}

	public boolean equals(Object matriz) {
		if (matriz == null)
			return false;
		if (!(matriz instanceof MatrizMath))
			return false;
		MatrizMath nuevaMatriz = (MatrizMath) matriz;
		if (nuevaMatriz.getColumna() != this.getColumna() || nuevaMatriz.getFila() != this.getFila())
			return false;
		for (int i = 0; i < this.getFila(); i++) {
			for (int j = 0; j < this.getColumna(); j++) {
				if (this.getMatriz()[i][j] != nuevaMatriz.getMatriz()[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public MatrizMath sumar(MatrizMath matriz) {
		if (this.getFila() != matriz.getFila() || this.getColumna() != matriz.getColumna())
			throw new DistDimException(".No se pueden sumar matrices de distinta dimension.");
		MatrizMath resultado = new MatrizMath(this.getFila(), this.getColumna());
		for (int i = 0; i < this.getFila(); i++)
			for (int j = 0; j < this.getColumna(); j++)
				resultado.matriz[i][j] = this.matriz[i][j] + matriz.matriz[i][j];
		return resultado;
	}

	public MatrizMath restar(MatrizMath matriz) {
		if (this.getFila() != matriz.getFila() || this.getColumna() != matriz.getColumna())
			throw new DistDimException("No se pueden restar matrices de distinta dimension.");
		MatrizMath resultado = new MatrizMath(this.getFila(), this.getColumna());
		for (int i = 0; i < this.getFila(); i++)
			for (int j = 0; j < this.getColumna(); j++)
				resultado.matriz[i][j] = this.matriz[i][j] - matriz.matriz[i][j];
		return resultado;
	}

	public VectorMath producto(VectorMath vec) {
		if (this.columna != vec.getDimension())
			throw new DistDimException("Dimension Distinta.");
		VectorMath result = new VectorMath(vec.getDimension());
		double[] aux = new double[vec.getDimension()];
		for (int i = 0; i < this.fila; i++) {
			for (int j = 0; j < this.columna; j++) {
				aux[i] += this.matriz[i][j] * vec.getComponentes()[j];
			}
		}
		result.setComponentes(aux);
		return result;
	}

	public MatrizMath producto(double numero) {
		MatrizMath resultado = new MatrizMath(this.getFila(), this.getColumna());
		for (int i = 0; i < this.getFila(); i++)
			for (int j = 0; j < this.getColumna(); j++)
				resultado.matriz[i][j] = this.matriz[i][j] * numero;
		return resultado;
	}

	public MatrizMath producto(MatrizMath m) {
		if (this.columna != m.getFila())
			throw new DistDimException(".Distinta Dimension.");

		int col_m1 = this.columna;
		int fil_m1 = this.getFila();
		int col_m2 = m.columna;

		double[][] multiplicacion = new double[fil_m1][col_m2];

		MatrizMath res = new MatrizMath(this.getFila(), m.columna);

		for (int x = 0; x < multiplicacion.length; x++) {
			for (int y = 0; y < multiplicacion[x].length; y++) {
				for (int z = 0; z < col_m1; z++) {
					multiplicacion[x][y] += this.matriz[x][z] * m.matriz[z][y];
				}
			}
		}

		res.matriz = multiplicacion;
		return res;

	}

	public double normaUno() {
		double res = 0;
		double acum;

		for (int i = 0; i < this.getFila(); i++) {
			acum = 0;
			for (int j = 0; j < this.columna; j++) {
				acum += Math.abs(this.matriz[j][i]);
			}

			if (acum >= res)
				res = acum;
		}

		return res;
	}

	public double normaDos() {
		double sumaCuadrados = 0;
		for (int i = 0; i < this.fila; i++) {
			for (int j = 0; j < this.columna; j++) {
				sumaCuadrados += Math.pow(this.matriz[i][j], 2);
			}
		}
		return (double) Math.sqrt(sumaCuadrados);
	}

	public double normaInfinito() {
		double res = 0;
		double acum;

		for (int i = 0; i < this.getFila(); i++) {
			acum = 0;
			for (int j = 0; j < this.columna; j++) {
				acum += Math.abs(this.matriz[i][j]);
			}

			if (acum >= res)
				res = acum;
		}

		return res;
	}

	public MatrizMath transpuesta() {

		MatrizMath res = new MatrizMath(this.columna, this.getFila());
		for (int i = 0; i < this.getFila(); i++) {
			for (int j = 0; j < this.columna; j++) {
				res.matriz[j][i] = this.matriz[i][j];
			}
		}
		return res;
	}

	public VectorMath gaussJordan(VectorMath resultados) throws Exception {
		if (this.columna != this.getFila())
			throw new DistDimException("LA MATRIZ NO ES CUADRADA.");

		int rangoA, rangoAPrima; // necesarios para saber el tipo de sistema
		double pivot = 1;
		MatrizMath def = new MatrizMath(this.fila, this.columna); // idem
																	// anterior

		VectorMath res = new VectorMath(this.getFila());
		MatrizMath ampliada = new MatrizMath(this.getFila(), this.columna + 1);
		for (int i = 0; i < this.getFila(); i++) {
			for (int j = 0; j < this.columna; j++) {
				ampliada.matriz[i][j] = this.matriz[i][j];
			}
		}

		int x = ampliada.columna - 1; // para la ampliada
		// creo la ampliada y la cargo
		for (int i = 0; i < resultados.getDimension(); i++) {
			ampliada.matriz[i][x] = resultados.getComponentes()[i];
		}

		int f = 0, c = 0;
		if (ampliada.matriz[f][c] != 0)
			pivot = ampliada.matriz[f][c]; // cargo el de la posicion 00
		double opuesto = 0;

		for (int i = 0; i < ampliada.columna; i++) {
			ampliada.matriz[f][i] = (ampliada.matriz[f][i] / pivot); // creo el
																		// primer
																		// 1
		}

		if (f == 0 && c == 0)
			for (int i = 1; i < ampliada.getFila(); i++) {
				opuesto = (ampliada.matriz[i][0] * (-1));
				for (int j = 0; j < ampliada.columna; j++) {
					ampliada.matriz[i][j] = (opuesto * ampliada.matriz[0][j]) + ampliada.matriz[i][j];
				}
			}

		int veces = ampliada.getFila() - 1;
		while (veces > 0) {
			f++;
			c++;
			if (ampliada.matriz[f][c] != 0)
				pivot = ampliada.matriz[f][c];
			else
				pivot = 1;
			for (int i = f; i < ampliada.columna; i++) {
				if (ampliada.matriz[f][i] != 0)
					ampliada.matriz[f][i] = (ampliada.matriz[f][i] / pivot);
			}

			for (int i = 0; i < ampliada.getFila(); i++) {
				if (i != f) {
					opuesto = (ampliada.matriz[i][c] * (-1));
					for (int j = 0; j < ampliada.columna; j++) {
						ampliada.matriz[i][j] = opuesto * ampliada.matriz[f][j] + ampliada.matriz[i][j];
					}
				}
			}
			veces--;
		}

		for (int i = 0; i < def.fila; i++) {
			for (int j = 0; j < def.columna; j++) {
				def.matriz[i][j] = ampliada.matriz[i][j];
			}
		}

		// saco los rangos
		rangoA = def.rango();
		rangoAPrima = ampliada.rango();
		setTipoSistema("DETERMINADO");
		if (rangoA == rangoAPrima && rangoA < this.columna) {
			// "EL SISTEMA POSEE INFINITAS SOLUCIONES."
			setTipoSistema("INDETERMINADO");
		}

		if (rangoA != rangoAPrima) {
			// "EL SISTEMA NO POSEE SOLUCIÓN."
			setTipoSistema("IMCOMPATIBLE");
		}

		double[] aux = new double[this.fila];
		for (int i = 0; i < res.getDimension(); i++) {
			aux[i] = ampliada.matriz[i][ampliada.columna - 1];
		}
		res.setComponentes(aux);
		return res;
	}

	public MatrizMath inversa() {

		if (this.getFila() != this.columna)
			throw new DistDimException("LA MATRIZ NO ES CUADRADA!");

		MatrizMath res = new MatrizMath(this.getFila(), this.columna);
		MatrizMath ampliada = new MatrizMath(this.getFila(), this.columna * 2);

		// cargo la matriz llamadora más la matriz de resultados para formar LA
		// AMPLIADA
		for (int i = 0; i < this.getFila(); i++) {
			for (int j = 0; j < this.columna; j++) {
				ampliada.matriz[i][j] = this.matriz[i][j];
			}
		}

		for (int i = 0; i < ampliada.getFila(); i++) {
			for (int j = this.columna; j < ampliada.columna; j++) {
				if (j - i == this.getFila())
					ampliada.matriz[i][j] = 1;
				else
					ampliada.matriz[i][j] = 0;
			}
		}

		double pivot = 0;
		int f = 0, c = 0;
		pivot = ampliada.matriz[f][c]; // cargo el de la posicion 00
		double opuesto = 0;

		for (int i = 0; i < ampliada.columna; i++) {
			ampliada.matriz[f][i] = (ampliada.matriz[f][i] / pivot); // creo el
																		// primer
																		// 1
		}

		// creo los ceros en la columna x0
		if (f == 0 && c == 0)
			for (int i = 1; i < ampliada.fila; i++) {
				opuesto = (ampliada.matriz[i][0] * (-1));
				for (int j = 0; j < ampliada.columna; j++) {
					ampliada.matriz[i][j] = (opuesto * ampliada.matriz[0][j]) + ampliada.matriz[i][j];
				}
			}

		int veces = ampliada.fila - 1;

		while (veces > 0) {
			f++;
			c++;
			pivot = ampliada.matriz[f][c];
			for (int i = f; i < ampliada.columna; i++) {
				ampliada.matriz[f][i] = (ampliada.matriz[f][i] / pivot); // creo
																			// el
																			// 1
																			// en
																			// la
																			// fila
																			// del
																			// pivot
																			// para
																			// ir
																			// escalonando
			}

			for (int i = 0; i < ampliada.fila; i++) {
				if (i != f) { // si no es el pivot , le saco el opuesto
					opuesto = (ampliada.matriz[i][c] * (-1));
					for (int j = 0; j < ampliada.columna; j++) {
						ampliada.matriz[i][j] = opuesto * ampliada.matriz[f][j] + ampliada.matriz[i][j];
					}
				}
			}
			veces--;
		}
		// cargo en 'res' la matriz resultado para devolver
		for (int i = 0; i < ampliada.fila; i++) {
			int b = 0;
			for (int j = this.columna; j < ampliada.columna; j++) {
				if (j - i == this.fila)
					res.matriz[i][b] = ampliada.matriz[i][j];
				else
					res.matriz[i][b] = ampliada.matriz[i][j];
				b++;
			}
		}
		return res;
	}

	public double determinante() {
		if (this.getFila() != this.getColumna())
			throw new DistDimException("LA MATRIZ NO ES CUADRADA.");

		MatrizMath aux = this.clone();
		int f = 0, c = 0;
		double res = 1;
		double pivot = 0;
		double opuesto = 0;

		for (int a = 0; a < this.getFila() - 1; a++) {
			pivot = aux.matriz[f][c];

			for (int i = f + 1; i < aux.columna; i++) {
				opuesto = (aux.matriz[i][c] * (-1)) / pivot;
				for (int j = c; j < this.columna; j++) {
					aux.matriz[i][j] = (aux.matriz[f][j] * opuesto) + aux.matriz[i][j];
				}
			}
			f++;
			c++;
		}

		for (int i = 0; i < aux.columna; i++) {
			res *= aux.matriz[i][i];
		}
		return res;
	}

	// Necesario para ver que tipo de sistema es
	public int rango() {
		int r = this.fila;
		int ceros;
		for (int i = 0; i < this.fila; i++) {
			ceros = 0;
			for (int j = 0; j < this.columna; j++) {
				if (this.matriz[i][j] == 0)
					ceros++;
			}

			if (ceros == this.columna)
				r--;
		}
		return r;
	}

	public String getTipoSistema() {
		return tipoSistema;
	}

	public void setTipoSistema(String tipoSistema) {
		this.tipoSistema = tipoSistema;
	}

}
