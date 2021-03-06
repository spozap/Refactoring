import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.*;

public class TestLloguers {

	@Test
	public void testClient() throws ParseException {
		Client c1 = new Client("43583822H","Sergi","654231987");
		
		Vehicle vehicle1 = new Vehicle("Citroen","Verlingo", Vehicle.BASIC);
		Vehicle vehicle2 = new Vehicle("Dacia","Dokker", Vehicle.GENERAL);
		Vehicle vehicle3 = new Vehicle("Tesla","Model Y",Vehicle.LUXE);

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
		String a = "Informe de lloguers del client Sergi (43583822H)\n" + 
				"\tVerlingo Citroen: 1080.0�\n" + 
				"\tDokker Dacia: 2220.0�\n" + 
				"\tModel Y Tesla: 3240.0�\n" + 
				"Import a pagar: 6540.0�\nPunts guanyats: 1\n";
		String test = c1.informe();
		assertEquals(a,test);
	}
	
	@Test
	public void testClientSenseLloguer() {
		Client c1 = new Client("4564545H","Borja","789456123");		
		String as = c1.informe();
		
		String resultat = "Informe de lloguers del client Borja (4564545H)\n";
		resultat+="Import a pagar: 0.0�\n"; 
		resultat +="Punts guanyats: 0\n";
		assertEquals(as,resultat);
		
	}
	
	@Test
	public void testClientAmbUnLloguer() throws ParseException {
		
		Client c1 = new Client ("43583822H","Sergi","789456123");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date data1 = dateFormat.parse("2/11/1999");
		
		Vehicle vehicle1 = new Vehicle("Citroen","Verlingo", Vehicle.BASIC);
		
		Lloguer lloguer1 = new Lloguer(15,data1);
		lloguer1.llogaCotxe(vehicle1);		
		c1.afegeix(lloguer1);
		
		String informe = c1.informe();
		
		String output="Informe de lloguers del client Sergi (43583822H)\n"+
		"\tVerlingo Citroen: 630.0�\n"+
		"Import a pagar: 630.0�\n"+
		"Punts guanyats: 0\n";
		assertEquals(output,informe);
		
	}
	
	@Test
	public void testClientambVariosLloguers() throws ParseException {
		
		Client c1 = new Client("43583822H","Sergi","789456231");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date data1 = dateFormat.parse("2/11/1999");
		Date data2 = dateFormat.parse("3/6/2019");
		
		Lloguer lloguer1 = new Lloguer(30,data1);
		Lloguer lloguer2 = new Lloguer(23,data2);
		
		Vehicle vehicle1 = new Vehicle("Citroen","Verlingo", Vehicle.BASIC);
		Vehicle vehicle2 = new Vehicle("Seat","Ibiza",Vehicle.GENERAL);
		
		lloguer1.llogaCotxe(vehicle1);
		lloguer2.llogaCotxe(vehicle2);
		c1.afegeix(lloguer1);
		c1.afegeix(lloguer2);
		
		String output = "Informe de lloguers del client Sergi (43583822H)\n"+
				"\tVerlingo Citroen: 1305.0�\n"+
				"\tIbiza Seat: 1695.0�\n"+
			"Import a pagar: 3000.0�\n"+
			"Punts guanyats: 0\n";
		String funcio = c1.informe();
		assertEquals(output,funcio);
	}
	
	public void testClientAmbVariosLloguersHTML() throws ParseException {
		
		Client c1 = new Client("43583822H","Sergi","789456231");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date data1 = dateFormat.parse("2/11/1999");
		Date data2 = dateFormat.parse("3/6/2019");
		
		Lloguer lloguer1 = new Lloguer(30,data1);
		Lloguer lloguer2 = new Lloguer(23,data2);
		
		Vehicle vehicle1 = new Vehicle("Citroen","Verlingo", Vehicle.BASIC);
		Vehicle vehicle2 = new Vehicle("Seat","Ibiza",Vehicle.GENERAL);
		
		lloguer1.llogaCotxe(vehicle1);
		lloguer2.llogaCotxe(vehicle2);
		c1.afegeix(lloguer1);
		c1.afegeix(lloguer2);
		
		String output = "<h1> Informe de lloguers </h1>\n"+
		"<p> Informe de lloguers del client <em> Sergi</em> ( <strong>43583822H</strong> ) </p>\n"+
		"<table>\n"+
		"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>\n"+
			"\t<tr><td>Verlingo</td><td>Citroen</td><td>1305.0</td></tr>\n"+
			"\t<tr><td>Ibiza</td><td>Seat</td><td>1695.0</td></tr>\n"+
		"</table>\n"+
		"<p>Import a pagar: <em>3000.0</em></p>\n<p> Punts guanyats: <em>0</em></p>\n";		
		String informe = c1.informe();
		assertEquals(output,informe);

	}
	
	@Test
	public void testLloguerVehicleLuxeAmbUnDia() throws ParseException {
		Client c1 = new Client("43583822H","Sergi","789456231");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date data1 = dateFormat.parse("2/11/1999");
		
		Lloguer lloguer1 = new Lloguer(1,data1);
		Vehicle vehicle1 = new Vehicle("Tesla","Model Y",Vehicle.LUXE);
		lloguer1.llogaCotxe(vehicle1);
		c1.afegeix(lloguer1);
		String informe = c1.informe();
		String output = "Informe de lloguers del client Sergi (43583822H)\n"+
				"\tModel Y Tesla: 180.0�\n"+
				"Import a pagar: 180.0�\n"+
				"Punts guanyats: 0\n";
		String output2 = "<h1> Informe de lloguers </h1>\n"+
		"<p> Informe de lloguers del client <em> Sergi</em> ( <strong>43583822H</strong> ) </p>\n"+
		"<table>\n"+
		"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>\n"+
			"\t<tr><td>Tesla</td><td>Model Y</td><td>180.0</td></tr>\n"+
		"</table>\n"+
		"<p>Import a pagar: <em>180.0</em></p>\n<p> Punts guanyats: <em>0</em></p>\n";
		assertEquals(output,informe);
	}
	
	@Test
	public void testLloguerVehicleLuxeAmbDosDies() throws ParseException {
		Client c1 = new Client("43583822H","Sergi","789456231");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date data1 = dateFormat.parse("2/11/1999");
		
		Lloguer lloguer1 = new Lloguer(1,data1);
		Vehicle vehicle1 = new Vehicle("Tesla","Model Y",Vehicle.LUXE);
		lloguer1.llogaCotxe(vehicle1);
		c1.afegeix(lloguer1);
		String funcio = c1.informe();
		String output = "Informe de lloguers del client Sergi (43583822H)\n"+
				"\tModel Y Tesla: 180.0�\n"+
				"Import a pagar: 180.0�\n"+
				"Punts guanyats: 0\n";
		assertEquals(output,funcio);
	}
	
	public void testLloguerVehicleLuxeAmbUnDiaHTML() throws ParseException {
		Client c1 = new Client("43583822H","Sergi","789456231");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date data1 = dateFormat.parse("2/11/1999");
		
		Lloguer lloguer1 = new Lloguer(1,data1);
		Vehicle vehicle1 = new Vehicle("Tesla","Model Y",Vehicle.LUXE);
		lloguer1.llogaCotxe(vehicle1);
		c1.afegeix(lloguer1);
		String informe = c1.informe();
		String output = "<h1> Informe de lloguers </h1>\n"+
		"<p> Informe de lloguers del client <em> Sergi</em> ( <strong>43583822H</strong> ) </p>\n"+
		"<table>\n"+
		"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>\n"+
			"\t<tr><td>Tesla</td><td>Model Y</td><td>180.0</td></tr>\n"+
		"</table>\n"+
		"<p>Import a pagar: <em>180.0</em></p>\n<p> Punts guanyats: <em>0</em></p>\n";
		assertEquals(output,informe);
	}
	
	@Test
	public void testLloguerVehicleGeneralAmbUnDia() throws ParseException {
		Client c1 = new Client("43583822H","Sergi","789456231");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date data1 = dateFormat.parse("2/11/1999");
		
		Lloguer lloguer1 = new Lloguer(1,data1);
		Vehicle vehicle1 = new Vehicle("Citroen","Verlingo", Vehicle.GENERAL);
		lloguer1.llogaCotxe(vehicle1);
		c1.afegeix(lloguer1);
		
		String funcio = c1.informe();
		String output = "Informe de lloguers del client Sergi (43583822H)\n"+
				"\tVerlingo Citroen: 120.0�\n"+
				"Import a pagar: 120.0�\n"+
				"Punts guanyats: 0\n";
		assertEquals(output,funcio);
	}
	
	@Test
	public void testLloguerVehicleGeneralAmbUnDiaHTML() throws ParseException {
		
		Client c1 = new Client("43583822H","Sergi","789456231");
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Date data1 = dateFormat.parse("2/11/1999");
		
		Lloguer lloguer1 = new Lloguer(1,data1);
		Vehicle vehicle1 = new Vehicle("Citroen","Verlingo", Vehicle.GENERAL);
		lloguer1.llogaCotxe(vehicle1);
		c1.afegeix(lloguer1);
		
		String informe = c1.informeHTML();
		String output = "<h1> Informe de lloguers </h1>\n"+
		"<p> Informe de lloguers del client <em> Sergi</em> ( <strong>43583822H</strong> ) </p>\n"+
		"<table>\n"+
		"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>\n"+
			"\t<tr><td>Verlingo</td><td>Verlingo</td><td>120.0</td></tr>\n"+
		"</table>\n"+
		"<p>Import a pagar: <em>120.0</em></p>\n<p> Punts guanyats: <em>0</em></p>\n";
		assertEquals(output,informe);
		
	}
	
	@Test
	public void testClientHTML() throws ParseException {
		
		Client c1 = new Client("43583822H","Sergi","654231987");
		
		Vehicle vehicle1 = new Vehicle("Citroen","Verlingo", Vehicle.BASIC);
		Vehicle vehicle2 = new Vehicle("Dacia","Dokker", Vehicle.GENERAL);
		Vehicle vehicle3 = new Vehicle("Tesla","Model Y",Vehicle.LUXE);

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
		
		c1.informeHTML();
		String informe = c1.informeHTML();
		String output = "<h1> Informe de lloguers </h1>\n"+
		"<p> Informe de lloguers del client <em> Sergi</em> ( <strong>43583822H</strong> ) </p>\n"+
		"<table>\n"+
		"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>\n"+
			"\t<tr><td>Verlingo</td><td>Verlingo</td><td>1080.0</td></tr>\n"+
			"\t<tr><td>Dokker</td><td>Dokker</td><td>2220.0</td></tr>\n"+
			"\t<tr><td>Model Y</td><td>Model Y</td><td>3240.0</td></tr>\n"+
		"</table>\n"+
		"<p>Import a pagar: <em>6540.0</em></p>\n<p> Punts guanyats: <em>1</em></p>\n";
		assertEquals(output,informe);
	}
	public static void main(String[] args) throws ParseException {
		Client c1 = new Client("43583822H","Sergi","654231987");
		
		Vehicle vehicle1 = new Vehicle("Citroen","Verlingo", Vehicle.BASIC);
		Vehicle vehicle2 = new Vehicle("Dacia","Dokker", Vehicle.GENERAL);
		Vehicle vehicle3 = new Vehicle("Tesla","Model Y",Vehicle.LUXE);

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
		
		System.out.println(c1.informeHTML());
	}
	
}
