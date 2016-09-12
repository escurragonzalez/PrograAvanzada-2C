package edu.unlam.progra.test;

import java.io.FileNotFoundException;

import org.junit.*;

import edu.unlam.progra.tp2.Probador;

public class ProbadorTest {

	@Test
	public void Probadortest() throws FileNotFoundException {
		Probador p = new Probador("Matriz50.in", "Matriz50.out");
		Assert.assertTrue(p.probarResultado());
	}
}
