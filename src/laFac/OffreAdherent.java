package laFac;

import java.util.ArrayList;

public class OffreAdherent extends OffreCo {
    private int seuil;
    
    public OffreAdherent() {
        super();

    }
    public OffreAdherent(int s) {
        super();
        seuil=s;

    }

    public OffreAdherent(double t, ArrayList<Produit> pdtConcerne) {
        super(t, pdtConcerne);
    }

    public boolean seuilAtteint(CarteDeFidelite carte){
        return carte.getTotalPoints()==seuil;//faut effectuer le rabais
    }
}