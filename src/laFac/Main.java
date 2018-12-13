package laFac;

public class Main {

	public static void main(String[] args) {
		//ABDOULAYE
		IObserveur dir = new DirectionMarketing();
		dir.ajouterProduit(new Livre("harry Potter ", 7.66, 3, "J.K. Rowling"));
		dir.ajouterProduit(new Spectacle("show of the year", 9.99, 2, "nit doff"));
		
		Client anne=new Client();
		Livre l1=new Livre("harry Potter ", 7.66, 3, "J.K. Rowling");
		Livre l2=new Livre("L'alchimiste", 4.99, 1, "Paulo");
		Spectacle s1 = new Spectacle("show of the year", 9.99, 2, "nit doff");
		Spectacle s2 = new Spectacle("cices", 8.50, 3, "dip");
		
		Panier panier = new Panier(dir);
		panier.ajouterProduit(l1);
		panier.ajouterProduit(l2);
		panier.ajouterProduit(s1);
		panier.ajouterProduit(s2);
		panier.ajouterProduit(l1);
		panier.total();
		
		dir.afficheProdQuant();
		//ABDOULAYE
		

	}

}
