package laFac;

import java.util.ArrayList;

public class OffreFlash extends OffreCo {
    private ArrayList<Produit> combiProduit;

    public OffreFlash() {
		super();
        //super(pdtConcerne);
    }


	/*public ArrayList<Produit> getProduitsPromo() {
		return produitsPromo;
	}

	public void setProduitsPromo(ArrayList<Produit> produitsPromo) {
		this.produitsPromo = produitsPromo;
	}*/

    @Override
    public void changerPrix(Panier panier) {
        if(panier.getContenu().containsAll(combiProduit)){
            for(Produit p:panier.getContenu()) {
                if(combiProduit.contains(p)){
                    p.setPrix(p.getPrix()*taux);
                }
            }
        }
    }

}
