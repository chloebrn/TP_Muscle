package laFac;


import java.util.ArrayList;

public class Client {
    private String nom;
    private Panier sonPanier;
    private Statut sonStat;
	private static ArrayList<Statut> lesClients=new ArrayList<>();//Contient aussi les clients simples????????????

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
			//Exception new ErreurAjoutClient??
		}
		lesClients.add(s);
	}

	//Un simple client tente de se connecter avec un identifiant
	public void seConnecter(String id, String typeCompte) {
		if(sonStat.equals(typeCompte)) {
			//exception ErreurIdentification "Deja connecter"!!!!
		}
		else if(typeCompte.equals("MembrePersonnel")) {
			MembrePersonnel m=new MembrePersonnel(id);
			seConnecter(m);
		}
		else if(typeCompte.equals("Adherent")) {
			Adherent a=new Adherent(id);
			seConnecter(a);
		}
		else {
			//exception throw new ErreurIdentification "Un simple client tente de se connecter"!!!!
		}
	}

	//Connecte la personne
	private void seConnecter(Statut stat) {
		if(lesClients.contains(stat)) {
			int i=lesClients.indexOf(stat);
			sonStat=lesClients.get(i);
		}
		else {
			//exception  throw new ErreurIdentification "Id incorrect"?? ou pas droit??!!!!
		}
	}

	//
	public void seDeconnecter() {
		if(sonStat instanceof ClientSimple) {
			//Exception trhow new ErreurDeconnection ??!!!!!!!!!!!
		}
		else {
			sonStat=new ClientSimple();
		}
	}

	//Ajoute un produit au panier du client
	public void ajoutProduit(Produit p) {
		sonPanier.ajoutArticle(p);
	}

	//Avant de payer tenir compte de toutes ses offres et calculer total.
	public void payer(){
    	sonStat.calculReduction(sonPanier);
		sonPanier.calculetotal();
    }

	

}
