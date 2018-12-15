package laFac;

import java.util.ArrayList;

public class OffreProduit extends OffreCo {
    public OffreProduit() {
        super();
    }
    public OffreProduit(double t, Produit p) {
        super(t);
        pdtConcerne.add(p);
    }

    public OffreProduit(double t, ArrayList<Produit> pdtConcerne) {
        super(t, pdtConcerne);
    }

}
