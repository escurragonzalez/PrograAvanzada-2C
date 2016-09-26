package test;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

import polinomio.Evaluar;

public class EvaluarTest {

	@Test
	public void test() throws IOException {
		File folder = new File("test/Entrada");
		File[] listOfFiles = folder.listFiles();
		Evaluar e = new Evaluar();
		String fileName= "";
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				fileName=listOfFiles[i].getName();
				fileName=fileName.substring(0, fileName.lastIndexOf("."));
				e.leerPolinomio("test/Entrada/"+fileName+".in","test/Salida/"+fileName+".out");
			}
		}
	}
}
