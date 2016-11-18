package tarzan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tarzan {
	
	private int nodos;
	private ArrayList<Arbol> arboles;
	private DFS dfs;
	
	public Tarzan(String path) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(path));
		int x,y,c=0;
		arboles= new ArrayList<Arbol>();
		while(sc.hasNext()){
			x=sc.nextInt();
			y=sc.nextInt();
			arboles.add(new Arbol(x,y,c));
			c++;
		}
		nodos=c;
		dfs= new DFS(nodos);
		sc.close();
	}
	
	public void resolver(){
		Arbol aux ;
		double costo=0;
		//Carga de datos matriz
		for (int i = 0; i < nodos; i++) {
			aux=arboles.get(i);
			for (int j = i+1; j < nodos; j++) {
				costo = aux.distancia(arboles.get(j));
				if(costo<=50){
					dfs.getMatAdyacencia()[aux.getOrden()][arboles.get(j).getOrden()]=1;
				}else{
					if(costo>50 && costo<=100){
						dfs.getMatAdyacencia()[aux.getOrden()][arboles.get(j).getOrden()]=2;
					}
				}
			}
		}
		//Fin de la carga
		dfs.mostrarMatriz();
		
		dfs.resolver(arboles.get(0).getOrden(),arboles.get(nodos-1).getOrden());
		
	}
	
	public void grabraSolucion(String archivo) throws IOException{
		FileWriter fw = new FileWriter(archivo);
		PrintWriter pw = new PrintWriter(fw);
		for (int i = 0; i < this.getDfs().getPrecedentes().size(); i++) {
			pw.print(" "+arboles.get(this.getDfs().getPrecedentes().get(i)).getX());
			pw.println(" "+arboles.get(this.getDfs().getPrecedentes().get(i)).getY());
		}
		pw.close();
	}

	public int getNodos() {
		return nodos;
	}

	public void setNodos(int nodos) {
		this.nodos = nodos;
	}

	public ArrayList<Arbol> getArboles() {
		return arboles;
	}

	public void setArboles(ArrayList<Arbol> arboles) {
		this.arboles = arboles;
	}

	public DFS getDfs() {
		return dfs;
	}

	public void setDfs(DFS dfs) {
		this.dfs = dfs;
	}
	
	
}
