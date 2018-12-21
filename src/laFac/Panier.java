package laFac;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Panier {
	private double total;
    private ArrayList<Produit> contenu;

    public Panier() {
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
				p.setPrix(p.getPrix() - p.getReduction());
				total += p.getPrix();
			}
		}
	}

	//Ajoute un article au panier
	public void ajoutArticle(Produit p){
		contenu.add(p);
    }

 	@Override
	public String toString() {
		return "Ce pannier contient " + contenu.size() + " produits et a un total de "+ total + " euros.";
	}

}

