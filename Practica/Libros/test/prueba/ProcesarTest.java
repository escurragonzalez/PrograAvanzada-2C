package prueba;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import libro.ProcesarArchivo;

import org.junit.Test;

public class ProcesarTest {

	@Test
	public void test() throws IOException {
		ProcesarArchivo a = new ProcesarArchivo();
		a.leerArchivo("entrada.in");
		a.procesar();
		a.escribirArchivo("salida.in");
	}
}
