package laFac;

import java.util.ArrayList;

public class OffreFlash extends OffreCo {
    public OffreFlash(double d){
        super(d);
    }

    public OffreFlash(double d, ArrayList<Produit> combiProduit) throws ErreurProdNonOffrable {
        taux=d;
        for(Produit p:combiProduit){
            /*if(p.isOffrable()){
                pdtConcerne.add(p);
            }*/
            if(p.getSaCategorie() instanceof Offrable) pdtConcerne.add(p);
            else {
                //Si tous les produits ne sont pas offrable on ne peux pas cree l'offre
                pdtConcerne.clear();
                throw new ErreurProdNonOffrable("Le produit "+ p.getId()+" n'est pas offrable. Erreur de creation de l'offre flash");
                }
        }
        if(pdtConcerne.size()!=0) Statut.offresClients.add(this);
    }


    //Redefinition de changerPrix pour les offres flashs car il faut verifier que toute la combinaison de produit est présente dans le panier.
    public void changerPrix(Panier panier) {
        if(panier.getContenu().containsAll(pdtConcerne)){
            for(Produit p:panier.getContenu()) {
                if(pdtConcerne.contains(p)){
                    calculeReduction(p);
                }
            }
        }
    }
}
