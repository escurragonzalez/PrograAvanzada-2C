package test;

import java.io.IOException;

import org.junit.Test;

import junit.framework.Assert;
import latas.ProcesarLatas;

public class ProcesarLatasTest {

	@Test
	public void test() throws IOException {
		ProcesarLatas p= new ProcesarLatas();
		p.leerArchivo("test\\pruebas\\01.in");
		p.getLat().resolver();
		p.escribir("test\\pruebas\\salida.out");
		Assert.assertNotNull(p);
	}

}
