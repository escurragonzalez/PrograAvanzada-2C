package tarzan;

import java.io.File;
import java.io.FileNotFoundException;
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
		
		dfs.resolver(arboles.get(0).getOrden(),arboles.get(nodos-1).getOrden());
		
	}
	
	
}
