import java.util.Vector;

public class Client {
    private String nif;
    private String nom;
    private String telefon;
    private Vector<Lloguer> lloguers;
    private static final double EUROS_PER_UNITAT_COST = 30;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new Vector<Lloguer>();
    }

    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
	    public void afegeix(Lloguer lloguer) {
        if (! lloguers.contains(lloguer) ) {
            lloguers.add(lloguer);
        }
    }
    public void elimina(Lloguer lloguer) {
        if (lloguers.contains(lloguer) ) {
            lloguers.remove(lloguer);
        }
    }
    public boolean conte(Lloguer lloguer) {
        return lloguers.contains(lloguer);
    }

	public Vector<Lloguer> getLloguers (){
		return lloguers;
	}
    
	public int totalLloguers(Client c) {
		int num = c.getLloguers().size();
		return num;
	}
	
	// Del m�tode informe en general podem aprofitar tot el codi , encara que falta modificar algunes coses
	// per a reaprofitar-ho al usar-ho en m�todes.
	
	public String informe() {
	    return composaCapsalera() +
	    		composaDetall() +
	    		composaPreu(); 		
	}
	
	
	public String informeHTML() {
		return composaCapsaleraHTML()+
				composaDetallHTML()+
				composaPreuHTML();
	}
	
	public String composaCapsaleraHTML() {
		
		String resultat = "<h1> Informe de lloguers </h1>\n"+
				"<p> Informe de lloguers del client <em> "+ getNom() +"</em> ( <strong>" + getNif() + "</strong> ) </p>\n";
		return resultat;
	}
	
	public String composaDetallHTML() {
		String resultat = "<table>\n"+
		"<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>\n";
		for (Lloguer lloguer : lloguers) {
			resultat+="\t<tr><td>"+lloguer.getVehicle().getMarca()+"</td><td>"+lloguer.getVehicle().getMarca()+"</td><td>"+(lloguer.quantitat() * EUROS_PER_UNITAT_COST)+"</td></tr>\n";
		}
		resultat += "</table>\n";
		return resultat;
	}
	
	public String composaPreuHTML() {
		String resultat = "<p>Import a pagar: <em>" + importTotal() +"</em></p>\n";
		resultat += "<p> Punts guanyats: <em>"+bonificacionsTotals()+"</em></p>\n";
		return resultat;
	}
	
	//Preu de tots els lloguers d'un client
	public double importTotal() {
		double total = 0;
		for (Lloguer lloguer:lloguers) { //Calcula el total de cada cotxe i suma al total
			double preu = lloguer.quantitat();
			total += preu * EUROS_PER_UNITAT_COST;
		}
		return total;
	}
	
	public int bonificacionsTotals() {
		int bonificacions = 0;
		for (Lloguer lloguer:lloguers) {
			bonificacions += lloguer.bonificacions();
		}
		return bonificacions;
	}
	
	public String composaCapsalera() {
	    String resultat = "Informe de lloguers del client " +
		        getNom() +
		        " (" + getNif() + ")\n";
		return resultat;
	}
	public String composaDetall() {
		int bonificacions = 0;
		String resultat = "";
	    for (Lloguer lloguer:lloguers) {
	    	bonificacions += lloguer.bonificacions();
	        resultat += "\t" +
	                lloguer.getVehicle().getMarca() +
	                " " +
	                lloguer.getVehicle().getModel() + ": " +
	                (lloguer.quantitat() * EUROS_PER_UNITAT_COST) + "�" + "\n";
	    }
		
		return resultat;
	}
	public String composaPreu() {
		String resultat;
	    resultat = "Import a pagar: " + importTotal() + "�\n" +
		        "Punts guanyats: " + bonificacionsTotals() + "\n";
	    return resultat;
	}
	
	
}
