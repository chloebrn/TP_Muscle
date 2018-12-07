package laFac;


public class Client {
    private String nom;
    private Panier sonPanier;
    private Statut sonStat;

    public Client() {
    	nom="undefined";
    	sonPanier=new Panier();
    	sonStat=new ClientSimple();
    }
    

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Panier getSonPanier() {
		return sonPanier;
	}

	public void setSonPanier(Panier sonPanier) {
		this.sonPanier = sonPanier;
	}

	public Statut getSonStat() {
		return sonStat;
	}

	public void setSonStat(Statut saCat) {
		this.sonStat = saCat;
	}
	
	public void achete(Produit p) {
		sonPanier.getContenu().add(p);
	}
	

}
