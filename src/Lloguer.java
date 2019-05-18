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

	
}
