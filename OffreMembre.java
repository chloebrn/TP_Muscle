package laFac;

import java.util.ArrayList;
import java.util.HashMap;

public class OffreMembre extends OffreCo {

    public OffreMembre() {
        super();
    }

    public OffreMembre(double t, Produit p) throws ErreurProdNonOffrable {
        super(t, p);
        if(pdtConcerne.size()!=0) MembrePersonnel.offreMembres.add(this);
    }
}
