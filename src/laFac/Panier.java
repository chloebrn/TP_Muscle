package laFac;

import java.util.ArrayList;

public class Panier {
    private ArrayList<Produit> contenu;
    private float total;

    public ArrayList<Produit> getContenu() {
        return this.contenu;
    }

    public void setContenu(ArrayList<Produit> contenu) {
        this.contenu = contenu;
    }

    public Panier() {
        this.contenu = new ArrayList<Produit>();
    }

    public Panier(ArrayList<Produit> contenu) {
        this.contenu = contenu;
    }

	public float getTotal() {
		return total;
	}

	public void setTotal(float t) {
		this.total = t;
	}
	
	public float total() {
		float t=0.f;
		if(contenu.size()!=0) {
			for(Produit p: contenu) {
			t+=p.getPrix();
		}
		}
		return t; 
	}
}

