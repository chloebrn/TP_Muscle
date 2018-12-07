package laFac;

import java.util.ArrayList;

public class OffreFlash extends OffreCo {
    private ArrayList<Produit> produitsPromo;

    public OffreFlash() {
    	
    }


	public ArrayList<Produit> getProduitsPromo() {
		return produitsPromo;
	}

	public void setProduitsPromo(ArrayList<Produit> produitsPromo) {
		this.produitsPromo = produitsPromo;
	}
}
