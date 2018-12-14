package laFac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DirectionMarketing implements IObserveur {
	
	private HashPerso<Produit> quantProd;
	private List<Produit> combinProd;
	
	public DirectionMarketing() {
		quantProd = new HashPerso<>();
		combinProd = new ArrayList<>();
	}

	//ajouter un produit
	@Override
	public void majProduit(Produit p) {
		quantProd.add(p);
	}
	
	//ajouter un produit avec sa quantite
	@Override
	public void majProduit(Produit p, int quantite) {
		quantProd.add(p, quantite);
	}
	
	//maj à effectuer si le panier contient la liste de produit, combinProd
	@Override
	public void majCombProd(List<Produit> list) {
		if(list.containsAll(combinProd)) {
			System.out.println("Alerte combinaison de produit");
		}
	}
	
	//action lorsque la totale du panier est atteint une certaine somme 
	@Override
	public void actionAlertTotal(double total) {
		if(total >= 100)
			System.out.println("Alerte de total");
	}
	
	@Override
	public void ajouterProduit(Produit p) {
		combinProd.add(p);
	}
	
	
	public void afficheProdQuant() {
		quantProd.toString();
	}
	


	

}
