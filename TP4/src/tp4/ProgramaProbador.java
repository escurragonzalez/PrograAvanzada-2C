package tp4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class ProgramaProbador {

	private MatrizSimetrica matriz;
	private int cantidadAristas;
	private double porcentaje, adyacenciaOut;
	private int gradoMax, gradoMin, cantColoresOut;
	private int nodosOut, aristasOut, gradoMaxOut, gradoMinOut;
	private String salida;

	private void cargarArchivoIn(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(path));
		scanner.useLocale(Locale.ENGLISH);
		matriz = new MatrizSimetrica(scanner.nextInt());
		cantidadAristas = scanner.nextInt();
		porcentaje = scanner.nextDouble();
		gradoMax = scanner.nextInt();
		gradoMin = scanner.nextInt();

		while (scanner.hasNext())
			matriz.setValor(scanner.nextInt() - 1, scanner.nextInt() - 1, true);

		scanner.close();
	}

	public ProgramaProbador(String pathIn, String pathOut) throws FileNotFoundException {
		cargarArchivoIn(pathIn);
		String linea;
		String[] params;
		int nodo,color;

		Scanner sc = new Scanner(new File(pathOut));
		nodosOut = sc.nextInt();
		cantColoresOut = sc.nextInt();
		aristasOut = sc.nextInt();
		adyacenciaOut = sc.nextDouble();
		gradoMaxOut = sc.nextInt();
		gradoMinOut = sc.nextInt();
		if(matriz.getCantNodos()!=nodosOut){
			salida="No todos los nodos fueron pintados";
			return;
		}
		for (int i = 0; i < aristasOut; i++) {

		}
	}

	public void escribirSalida(String path) {
		FileWriter archivo = null;
		PrintWriter pw = null;
		
		try {
			archivo = new FileWriter(path);
			pw = new PrintWriter(archivo);
			pw.println(salida);
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
