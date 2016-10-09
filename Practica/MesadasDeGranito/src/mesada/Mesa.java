package mesada;

public class Mesa implements Comparable<Mesa>{
	private int pos1;
	private int pos2;

	public Mesa(int x, int y) {
		if (x >= y) {
			setPos2(y);
			setPos1(x);
		} else {
			setPos2(x);
			setPos1(y);
		}
	}

	public int getPos1() {
		return pos1;
	}

	public void setPos1(int x) {
		this.pos1 = x;
	}

	public int getPos2() {
		return pos2;
	}

	public void setPos2(int y) {
		this.pos2 = y;
	}

	public String toString(){
		return this.pos1+" "+this.pos2;
	}

	public int compareTo(Mesa mesa) {
		if(this.pos1<mesa.pos1)
			return 1;
		else{
			if(this.pos1>mesa.pos1){
				return -1;
			}
		}
		return 0;
	}
}
