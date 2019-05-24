import java.util.Vector;

public class Client {
    private String nif;
    private String nom;
    private String telefon;
    private Vector<Lloguer> lloguers;

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
	    int bonificacions = 0;
	    String resultat = "Informe de lloguers del client " +
	        getNom() +
	        " (" + getNif() + ")\n";
	    
	    for (Lloguer lloguer:lloguers) {
	    	double quantitat = 0;
	    	bonificacions += bonificacionsDeLloguer(lloguer);
	        resultat += "\t" +
	                lloguer.getVehicle().getMarca() +
	                " " +
	                lloguer.getVehicle().getModel() + ": " +
	                (lloguer.quantitat() * 30) + "�" + "\n";
	    }
	    

	    resultat += "Import a pagar: " + preuTotal() + "�\n" +
	        "Punts guanyats: " + bonificacions + "\n";
	    return resultat;
	}
	
	
	public int bonificacionsDeLloguer(Lloguer lloguer) {
		int bonificacions = 0;
        if (lloguer.getVehicle().getCategoria() == Vehicle.LUXE &&
                lloguer.getDies()>1 ) {
            bonificacions ++;
        }
        return bonificacions;
	}
	
	//Preu de tots els lloguers d'un client
	public double preuTotal() {
		double total = 0;
		for (Lloguer lloguer:lloguers) { //Calcula el total de cada cotxe i suma al total
			double preu = lloguer.quantitat();
			total += preu * 30;
		}
		return total;
	}
	
	
}
