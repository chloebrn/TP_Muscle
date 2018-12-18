package laFac;

import java.util.ArrayList;

public abstract class OffreCo {
	protected double taux;
	protected ArrayList<Produit> pdtConcerne; //O:liste de produits beneficiant d'une offre co
	
   	public OffreCo() {
		pdtConcerne = new ArrayList<>();
		taux=0.d;
    }
	public OffreCo(double t) {
   		taux=t;
		pdtConcerne = new ArrayList<>();
	}
	
	public OffreCo(double t, Produit p) {
		taux=t;
		pdtConcerne = new ArrayList<>();
		pdtConcerne.add(p);
	}
	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	/*void recalculePrix(Produit p) {
		p.setPrix(p.getPrix()*taux);
	}*/
	//O:reclacule bis
	public void changerPrix(Panier panier) {
		for(Produit p:panier.getContenu()) {
			if(pdtConcerne.contains(p)){
				p.setPrix(p.getPrix()*taux);
			}
		}
	}
	
}
