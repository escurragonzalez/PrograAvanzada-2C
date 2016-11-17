package arbol;

import java.awt.geom.RectangularShape;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Arbol {

	private DFS dfs;
	private int nodos;
	private int aristas;
	private int raiz;
	private int[][] matAdyacencia;
	private static int NO_ARISTA = 9999;
	private int[] acum;
	private boolean cumpleReglaDos;
	private boolean cumpleReglaTres;
	private boolean cumpleReglaUno;

	public Arbol(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path));
		nodos = sc.nextInt();
		aristas = sc.nextInt();
		acum = new int[nodos];
		int origen, destino;
		matAdyacencia = new int[nodos][nodos];
		inicializarMat();
		dfs = new DFS(nodos);
		for (int i = 0; i < aristas; i++) {
			origen = sc.nextInt() - 1;
			destino = sc.nextInt() - 1;
			acum[destino]++;
			matAdyacencia[origen][destino] = 1;
			matAdyacencia[destino][origen] = 1;
		}
		sc.close();
	}

	private void inicializarMat() {
		for (int i = 0; i < matAdyacencia.length; i++) {
			for (int j = 0; j < matAdyacencia.length; j++) {
				matAdyacencia[i][j] = NO_ARISTA;
			}
		}
	}

	public void resolver(int nodo) {
		dfs.busquedaProfundidad(matAdyacencia, nodo);
	}

	public static void main(String[] args) throws IOException {
		Arbol a = new Arbol("entrada.in");
		a.hallarRaiz();
		a.resolver(a.raiz);
//		for (int i = 0; i < a.nodos; i++) {
//			System.out.println(a.acum[i]);
//		}
		a.escribirArchivo("salida.out");
	}

	private void escribirArchivo(String string) throws IOException {
		PrintWriter p = new PrintWriter(new FileWriter(string));
		if (this.cumpleReglaUno && this.cumpleReglaDos && this.cumpleReglaTres) {
			p.println("SI "+raiz);
		}else{
			p.println("NO");
			p.println(this.reglaUno());
			p.println(this.reglaDos());
			p.println(this.reglaTres());
		}
		p.close();
	}

	private String reglaTres() {	
		cumpleReglaTres=true;
		String returnValue="";
		for (int i = 0; i < acum.length; i++) {
			if(this.dfs.getEstados()[i]!=0){
				cumpleReglaTres=false;
				returnValue += String.valueOf(i + 1) + " ";
			}
		}
		return returnValue;
	}

	public String reglaDos() {
		// Cada nodo, exceptuando la raíz, tiene exactamente un único arco
		// apuntando hacia él.
		String returnValue = "";
		cumpleReglaDos = true;
		for (int i = 0; i < acum.length; i++) {
			if (acum[i] > 1) {
				returnValue += String.valueOf(i + 1);
				cumpleReglaDos = false;
			}
		}
		return cumpleReglaDos ? String.valueOf(0) : returnValue;
	}

	public void hallarRaiz(){
		for (int i = 0; i < acum.length; i++)
			if (acum[i] == 0)
				raiz=i;
	}
	
	public String reglaUno() {
		String returnValue = "";
		cumpleReglaUno = false;
		int c = 0;
		for (int i = 0; i < acum.length; i++) {
			if (acum[i] == 0) {
				returnValue += String.valueOf(i + 1) + " ";
				c++;
			}
		}
		if (c == 0) {
			cumpleReglaUno = false;
			return "0";
		} else {
			if (c == 1) {
				cumpleReglaUno = true;
			}
			return returnValue;
		}
	}
}
