package laFac;

import java.util.List;

public interface IObserveur {
	//mettre à jour la quantité du produit p
	public void majProduit(Produit p) ;
	public void majProduit(Produit p, int quantite) ;
	
	public void majCombProd(List<Produit> list);
	
	public void actionAlertTotal(double total);
	
	public void ajouterProduit(Produit p);
	public void afficheProdQuant();
}
