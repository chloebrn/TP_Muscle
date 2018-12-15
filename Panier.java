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
	
	public void soustraitTotal(double rabais) {
		total-=rabais;
	}
	
	public void ajouterProduit(Produit p) {
		contenu.add(p);
		total+=p.getPrix();
	}
}

