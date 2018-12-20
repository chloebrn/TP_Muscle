package laFac;

import java.util.ArrayList;

public class OffreAdherent extends OffreCo {

    public OffreAdherent() {
        super();
    }

    public OffreAdherent(double t, Produit p) throws ErreurProdNonOffrable {
        super(t, p);
        if(pdtConcerne.size()!=0) Adherent.offreAdherents.add(this);
    }
}
