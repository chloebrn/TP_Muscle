package laFac;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Panier extends Observable {
	private double total;
    private ArrayList<Observer> sesObservateurs;//liste de ses observateurs à faire!!!!!!!!!!!
	private ArrayList<Produit> contenu;

    public Panier() {
        this.sesObservateurs = new ArrayList<Observer>();
        this.contenu = new ArrayList<Produit>();
		this.total=0;
	}

  	public ArrayList<Produit> getContenu() {
		return this.contenu;
	}

	public void setContenu(ArrayList<Produit> contenu) {
		this.contenu = contenu;
	}


	public double getTotal() {
		return total;
	}

	public void setTotal(double t) {
		this.total = t;
		//setChanged();
		//notifyObservers();
	}

	//Effectue le rabais, fixé à 30% du seuil de point de la carte de fidélité, au panier.
	public void rabais(double r){
    	total-=r;
	}

	//Calcule le total du panier
	public void calculetotal() {
		//est il necessaire de verifier la taille????????? si vide vaut zero non????????????????Si oui throw new ErreurPanierVide
		if (contenu.size() != 0) {
			for (Produit p : contenu) {
				p.setPrix(p.getPrix()-p.getReduction());
				total += p.getPrix();
			}
		}
		//*if(total>=100) this.notifyObservers();*/
	}

	//Ajoute un article au panier
	public void ajoutArticle(Produit p){
		contenu.add(p);
    }

    //Pour les alertes!!!!!!!!!!!!necessaire???????????
	@Override
	public String toString() {
		return "Je suis un pannier :)";
	}


    @Override
    public synchronized void addObserver(Observer o) {
        sesObservateurs.add(o);
    }

	//A faire!!!!!!!!!!!!
    @Override
	public void notifyObservers() {
		System.out.println("jai notifieeee");
		for(Observer o:sesObservateurs){
		    o.update(this,o);
            System.out.println(o.toString());
        }

	}
	/*private IObserveur dir; // ABDOULAYE

	//ABDOULAYE
	public Panier(IObserveur io) {
		this();
		dir = io;
	}

	// ABDOULAYE
	public void ajouterProduit(Produit p) {
		contenu.add(p);
	}

	// ABOULAYE
	public void alerteProduit() {
		for (Produit p : contenu) {
			dir.majProduit(p);
		}
	}

	// ABDOULAYE
	public void alerteCombinProd() {
		dir.majCombProd(contenu);
	}

	//o:ajout article
	public void ajoutArticle(Produit p){
		this.contenu.add(p);
	}
	public void alerte(){}
	*/
}

