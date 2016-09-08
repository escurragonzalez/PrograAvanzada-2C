package selMath;

import java.util.*;
import java.io.*;

public class SEL {

	private MatrizMath a;
	private VectorMath x;
	private VectorMath b;

	public SEL(String archivo) throws FileNotFoundException {

		Scanner sc = new Scanner(new File(archivo));

		int tama�oSistema = sc.nextInt();

		this.a = new MatrizMath(tama�oSistema, tama�oSistema);
		this.b = new VectorMath(tama�oSistema);
		this.x = new VectorMath(tama�oSistema);

		for (int i = 0; i < tama�oSistema; i++)
			for (int j = 0; j < tama�oSistema; j++)
				this.a.setValorDeMatriz(sc.nextInt(), sc.nextInt(), sc.nextDouble());

		for (int i = 0; i < tama�oSistema; i++)
			this.b.setValorVectorMath(i, sc.nextDouble());

		sc.close();
	}

	public void resolver() throws DistintaDimensionException {

		VectorMath x = this.b.multiplicacion(this.a.inversa());

		this.x.setVector(x.getVector());

	}

	private double cacluloErrorSolucion() throws DistintaDimensionException {

		return this.b.resta(this.a.multiplicacion(this.x)).normaDos();
		// return this.b.restar(this.x.multiplicar(this.a)).normaDos();

	}

	public static void main(String[] args) throws FileNotFoundException, DistintaDimensionException {
		Locale.setDefault(new Locale("en", "us"));
		SEL sel = new SEL("02_caso01_levementePeturbado.in");
		Calendar tIni = new GregorianCalendar();
		sel.resolver();
		System.out.println(sel.cacluloErrorSolucion());
		Calendar tFin = new GregorianCalendar();

		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		System.out.println("Tiempo: " + diff);
		System.out.println(sel.x);

	}

}
