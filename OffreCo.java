package laFac;

import java.util.ArrayList;

public abstract class OffreCo {
	protected double taux;
	protected ArrayList<Produit> pdtConcerne;

   	public OffreCo() {
		pdtConcerne = new ArrayList<>();
		taux=0.d;
	}

	public OffreCo(double t) {
   		taux=t;
		pdtConcerne = new ArrayList<>();
	}
	
	public OffreCo(double t, Produit p) throws ErreurProdNonOffrable{
		taux=t;
		pdtConcerne = new ArrayList<>();
		//Si produit offrable on l'ajoute
		//if(p.isOffrable()) {pdtConcerne.add(p);}
		if(p.getSaCategorie() instanceof Offrable) pdtConcerne.add(p);
		//Sinon on ne peut pas creer l'offre
		else{
			throw new ErreurProdNonOffrable("Le produit "+ p.getId()+" n'est pas offrable");
		}
   	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public ArrayList<Produit> getPdtConcerne() {
		return pdtConcerne;
	}

	public void ajoutProduit(Produit p) throws ErreurProdNonOffrable {
		if(p.getSaCategorie() instanceof Offrable) pdtConcerne.add(p);
		else throw new ErreurProdNonOffrable("Ce produit n'est pas offrable");
	}

	//Calcul la reduction du produit
	public void calculeReduction(Produit p) {
		double res=0;
		res=p.getPrix()*taux;
		p.ajoutReduction(res);
	}

   	//Parcourir le panier et changer le prix des produits bénéficiants de l'offre.
	public void changerPrix(Panier panier) {
		for(Produit p:panier.getContenu()) {
			if(pdtConcerne.contains(p)){
				calculeReduction(p);
			}
		}
	}
	
}
