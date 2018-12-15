package laFac;

import java.util.ArrayList;
import java.util.HashMap;

public class OffreMembre extends OffreCo {
    //private HashMap<String,Double> tauxPdtConcerne; //un taux specifique à chaque produit
    public OffreMembre() {
        super();
    }

    public OffreMembre(double t, ArrayList<Produit> pdtConcerne) {
        super(t, pdtConcerne);
    }
}
