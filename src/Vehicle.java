public class Vehicle {

	private String model;
	private String marca;
	private int categoria;
	
	public static final int BASIC = 0;
	public static final int GENERAL = 1;
	public static final int LUXE = 2;

	
	Vehicle(String model,String marca,int categoria) {
		this.model = model;
		this.marca = marca;
		this.categoria = categoria;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	
	
}
