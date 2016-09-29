package latas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProcesarLatas {

	private Latas lat;

	public Latas getLat() {
		return lat;
	}

	public void setLat(Latas lat) {
		this.lat = lat;
	}

	public void leerArchivo(String path) throws FileNotFoundException{

		Scanner sc= new Scanner(new File(path));
		String linea =sc.nextLine();
		lat = new Latas(linea);
		sc.close();
	}

	public void escribir(String s) throws IOException{
		PrintWriter pw = new PrintWriter(new FileWriter(s));
		pw.println(lat.getCantTotal());
		pw.println(lat.getContMaximoLatas());
		pw.println(lat.getContMaximo2Latas());
		pw.println(lat.getDistancia());
		pw.close();
	}
}
