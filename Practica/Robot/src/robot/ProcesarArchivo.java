package robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProcesarArchivo {

	private Robot robot;


	private void procesar() {
		robot.procesar();
	}

	public void leerArchivo(String path) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(path));
		int posX = sc.nextInt();
		int posY = sc.nextInt();
		String dir = sc.next();
		int orient=0;
		if(dir.charAt(0)=='N'){
			orient=0;
		}
		if(dir.charAt(0)=='E'){
			orient=1;
		}
		if(dir.charAt(0)=='S'){
			orient=2;
		}
		if(dir.charAt(0)=='O'){
			orient=3;
		}
		robot = new Robot(posX, posY,orient , sc.nextInt(), sc.nextInt(),sc.next());
		sc.close();
	}

	public void escribirArchivo(String archivo) throws IOException{
		PrintWriter salida = new PrintWriter(new FileWriter(archivo));
		salida.println(robot.getPosX()+" "+robot.getPosY());
		salida.close();
	}
	
	public static void main(String[] args) throws IOException {
		ProcesarArchivo p = new ProcesarArchivo();
		p.leerArchivo("robot.in");
		p.procesar();
		p.escribirArchivo("salida.out");
	}
}