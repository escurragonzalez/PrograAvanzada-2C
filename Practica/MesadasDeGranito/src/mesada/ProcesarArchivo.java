package mesada;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProcesarArchivo {

	private Mesada mesada;
	private Mesa mesa;

	public ProcesarArchivo() throws IOException{
		leerArchivo("mesada01.in");
		procesar();
		escribirArchivo("salida.out");
	}

	private void procesar() {
		mesada.procesarMesadas();
	}

	public void leerArchivo(String path) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(path));
		mesada = new Mesada(sc.nextInt());
		int l,a;
		for (int i = 0; i < mesada.getCantidadMesadas(); i++) {
			l=sc.nextInt();
			a=sc.nextInt();
			mesa = new Mesa(l,a);
			mesada.getLista().add(mesa);
		}
		sc.close();
	}

	public void escribirArchivo(String archivo) throws IOException{
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		salida.println(mesada.result);
		salida.close();
	}
}
