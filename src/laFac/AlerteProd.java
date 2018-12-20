package laFac;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class AlerteProd implements Observer{
	
    public AlerteProd() {
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		Panier p = (Panier)arg1;
		ArrayList<Produit> list = p.getContenu();
		for(Produit prod : list) {
			if(prod.getPrix() > 100) {
				System.out.println(prod.getId() + " a ete vendu");
			}	
		}
		
	}
}