package laFac;

import java.util.Observable;
import java.util.Observer;

public class AlerteTotal implements Observer {
	
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
		Panier p = (Panier)arg1;
		double d = p.getTotal();
		if(d >= seuil) {
			System.out.println("alerte de total");
		}
	}

}
