package laFac;

import java.util.ArrayList;
import java.util.HashMap;

public class OffreMembre extends OffreCo {

    public OffreMembre() {
        super();
        //?????????????Ajout dans les offres quand meme???????????
    }

    public OffreMembre(double t, Produit p) {
        super(t, p);
        //???Si creer => Ajout de l'offre pour tout les clients dans les offreMembres
        if(p.isOffrable()) MembrePersonnel.offreMembres.add(this);
    }
}
