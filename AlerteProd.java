package laFac;

import java.util.ArrayList;
import java.util.Observable;

public class AlerteProd extends DirectionMarketing {
    public AlerteProd() {
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        Client c=(Client) arg1;
        ArrayList<Produit> list= c.getSonPanier().getContenu();
        for(Produit prod : list) {
            if(prod.getPrix() > 100) {
                System.out.println("Le client " +c.getNom()+ " au statut " + c.getSonStat()+ " a acheter le produit "+prod.getId() + " au prix de "+ prod.getPrix() );
            }
        }
        /*Panier p = (Panier)arg1;
        ArrayList<Produit> list = p.getContenu();
        for(Produit prod : list) {
            if(prod.getPrix() > 100) {
                System.out.println(prod.getId() + " a ete vendu");
            }
        }*/

    }
}
