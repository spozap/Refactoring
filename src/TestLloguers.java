import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.*;

public class TestLloguers {

	@Test
	public void testClient() throws ParseException {
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
		String a = "Informe de lloguers del client Sergi (43583822H)\r\n" + 
				"	Verlingo Citroen: 1080.0€\r\n" + 
				"	Dokker Dacia: 2220.0€\r\n" + 
				"	Model Y Tesla: 3240.0€\r\n" + 
				"Import a pagar: 6540.0€\r\n" + 
				"Punts guanyats: 1";
		String test = c1.informe();
		assertEquals(a,test);
		System.out.println(c1.informe());

	}
	
}
