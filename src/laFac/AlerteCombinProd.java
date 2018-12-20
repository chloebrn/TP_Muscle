package laFac;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class AlerteCombinProd implements Observer{
	
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
		Panier p = (Panier)arg1;
		ArrayList<Produit> l = p.getContenu();
		if(l.containsAll(list)) {
			System.out.println("alerte de combinaison de produit");
		}
	}

}
