package test;

import org.junit.Ignore;
import org.junit.Test;

import ar.com.unlam.tda.Punto;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class PuntoTest {

	@Ignore
	public void toStringTest() {
		Punto p = new Punto(2,2);
		System.out.println(p);
	}
	
	@Test
	public void desplazarTest(){
		Punto p = new Punto();
		Punto p2 = new Punto(1,2);
		Assert.assertEquals("1.0 2.0",p.desplazamiento(p2));
	}
}
