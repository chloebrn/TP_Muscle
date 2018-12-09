package laFac;

import java.util.ArrayList;

public class Panier {
    private ArrayList<Produit> contenu;
    private double total;

    public ArrayList<Produit> getContenu() {
        return this.contenu;
    }

    public void setContenu(ArrayList<Produit> contenu) {
        this.contenu = contenu;
    }

    public Panier() {
        this.contenu = new ArrayList<Produit>();
	this.total=0; //O
    }

    public Panier(ArrayList<Produit> contenu) {
        this.contenu = contenu;
    }

	public double getTotal() {
		return total;
	}

	public void setTotal(double t) {
		this.total = t;
	}
	
	public double total() {
		double t=0.;
		if(contenu.size()!=0) {
			for(Produit p: contenu) {
			t+=p.getPrix();
		}
		}
		return t; 
	}
	//o:ajout article
	public void ajoutArticle(Produit p){
		this.contenu.add(p);
	}
	public void alerte(){}
}

