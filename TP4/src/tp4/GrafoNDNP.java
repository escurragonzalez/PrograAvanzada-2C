package tp4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class GrafoNDNP {

	private MatrizSimetrica matriz;
	int[] nodosColoreados;
	int[] nodosSecuenciales;
	int cantidadAristas;
	double porcentaje;
	int gradoMax, gradoMin;

	public GrafoNDNP(String archivo) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(archivo));
		matriz = new MatrizSimetrica(scanner.nextInt());
		cantidadAristas = scanner.nextInt();
		porcentaje = scanner.nextDouble();
		gradoMax = scanner.nextInt();
		gradoMin = scanner.nextInt();

		nodosColoreados = new int[matriz.getCantNodos()];
		nodosSecuenciales = new int[matriz.getCantNodos()];
		while (scanner.hasNext()) {
			matriz.setValor(scanner.nextInt(), scanner.nextInt(), true);
		}
		scanner.close();
	}

	public void generarVectorAleatorio() {
		Random random = new Random();
		int nro1, nro2, aux;

		for (int i = 0; i < nodosSecuenciales.length; i++)
			nodosSecuenciales[i] = i;

		for (int i = 0; i < nodosSecuenciales.length; i++) {
			nro1 = random.nextInt(matriz.getCantNodos());
			nro2 = random.nextInt(matriz.getCantNodos());

			aux = nodosSecuenciales[nro1];
			nodosSecuenciales[nro1] = nodosSecuenciales[nro2];
			nodosSecuenciales[nro2] = aux;
		}
	}

	public void SecuenciaAleatorio() {

		int[] vectorColores = new int[matriz.getCantNodos()];
		for (int i = 0; i < nodosColoreados.length; i++) {
			vectorColores[i] = i;
		}

		for (int i = 0; i < nodosSecuenciales.length; i++) {
			if (i == 0)
				nodosColoreados[nodosSecuenciales[i]] = vectorColores[i];
			else {
				
			}

		}

	}

	private boolean noExisteElNumero(int nro) {

		for (int i = 0; i < this.nodosColoreados.length; i++)
			if (nodosColoreados[i] == nro)
				return false;

		return true;
	}

}
