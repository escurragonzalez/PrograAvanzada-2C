package tp4;

public class GeneradorRegularGrado extends Generador {

	private int grado;

	public GeneradorRegularGrado(int nodos, int grado) {
		super(nodos);
		this.grado = grado;
		generarMatriz();
	}

	public void calcularGrado() {
		setGradoMinima(this.grado);
		setGradoMaximo(this.grado);
	}

	public void calcularPorcentajeAdyacencia(){
		double porcAdy=0;
		porcAdy=this.grado/(double)(this.getCantNodos()-1);
		setPorcAdyacencia(porcAdy);
	}

	private void generarMatriz() {

		int recorrido = grado / 2;
		int salto = 1;
		int cont=0;

		if (grado % 2 == 0) {
			for (int i = 0; i < recorrido; i++) {
				for (int j = 0; j < getCantNodos() - 1; j++) {
					if (j + salto < getCantNodos())
						getMatrizDeAdyacencia().setValor(j, j + salto, true);
					else
						getMatrizDeAdyacencia().setValor(j, i - 1, true);
					cont++;
				}
				getMatrizDeAdyacencia().setValor(getCantNodos() - salto, salto - 1, true);
				salto++;
				cont++;
			}
		} else {

		}
		setCantAristas(cont);
	}

}
