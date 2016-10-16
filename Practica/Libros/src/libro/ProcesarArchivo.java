package libro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProcesarArchivo {
	
	private Libro libro;

	public void leerArchivo(String path) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(path));
		int cant = sc.nextInt();
		int vec[] =new int[cant];
		for(int i=0;i<cant;i++){
			vec[i]=sc.nextInt();
		}
		libro = new Libro(cant,vec);
		sc.close();
	}
	
	public void procesar(){
		libro.procesar();
	}
	
	public void escribirArchivo(String path) throws IOException{
		PrintWriter p = new PrintWriter(new FileWriter(path));
		p.println(libro.getResult());
		p.close();
	}
}
