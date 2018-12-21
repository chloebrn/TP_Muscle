package laFac;

import java.util.ArrayList;
import java.util.Observable;

public class AlerteCombinProd extends DirectionMarketing {
    ArrayList<Produit> list ;

    public AlerteCombinProd() {
        super();
        list = new ArrayList<Produit>();
    }

    public AlerteCombinProd(ArrayList<Produit> l) {
        list = l;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        Client c=(Client) arg1;
        ArrayList<Produit> l= c.getSonPanier().getContenu();
        if(l.containsAll(list)) {
            System.out.println("Le client "+ c.getNom()+ " au statut " + c.getSonStat()+" a acheter les produits suivant: ");
            for (Produit p:list){
                System.out.println(p.id);
            }
        }
       /* Panier p = (Panier)arg1;
        ArrayList<Produit> l = p.getContenu();
        if(l.containsAll(list)) {
            System.out.println("alerte de combinaison de produit");
        }*/
    }
}
