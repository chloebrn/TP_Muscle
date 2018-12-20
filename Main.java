package laFac;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Client anne=new Client();
		Client fred= new Client("fred");
		Client cha=new Client("cha");
		MembrePersonnel sPAnne=new MembrePersonnel("anneperso");
		Adherent sAAnne=new Adherent("anneadherent");
		MembrePersonnel sPFred=new MembrePersonnel("fredperso");
		Client.addClient(sPAnne);
		Client.addClient(sPFred);
		Client.addClient(sAAnne);

		ArrayList<CarteDeFidelite> sesCartes=new ArrayList<>();
		CarteDeFidelite c1=new CarteDeFidelite(15);
		sesCartes.add(c1);
		sAAnne.setSesCartes(sesCartes);

		HighTech ht=new HighTech();

		Tele tv=new Tele("tv", 400.d, 20);
		Livre l1=new Livre("Harry Poter", 50, 10, "J K Roling");
		Livre l2=new Livre("L'alchimiste", 10, 3, "Paulo");
		//tv.setNonOffrable();
		//!!!!!!Un produit peut il avoir plusieurrrrrrrrrs offreeeessssssssss??????????? si oui dans quel ordre apliquer les offres????????????
		OffreProduit o=new OffreProduit(0.1d, ht);
		System.out.println(o.pdtConcerne.size()+ "instance "+ (tv instanceof HighTech));
		//OffreProduit op=new OffreProduit(0.1d, l1);
		//l1.setNonOffrable(); plus offrable retirer de liste des offres.
		ArrayList<Produit> combiP=new ArrayList<>();
		combiP.add(l1);
		combiP.add(tv);


		//OffreFlash of=new OffreFlash(0.10d, combiP);

		anne.seConnecter("anneadherent", "Adherent");

		anne.ajoutProduit(tv);
		anne.ajoutProduit(l1);
		anne.ajoutProduit(l2);
		anne.payer();
		System.out.println(anne.getSonStat()+"  "+ anne.getSonPanier().getTotal());

		/*Livre l1=new Livre("Harry Poter", 50, 10, "J K Roling");
		Livre l2=new Livre();

		Adherent startState = new Adherent();
		startState.sonStatut(anne);

		System.out.println(anne.getSonStat().toString());

		MembrePersonnel stopState = new MembrePersonnel();
		stopState.sonStatut(anne);

		System.out.println(anne.getSonStat().toString());

		Panier p=new Panier();
		DirectionMarketing d=new DirectionMarketing();
		p.addObserver(d);
		p.ajoutArticle(l1);
		//p.setTotal(100);
		System.out.println(p.getTotal()+"  "+ p.calculetotal());
*/
		/*
		* //ABDOULAYE
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
//ABDOULAYE*/
	}

}
