package red;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConexionRed {

	private Warshall war;
	private char[] result;
	private String file;
	private int cantPedidos;

	public ConexionRed(String path) throws FileNotFoundException {
		file = path;
		Scanner sc = new Scanner(new File(file));
		int inicio, fin;
		char c = ' ';
		// Como no se la cantidad de nodos hasta leer todo el archivo para
		// prodarlo lo deje en un numero arbitrario
		war = new Warshall(25);
		result = new char[25];
		cantPedidos = 0;
		while (c != 'F' && sc.hasNext()) {
			c = sc.next().charAt(0);
			if (c != 'F') {
				inicio = sc.nextInt() - 1;
				fin = sc.nextInt() - 1;
				if (c == 'C') {
					this.war.getMatAdyacencia()[inicio][fin] = 1;
					this.war.getMatAdyacencia()[fin][inicio] = 1;
				}
				if (c == 'P') {
					war.resolver();
					// Resuleve cuando lee para saber si hay camino es por la
					// consigna en ese momoento si hay o no camino
					// no se tiene la info de la red completa, es sobre el paso
					// a paso
					if (this.war.getMatAdyacencia()[inicio][fin] == 1) {
						result[cantPedidos] = 'S';
					} else {
						result[cantPedidos] = 'N';
					}
					cantPedidos++;
					// Para el vector resultado la cantidad de la salida
				}
			}
		}
		sc.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		ConexionRed c = new ConexionRed("entrada.in");
		c.escribirArchivo("salida.out");
	}

	private void escribirArchivo(String path) throws FileNotFoundException {
		PrintWriter p = new PrintWriter(new File(path));
		for (int i = 0; i < this.cantPedidos; i++) {
			p.println(this.result[i]);
		}
		p.close();
	}
}