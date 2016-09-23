package stock;

public class Stock {

	//private List<Producto> productitos;

	private static Stock instance = new Stock();	// el atributo que es el objeto unico

	private Stock(){	// constructor privado

	}

	public static Stock getInstance(){
		return instance;
	}
}
