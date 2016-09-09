package edu.unlam.progra.test;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.unlam.progra.tp2.Probador;
import junit.framework.Assert;

public class ProbadorTest {


	@SuppressWarnings("deprecation")
	@Test
	public void Probadortest() throws FileNotFoundException {
		Probador p = new Probador("pruebaDeterminado.in","test/pruebas/resultGauss1.in");
		Assert.assertTrue(p.probarResultado());
	}
}
