package laFac;

import java.util.ArrayList;

public class OffreProduit extends OffreCo {
    public OffreProduit() {
        super();
    }

    public OffreProduit(double t, Produit p) throws ErreurProdNonOffrable {
        super(t, p);
        if(pdtConcerne.size()!=0) Statut.offresClients.add(this);
    }

}
