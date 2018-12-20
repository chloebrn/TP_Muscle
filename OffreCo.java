package laFac;

import java.util.ArrayList;

public abstract class OffreCo {
	protected double taux;
	protected ArrayList<Produit> pdtConcerne; //liste de produits beneficiant d'une offre co

	//???Peut on creer une offre sans produit concerné???????
   	public OffreCo() {
		pdtConcerne = new ArrayList<>();
		taux=0.d;
	}
	//???Peut on creer une offre sans produit concerné???????
	public OffreCo(double t) {
   		taux=t;
		pdtConcerne = new ArrayList<>();
	}
	
	public OffreCo(double t, Produit p) {
		taux=t;
		pdtConcerne = new ArrayList<>();
		System.out.println(p.isOffrable());
		//Si produit offrable on l'ajoute
		if(p.isOffrable()) {pdtConcerne.add(p);}
		//Sinon on ne peut pas creer l'offre
		else{
			System.out.println("throw new ErreurCreationOffre");//à faire!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		System.out.println(pdtConcerne.size());
	}
	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	//Applique le taux au produit
	/*public void recalculePrix(Produit p) {
		double res=p.getPrix()*taux;
		p.setPrix(p.getPrix()-res);
   	}*/

	public void calculeReduction(Produit p) {
		double res=0;
		res=p.getPrix()*taux;
		p.ajoutReduction(res);
	}

   	//Parcourir le panier et changer le prix des produits bénéficiants de l'offre.
	public void changerPrix(Panier panier) {
		for(Produit p:panier.getContenu()) {
			if(pdtConcerne.contains(p)){
				//recalculePrix(p);
				calculeReduction(p);
			}
		}
	}
	
}
