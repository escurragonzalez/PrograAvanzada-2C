package tp4;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Generador {

	private MatrizSimetrica matrizDeAdyacencia;
	private int cantNodos;
	private int cantAristas;
	private int gradoMaxima;
	private int gradoMinima;
	private double porcAdyacencia;

	public Generador(int nodos) {
		this.cantNodos = nodos;
		matrizDeAdyacencia = new MatrizSimetrica(nodos);
	}

	public MatrizSimetrica getMatrizDeAdyacencia() {
		return matrizDeAdyacencia;
	}

	public void setMatrizDeAdyacencia(MatrizSimetrica matrizDeAdyacencia) {
		this.matrizDeAdyacencia = matrizDeAdyacencia;
	}

	public int getCantNodos() {
		return cantNodos;
	}

	public void setCantNodos(int cantNodos) {
		this.cantNodos = cantNodos;
	}

	public int getCantAristas() {
		return cantAristas;
	}

	public void setCantAristas(int cantAristas) {
		this.cantAristas = cantAristas;
	}

	public int getGradoMaxima() {
		return gradoMaxima;
	}

	public void setGradoMaxima(int gradoMaxima) {
		this.gradoMaxima = gradoMaxima;
	}

	public int getGradoMinima() {
		return gradoMinima;
	}

	public void setGradoMinima(int gradoMinima) {
		this.gradoMinima = gradoMinima;
	}

	public double getPorcAdyacencia() {
		return porcAdyacencia;
	}

	public void setPorcAdyacencia(double porcAdyacencia) {
		this.porcAdyacencia = porcAdyacencia;
	}

	public void escribirArchivo(String path){
		FileWriter archivo = null;
		PrintWriter pw = null;
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		try {
			archivo = new FileWriter(path);
			pw = new PrintWriter(archivo);
			calcularGrado();
			pw.println(this.cantNodos + " " + this.cantAristas + " " + df.format(this.porcAdyacencia) + " " + this.gradoMaxima
					+ " " + this.gradoMinima);
			for (int i = 0; i < this.cantNodos; i++) {
				for (int j = 0; j < this.cantNodos; j++) {
					if (i!=j && matrizDeAdyacencia.getValor(i, j) == true)
						pw.println((i + 1) + " " + (j + 1));
				}
			}
			archivo.close();
		} catch (Exception e) {
			System.out.println("Error de Escritura Archivo de Salida - " + e.getMessage());
		} finally {
			if (null != archivo) {
				try {
					archivo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void calcularGrado() {
		// TODO Auto-generated method stub

	}
}
