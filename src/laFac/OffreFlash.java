package laFac;

import java.util.ArrayList;

public class OffreFlash extends OffreCo {
    // ArrayList<Produit> combiProduit;

    public OffreFlash() {
		super();
        //super(pdtConcerne);
    }

    public OffreFlash(double d, Produit p){
        super(d,p);
    }

	/*public ArrayList<Produit> getProduitsPromo() {
		return produitsPromo;
	}

	public void setProduitsPromo(ArrayList<Produit> produitsPromo) {
		this.produitsPromo = produitsPromo;
	}*/

    @Override
    public void changerPrix(Panier panier) {
        if(panier.getContenu().containsAll(pdtConcerne)){
            for(Produit p:panier.getContenu()) {
                if(pdtConcerne.contains(p)){
                    p.setPrix(p.getPrix()*taux);
                }
            }
        }
    }

}
