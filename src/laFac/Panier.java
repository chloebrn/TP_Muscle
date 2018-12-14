package laFac;

import java.util.ArrayList;

public class Panier {
	private double total;
	private IObserveur dir; //observeur, la direction marketing // ABDOULAYE
	private HashPerso<Produit> listArticle; // ABDOULAYE

	public Panier() {
		listArticle = new HashPerso<>(); //ABDOULAYE
		total = 0;
	}
	
	//ABDOULAYE
	//construteur du panier avec un observeur
	public Panier(IObserveur io) {
		this();
		dir = io;
	}

	// ABDOULAYE
	public void ajouterProduit(Produit p) {
		listArticle.add(p);
	}
	
	//obtenir la liste des articles sans doublon
	public ArrayList<Produit> getContenu() {
		return listArticle.elements();     //ABDOULAYE
	}

	//accesseur de total
	public double getTotal() {
		return total;
	}

	public void setTotal(float t) {
		this.total = t;
	}

	//calcul de la total, chaque prix d'un produit est multiplié par sa quantite
	public void total() {
		ArrayList<Produit> contenu = getContenu();
		int quant ;
		if (contenu.size() != 0) {
			for (Produit p : contenu) {
				quant = listArticle.count(p); //récupérer la quantité de cette produit
				total += (p.getPrix()*quant);
			}
			alerteProduit();  //ABDOULAYE
			alerteCombinProd(); //ABDOULAYE
		}
	}

	// ABOULAYE
	//alerter l'oberserveur pour les produits ajoutés par le clients
	public void alerteProduit() {
		for (Produit p : getContenu()) {
			//chaque produit et sa quantite
			dir.majProduit(p, listArticle.count(p));
		}
	}

	// ABDOULAYE
	//notifier l'observeur pour une combinaison de produits
	public void alerteCombinProd() {
		dir.majCombProd(getContenu());
	}
	
	public void imprimeTicket() {
		System.out.println(listArticle.toString());
	}
}
