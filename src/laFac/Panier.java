package laFac;

import java.util.ArrayList;

public class Panier {
    private ArrayList<Produit> contenu;
    private double total;
	private IObserveur dir; // ABDOULAYE
	
	//ABDOULAYE
	public Panier(IObserveur io) {
		this();
		dir = io;
	}

	// ABDOULAYE
	public void ajouterProduit(Produit p) {
		contenu.add(p);
	}

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
			
			alerteProduit();  //ABDOULAYE
			alerteCombinProd(); //ABDOULAYE
		}
		}
		return t; 
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
}

