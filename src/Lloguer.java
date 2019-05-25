import java.util.Date;

public class Lloguer {

	
	private int dies;
	private Date data;
	private Vehicle vehicle;
	private static final int DIES_INICIALS_MATEIX_PREU_BASIC = 3;
	private static final int DIES_INICIALS_MATEIX_PREU_GENERAL = 2;
	private static final int PREU_UNITAT_COST_BASIC = 3;
	private static final int PREU_UNITAT_COST_GENERAL = 4;
	private static final int PREU_UNITAT_COST_LUXE = 6;
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
	
	
	public double quantitat() { // Ja no cal rebre el paràmetre de lloguer perquè ja el sap
		double quantitat = 0;		
		switch (getVehicle().getCategoria()) {
		case Vehicle.BASIC:
            quantitat += PREU_UNITAT_COST_BASIC;
            if (getDies() > DIES_INICIALS_MATEIX_PREU_BASIC) {
                quantitat += (getDies() - DIES_INICIALS_MATEIX_PREU_BASIC) * 1.5;
            }
            break;
		case Vehicle.GENERAL:
            quantitat += PREU_UNITAT_COST_GENERAL;
            if (getDies() > DIES_INICIALS_MATEIX_PREU_GENERAL) {
                quantitat += (getDies() - DIES_INICIALS_MATEIX_PREU_GENERAL) * 2.5;
            }
            break;
		case Vehicle.LUXE:
            quantitat += getDies() * PREU_UNITAT_COST_LUXE;
            break;
		}
		return quantitat;
		
	}
	
	public int bonificacions() {
		int bonificacions = 0;
        if (getVehicle().getCategoria() == Vehicle.LUXE &&getDies()>1 ) {
            bonificacions ++;
        }
        return bonificacions;
	}
			
}

	
