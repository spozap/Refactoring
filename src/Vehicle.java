public class Vehicle {

	private String model;
	private String marca;
	private tipusVehicle categoria;
	public static  tipusVehicle basic = tipusVehicle.BASIC; // Declarem el cotxe de tipus bàsic
	public static tipusVehicle general = tipusVehicle.GENERAL; // Declarem el cotxe de tipus general
	public static tipusVehicle luxe = tipusVehicle.LUXE; // Declarem el cotxe de luxe
	
	enum tipusVehicle { // Definim que el tipus de vehicle sigui algun dels especificats
		BASIC , GENERAL , LUXE;
	}
	
	Vehicle(String model,String marca,tipusVehicle t){
		this.model = model;
		this.marca = marca;
		this.categoria = t;
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

	public tipusVehicle getCategoria() {
		return categoria;
	}

	public void setCategoria(tipusVehicle categoria) {
		this.categoria = categoria;
	}

	
	
}
