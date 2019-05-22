import java.util.Date;

public class Lloguer {

	
	private int dies;
	private Date data;
	private Vehicle vehicle;
	Lloguer(int dies, Date data){
		this.setData(data);
		this.setDies(dies);
	}
	
	public int getDies() {
		return dies;
	}

	public void setDies(int dies) {
		this.dies = dies;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public void llogaCotxe(Vehicle v) {
		this.vehicle = v;
	}
	
	
	public void treuLloguer() {
		setVehicle(null);
	}
	
	
	public int bonificacions() {
		// Bonificacions per als vehicles de luxe
		int bonificacions = 0;
		if (vehicle.getCategoria() == vehicle.LUXE && getDies()>1 ) {
			bonificacions++;
		}
		return bonificacions;
	}
	
	public double quantitat() { // Ja no cal rebre el paràmetre de lloguer perquè ja el sap
		double quantitat = 0;		
		switch (getVehicle().getCategoria()) {
		case Vehicle.BASIC:
            quantitat += 3;
            if (getDies() > 3) {
                quantitat += (getDies() - 3) * 1.5;
            }
            break;
		case Vehicle.GENERAL:
            quantitat += 4;
            if (getDies() > 2) {
                quantitat += (getDies() - 2) * 2.5;
            }
            break;
		case Vehicle.LUXE:
            quantitat += getDies() * 6;
            break;
		}
		return quantitat;
		
	}
			
}

	
