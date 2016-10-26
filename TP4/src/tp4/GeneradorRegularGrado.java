package tp4;

import java.util.ArrayList;
import java.util.Collections;

public class GeneradorRegularGrado extends Generador {

	private int grado;

	public GeneradorRegularGrado(int nodos, int grado) {
		super(nodos);
		this.grado = grado;
		generarMatriz();
	}

	private void generarMatriz() {

		int recorrido = grado / 2;
		int salto = 1;

		if (grado % 2 == 0)
			for (int i = 0; i < recorrido; i++) {
				for (int j = 0; j < getCantNodos() - 1; j++) {
					if (j + salto < getCantNodos())
						getMatrizDeAdyacencia().setValor(j, j + salto, true);
					else
						getMatrizDeAdyacencia().setValor(j, i - 1, true);
				}
				getMatrizDeAdyacencia().setValor(getCantNodos() - salto,
						salto - 1, true);
				salto++;

			}
		else {

		}
	}

}
