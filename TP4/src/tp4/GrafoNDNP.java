package tp4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class GrafoNDNP {

	private MatrizSimetrica matriz;
	private int[] nodosColoreados;
	private int cantidadAristas;
	private double porcentaje;
	private int gradoMax, gradoMin;
	private ArrayList<Integer> nodosSecuencia;

	public GrafoNDNP(String archivo) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File(archivo));
		scanner.useLocale(Locale.ENGLISH);
		matriz = new MatrizSimetrica(scanner.nextInt());
		cantidadAristas = scanner.nextInt();
		porcentaje = scanner.nextDouble();
		gradoMax = scanner.nextInt();
		gradoMin = scanner.nextInt();

		nodosColoreados = new int[matriz.getCantNodos()];
		nodosSecuencia = new ArrayList<Integer>();
		while (scanner.hasNext())
			matriz.setValor(scanner.nextInt() - 1, scanner.nextInt() - 1, true);

		scanner.close();
	}

	public void generarVectorAleatorio() {
		for (int i = 0; i < nodosColoreados.length; i++)
			nodosSecuencia.add(i);
		final long seed = System.nanoTime();
		Collections.shuffle(nodosSecuencia, new Random(seed));
	}

	public int colorAPoner(ArrayList<Integer> color, ArrayList<Integer> auxiliar) {
		int indice = 0;
		if (color.size() == auxiliar.size())
			return color.size() + 1;

		Collections.sort(auxiliar);
		while (indice != color.size() && indice != auxiliar.size()) {
			if (color.get(indice) != auxiliar.get(indice))
				return color.get(indice);
			indice++;
		}
		if (indice != color.size())
			return color.get(indice);
		return 0;
	}

	public void SecuenciaAleatorio() {
		int indice;
		ArrayList<Integer> color = new ArrayList<Integer>();
		ArrayList<Integer> auxiliar = new ArrayList<Integer>();

		generarVectorAleatorio();
		for (int i = 0; i < nodosSecuencia.size(); i++) {
			if (i == 0) {
				color.add(1);
				nodosColoreados[nodosSecuencia.get(i)] = color.get(0);
			} else {
				for (int j = 0; j < matriz.getCantNodos(); j++) {
					if (j != nodosSecuencia.get(i) && matriz.getValor(j, nodosSecuencia.get(i)) == true) {
						if (nodosColoreados[j] != 0) {
							indice = 0;
							while (indice != color.size() && color.get(indice) != nodosColoreados[j])
								indice++;
							if (indice != color.size() && color.get(indice) == nodosColoreados[j]
									&& !auxiliar.contains(color.get(indice)))
								auxiliar.add(color.get(indice));
						}
					}
				}
				if (auxiliar.isEmpty())
					nodosColoreados[nodosSecuencia.get(i)] = color.get(0);
				else {
					nodosColoreados[nodosSecuencia.get(i)] = colorAPoner(color, auxiliar);
					if (nodosColoreados[nodosSecuencia.get(i)] == color.size() + 1)
						color.add(color.size() + 1);
					auxiliar.clear();
				}
			}
		}
	}

	public void escribirArchivo(String path) {
		FileWriter archivo = null;
		PrintWriter pw = null;
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		try {
			archivo = new FileWriter(path);
			pw = new PrintWriter(archivo);
			pw.println(matriz.getCantNodos() + " " + this.cantidadAristas + " " + df.format(this.porcentaje) + " "
					+ this.gradoMax + " " + this.gradoMin);
			for (int i = 0; i < nodosColoreados.length; i++)
				pw.println((nodosSecuencia.get(i) + 1) + " " + nodosColoreados[nodosSecuencia.get(i)]);

			archivo.close();
		} catch (

		Exception e) {
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
