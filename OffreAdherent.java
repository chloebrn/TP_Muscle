package laFac;

import java.util.ArrayList;

public class OffreAdherent extends OffreCo {

    public OffreAdherent() {
        super();
        //?????????????Ajout dans les offres quand meme???????????
    }

    public OffreAdherent(double t, Produit p) {
        super(t, p);
        //Si creer => Ajout de l'offre pour tout les clients dans les offreAdherents!!!!!!!!!!!!!!!sinon exceptionnnnnnnnnnnn!!!!!!!!
        //if(p.isOffrable())
        if(pdtConcerne.size()!=0) Adherent.offreAdherents.add(this);
    }
}
