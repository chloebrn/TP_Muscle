package laFac;

import java.util.ArrayList;

public abstract class OffreCo {
	private double taux;
	private ArrayList<Produit> pdtConcerne; //O:liste de produits beneficiant d'une offre co
	
   	public OffreCo() {
		pdtConcerne = new ArrayList<>();
		taux=0.d;
    }
	
	public OffreCo(double t, ArrayList<Produit> pdtConcerne) {
		taux=t;
		this.pdtConcerne = pdtConcerne;
	}
	/*public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	void recalculePrix(Produit p) {
		p.setPrix(p.getPrix()*taux);
	}*/
	//O:reclacule bis
	void recalculePrixb(Pannier pannier) {
		for(Produit p:pannier.getContenu()) {
			if(pdConcerne.contains(p)){
				p.setPrix(p.getPrix()*taux);
			}
		}
	}
	
}
