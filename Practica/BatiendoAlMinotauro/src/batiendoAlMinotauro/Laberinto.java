package batiendoAlMinotauro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Laberinto {

	private MatrizSimetrica matriz;
	private int catindadDescansos;
	private ArrayList<Arista> aristas = new ArrayList<Arista>();
	private ArrayList<Arista> solucion = new ArrayList<Arista>();
	private int[] padre;

	public Laberinto(String archivo) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(archivo));
		catindadDescansos = scanner.nextInt();
		matriz = new MatrizSimetrica(catindadDescansos);
		for (int i = 0; i < catindadDescansos; i++) {
			for (int j = 0; j < catindadDescansos; j++) {
				if (i != j)
					matriz.setValor(i, j, scanner.nextInt());
				else
					scanner.nextInt();
			}
		}
	}

	public int find(int x) {
		return (x == padre[x] ? x : find(padre[x]));
	}

	public void union(int x, int y) {
		padre[find(x)] = find(y);
	}

	public ArrayList<Arista> kruskal() {
		Arista arista;
		int costo;
		padre = new int[catindadDescansos];
		for (int i = 0; i < padre.length; i++)
			padre[i] = i;
		for (int i = 0; i < catindadDescansos; i++) {
			for (int j = i; j < catindadDescansos; j++) {
				if (i != j)
					aristas.add(new Arista(i, j, matriz.getValor(i, j)));
			}
		}
		Collections.sort(aristas);
		while (!aristas.isEmpty() && solucion.size() < catindadDescansos - 1) {
			arista = aristas.get(0);
			costo = 0;
			if ((find(arista.getOrigen()) != find(arista.getDestino()))) {
				costo += arista.getCosto();
				arista.setCosto(costo);
				solucion.add(arista);
				union(arista.getOrigen(), arista.getDestino());
				aristas.remove(0);
			} else
				aristas.remove(0);
		}
		return solucion;
	}

	public void escribirArchivo(String path) {
		FileWriter archivo = null;
		PrintWriter pw = null;
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		try {
			archivo = new FileWriter(path);
			pw = new PrintWriter(archivo);
			pw.println(solucion.size());
			for (Arista obj : solucion) {
				pw.println("" + (obj.getOrigen() + 1) + " " + (obj.getDestino() + 1) + " " + obj.getCosto());
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

}
