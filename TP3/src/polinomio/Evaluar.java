package polinomio;
import java.util.GregorianCalendar;
import java.util.Calendar;

import java.io.*;
import java.util.*;

public class Evaluar {

	private Polinomio polinomio;
	private double valor;

	public void leerPolinomio(String archivo,String archSalida) throws IOException {

		Scanner scanner = new Scanner(new File(archivo));
		int grado = scanner.nextInt();
		double[] coeficientes = new double[grado+1];
		for (int idx = 0; idx < coeficientes.length; idx++) {
			coeficientes[idx] = scanner.nextDouble();
		}
		this.polinomio = new Polinomio(grado, coeficientes);
		this.valor = scanner.nextDouble();
		scanner.close();

		Calendar tIni = new GregorianCalendar();
		double r = polinomio.evaluarRecursivaSinConsiderar(valor);
		Calendar tFin = new GregorianCalendar();

		long diff = tFin.getTimeInMillis();
		diff= diff-tIni.getTimeInMillis();

		System.out.println(diff);

//		escribirResultado(r,archSalida);
	}

	private void escribirResultado(double r,String archSalida) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(archSalida));
		salida.println(r);
		salida.close();
	}
}
