package robot;

public class Robot {

	private int posX;
	private int posY;
	private int dir;
	private int maxX;
	private int maxY;
	private String ordenes;
	//Orientacion 0-Norte; 1-Este; 2-Sur;3-Oeste
	
	
	public Robot(int x,int y,int d,int f,int c, String ord){
		this.posX=x;
		this.posY=y;
		this.dir=d;
		this.ordenes=ord;
		this.maxX=f;
		this.maxY=c;
	}
	
	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}


	public int getDir() {
		return dir;
	}


	public void setDir(char dir) {
		this.dir = dir;
	}

	public String getOrdenes() {
		return ordenes;
	}


	public void setOrdenes(String ordenes) {
		this.ordenes = ordenes;
	}


	public void procesar() {
		char ord;
		String aux;
		int cant;
		for (int i = 0; i < this.ordenes.length(); i+=2) {
			ord=this.ordenes.charAt(i);
			aux=this.ordenes.substring(i+1, i+2);
			cant=Integer.parseInt(aux);
			if(ord=='A'){
				if(this.dir==0){
					desplazarNorte(cant);
				}
				if(this.dir==1){
					desplazarEste(cant);
				}
				if(this.dir==2){
					desplazarSur(cant);
				}
				if(this.dir==3){
					desplazarOeste(cant);
				}
			}else{
				dir=(dir+cant)%4;
			}
		}
	}

	private void desplazarOeste(int cant) {
		while(cant>0 && posX>1){
			cant--;
			posX--;
		}
	}

	private void desplazarSur(int cant) {
		while(cant>0 && posY>1){
			cant--;
			posY--;
		}
	}

	private void desplazarEste(int cant) {
		while(cant>0 && posX<maxX){
			cant--;
			posX++;
		}
	}

	private void desplazarNorte(int cant) {
		while(cant>0 && posY<maxY){
			cant--;
			posY++;
		}
	}
}
