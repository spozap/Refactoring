import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorLloguersLite  {

	public static void main(String[] args) throws Exception {
		Client c1 = new Client("43583822H","Sergi","654231987");
		
		Vehicle vehicle1 = new Vehicle("Citroen","Verlingo", Vehicle.basic);
		Vehicle vehicle2 = new Vehicle("Dacia","Dokker", Vehicle.general);
		Vehicle vehicle3 = new Vehicle("Tesla","Model Y",Vehicle.luxe);

		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date data1 = dateFormat.parse("2/11/1999");
		Date data2 = dateFormat.parse("5/10/2017");
		Date data3 = dateFormat.parse("7/9/2019");
		
		Lloguer lloguer1 = new Lloguer(25,data1);
		Lloguer lloguer2 = new Lloguer(30,data2);
		Lloguer lloguer3 = new Lloguer(18,data3);
	
		lloguer1.llogaCotxe(vehicle1);
		lloguer2.llogaCotxe(vehicle2);
		lloguer3.llogaCotxe(vehicle3);
		
		c1.afegeix(lloguer1);
		c1.afegeix(lloguer2);
		c1.afegeix(lloguer3);
		
		System.out.println(c1.informe());
	}
	
	public static void informeLloguers(Client c) {
		
		System.out.println("Client:\t"+c.getNom());
		System.out.println("	"+c.getNif());
		System.out.println("	"+c.getTelefon());
		System.out.println("Lloguers: "+c.totalLloguers(c));
		for (int i =0;i<c.totalLloguers(c);i++) {
			System.out.println("\n");
			System.out.println("Vehicle \n---------------------------------------------");
			System.out.println("Marca: "+c.getLloguers().get(i).getVehicle().getMarca());
			System.out.println("Model: "+c.getLloguers().get(i).getVehicle().getModel());
		}
	}
	
	
	
}
