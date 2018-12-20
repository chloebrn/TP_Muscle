package laFac;

import java.util.ArrayList;

public class OffreProduit extends OffreCo {
    public OffreProduit() {
        super();
        //?????????????Ajout dans les offres quand meme???????????
    }
    public OffreProduit(double t, Produit p) {
        super(t, p);
        //Si creer => Ajout de l'offre pour tout les clients dans les offreFlashes
        //if(p.isOffrable()) Statut.offrePdts.add(this);
        if(pdtConcerne.size()!=0) Statut.offresClients.add(this);
    }

}
