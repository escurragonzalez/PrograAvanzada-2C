package libro;

public class Libro {

	// Complejidad computacional N*N
	private int cant;
	private int[] alturas;
	private int result;

	public Libro(int cant, int[] vec) {
		this.cant = cant;
		this.alturas = vec;
	}

	// Complejidad computacional N
	// public void procesar() {
	// int imp,menor;
	// int posASacar=0;
	// if(alturas.length==1){
	// this.result=1;
	// return;
	// }
	// if(this.cant==2){
	// this.result=2;
	// return;
	// }
	// menor=Integer.MAX_VALUE;
	// for (int i = 1; i < alturas.length-1; i++) {
	// imp=Math.abs(alturas[i-1]-alturas[i+1]);
	// if(imp<=menor){
	// menor=imp;
	// posASacar=i;
	// }
	// }
	// this.result=posASacar+1;
	// }

	
	// Complejidad computacional N*N
	public void procesar() {
		int n = 0, pos = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < alturas.length; i++) {
			n = calcularCosto(i);
			if (n < min) {
				min = n;
				pos = i;
			}
		}
		this.result = pos+1;
	}

	private int calcularCosto(int num) {
		int s = 0;
		if (num != 0 && num != alturas.length-1) {
			for (int j = 1; j < alturas.length-1; j++) {
				if (j != num)
					s += Math.abs(alturas[j-1] - alturas[j+ 1]);
			}
		}else if (num==0){
				for (int j = 1; j < alturas.length-1; j++) {
						s += Math.abs(alturas[j - 1] - alturas[j + 1]);
				}
		}else{
			if(num == alturas.length-1)
			for (int j = 1; j < alturas.length-2; j++) {
					s += Math.abs(alturas[j - 1] - alturas[j + 1]);
			}
		}
		return s;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public int[] getAlturas() {
		return alturas;
	}

	public void setAlturas(int[] alturas) {
		this.alturas = alturas;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
