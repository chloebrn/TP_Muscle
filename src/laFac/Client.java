package laFac;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Client extends Observable {
    private String nom;
    private Panier sonPanier;
    private Statut sonStat;
	private static ArrayList<Statut> lesClients=new ArrayList<>();
	private ArrayList<Observer> sesObservateurs;


	public Client() {
    	nom="undefined";
    	sonPanier=new Panier();
    	sonStat=new ClientSimple();
		sesObservateurs=new ArrayList<>();
    }

	public Client(String sonNom) {
		this();
		nom=sonNom;
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
	public static void addClient(Statut s) throws ErreurStatut{
		if(lesClients.contains(s)) {
			throw new ErreurStatut("Ce statut est deja present dans la base.");
		}
		lesClients.add(s);
	}

	//Un simple client tente de se connecter avec un identifiant
	public void seConnecter(String id, String typeCompte) throws ErreurStatut {
		if(sonStat.equals(typeCompte)) {
			throw new ErreurStatut("Deja connecte!");
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
			throw new ErreurStatut("Pas le droit de se connecter!");
		}
	}

	//Connecte la personne
	private void seConnecter(Statut stat) throws ErreurStatut{
		if(lesClients.contains(stat)) {
			int i=lesClients.indexOf(stat);
			sonStat=lesClients.get(i);
		}
		else {
			throw new ErreurStatut("Identifiant incorrect!");
		}
	}

	//
	public void seDeconnecter() throws ErreurStatut{
		if(sonStat instanceof ClientSimple) {
			throw new ErreurStatut("Un client simple tente de se deconnecter!");
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
		//sonPanier.calculetotal();
        //System.out.println(" total avant reduction  "+ sonPanier.getTotal());
		sonStat.calculReduction(sonPanier);
		sonPanier.calculetotal();
    }

	@Override
    public String toString() {
		return "Je suis un client :)";
	}

	@Override
	public synchronized void addObserver(Observer o) {
		sesObservateurs.add(o);
	}

	@Override
	public void notifyObservers() {
		for(Observer o:sesObservateurs){
			o.update(this,this);
		}
	}

}
