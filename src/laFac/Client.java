package laFac;


import java.util.ArrayList;

public class Client {
    private String nom;
    private Panier sonPanier;
    private Statut sonStat;
	private static ArrayList<Statut> lesClients=new ArrayList<>();
	//public static ArrayList<OffreCo> sesOffres;

    public Client() {
    	nom="undefined";
    	sonPanier=new Panier();
    	sonStat=new ClientSimple();
    }
	public Client(String sonNom) {
		nom=sonNom;
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

	public static ArrayList<Statut> getLesClients() {
		return lesClients;
	}
	public static void setLesClients(ArrayList<Statut> lesClients) {
		Client.lesClients = lesClients;
	}

	//Ajouter un nouveau client à la base de donnees
	public static void addClient(Statut s) {
		if(lesClients.contains(s)) {
			//Exception
		}
		lesClients.add(s);
	}


	//Un simple client tente de se connecter avec un identifiant
	public void seConnecter(String id, String typeCompte) {

		if(sonStat.equals(typeCompte)) {
			//exception
		}
		else if(typeCompte=="MembrePersonnel") {
			MembrePersonnel m=new MembrePersonnel(id);
			seConnecter(m);
		}
		else if(typeCompte=="Adherent") {
			Adherent a=new Adherent(id);
			seConnecter(a);
		}
		else {
			//exception
		}
	}


	private void seConnecter(Statut id) {
		if(lesClients.contains(id)) {
			int i=lesClients.indexOf(id);
			sonStat=lesClients.get(i);
		}
		else {
			//exception
		}
	}

	//
	public void seDeconnecter() {
		if(sonStat instanceof ClientSimple) {
			//Exception
		}
		else {
			sonStat=new ClientSimple();
		}
	}

	public void ajoutProduit(Produit p) {
		sonPanier.ajoutArticle(p);
	}
	public void payer(){
    	sonStat.calculReduction(sonPanier);
    	sonPanier.calculetotal();
	}

	

}
