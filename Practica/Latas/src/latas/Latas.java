package latas;

import javax.xml.crypto.dsig.CanonicalizationMethod;

public class Latas {

	private int contMaximoLatas;
	private int contMaximo2Latas;
	private int cantTotal;
	private int distancia;
	private String secuencia;

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getCantTotal() {
		return cantTotal;
	}

	public void setCantTotal(int cantTotal) {
		this.cantTotal = cantTotal;
	}

	public int getContMaximoLatas() {
		return contMaximoLatas;
	}

	public void setContMaximoLatas(int contMaximoLatas) {
		this.contMaximoLatas = contMaximoLatas;
	}

	public int getContMaximo2Latas() {
		return contMaximo2Latas;
	}

	public void setContMaximo2Latas(int contMaximo2Latas) {
		this.contMaximo2Latas = contMaximo2Latas;
	}

	public String getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}

	public Latas(String sec) {
		this.secuencia = sec;
		this.cantTotal = sec.length();
		this.distancia = 0;
		this.contMaximo2Latas = 0;
		this.contMaximoLatas = 0;
	}

	public void resolver() {
		int contAuxSecuencia = 0;
		int posSec = 0;
		int posM1 = 0;
		int posM2 = 0;
		char secuencia[] = this.secuencia.toCharArray();
		for (int i = 0; i < this.cantTotal; i++) {
			if (secuencia[i] == 'G') {
				posSec = i;
				contAuxSecuencia=1;
			}
			while (secuencia[i] == 'G' && secuencia[i + 1] == 'G') {
				contAuxSecuencia++;
				i++;
			}

			if (contAuxSecuencia > contMaximoLatas) {
				contMaximo2Latas = contMaximoLatas;
				contMaximoLatas = contAuxSecuencia;
				posM2 = posM1;
				posM1 = posSec;
			}

			if (contAuxSecuencia > contMaximo2Latas && contAuxSecuencia < contMaximoLatas) {
				contMaximo2Latas = contAuxSecuencia;
				posM2 = posSec;
			}
		}
		if(posM2<posM1)
			this.distancia=posM1-(posM2+contMaximo2Latas);
		else
			this.distancia=posM2-(posM1+contMaximoLatas);
	}
}