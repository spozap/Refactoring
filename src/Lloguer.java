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
		if (vehicle.getCategoria() == vehicle.luxe && getDies()>1 ) {
			bonificacions++;
		}
		return bonificacions;
	}
	
	public double calculaQuantitat() {
		
		double quantitat = 0;
		
		if (vehicle.getCategoria()==vehicle.basic) {
            quantitat += 3;
            if (getDies() > 3) {
                quantitat += (getDies() - 3) * 1.5;   
            }
    	} else if (vehicle.getCategoria()==vehicle.general) {
            	quantitat += 4;
            	if (getDies() > 2) {
            		quantitat += (getDies() - 2) * 2.5;
    	}
        } else if (vehicle.getCategoria()==vehicle.luxe) {
            	quantitat += getDies() * 6;
        } 
		return quantitat;
		
	}

	
}
