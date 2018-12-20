package laFac;

import java.util.ArrayList;

public class OffreFlash extends OffreCo {

    public OffreFlash(double d, ArrayList<Produit> combiProduit){
        taux=d;
        for(Produit p:combiProduit){
            /*if(p.isOffrable()){
                pdtConcerne.add(p);
            }*/
            if(p.getSaCategorie() instanceof Offrable) pdtConcerne.add(p);
            else {
                //Si tous les produits ne sont pas offrable on ne peux pas cree l'offre
                pdtConcerne.clear();
                System.out.println("new ErreurCreationOffre flash");//à faire
                }
        }
        //Si creer => Ajout de l'offre pour tout les clients dans les offreFlashes
        //if(pdtConcerne.size()!=0) Statut.offreFlashes.add(this);//à revoir
        if(pdtConcerne.size()!=0) Statut.offresClients.add(this);
    }


    //Redefinition de changerPrix pour les offres flashs car il faut verifier que toute la combinaison de produit est présente dans le panier.
    public void changerPrix(Panier panier) {
        if(panier.getContenu().containsAll(pdtConcerne)){
            for(Produit p:panier.getContenu()) {
                if(pdtConcerne.contains(p)){
                    //recalculePrix(p);
                    calculeReduction(p);
                }
            }
        }
    }
}
