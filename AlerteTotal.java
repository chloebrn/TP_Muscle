package laFac;

import java.util.Observable;

public class AlerteTotal extends DirectionMarketing {
    double seuil;
	public AlerteTotal() {
            super();
            seuil = 100;
        }

	public AlerteTotal(double seuil) {
            super();
            this.seuil = seuil;
        }

    @Override
    public void update(Observable arg0, Object arg1) {
	    Client c=(Client) arg1;
        double d = c.getSonPanier().getTotal();
        if(d >= seuil) {
            System.out.println("Le client "+ c.getNom()+ " au statut " + c.getSonStat()+ " a un panier de "+ d + " euros :)! " );}
           /*Panier p = (Panier)arg1;
            double d = p.getTotal();
            if(d >= seuil) {
                System.out.println("Ce client a un panier = "+ d + " euros :)! " );
            }*/
    }

}
