package laFac;

import java.util.ArrayList;

public class Main {
	
	//la liste des produits en vente
	public static ArrayList<Produit> listProduit(){
		ArrayList<Produit> list = new ArrayList<Produit>();
		
		list.add((new Tele("tv", 400.d, 20)));
		list.add(new Livre("Harry Poter", 50, 10, "J K Roling"));
		list.add(new Livre("L'alchimiste", 10, 3, "Paulo"));
		list.add(new Spectacle("Cirque du soleil", 45, 4, "TotemT"));
		list.add(new Spectacle("L'age des héros", 24, 2, "Marvel"));
		
		return list;
	}
	
	//la liste des offres flash de cette periode
	public static ArrayList<OffreFlash> listOffreFlash(){
		ArrayList<OffreFlash> list = new ArrayList<OffreFlash>();
		
		//of1 est une offre flash sur 2 livres
		OffreFlash of1 = new OffreFlash(0.15d, new Livre("Harry Poter", 50, 10, "J K Roling"));
		of1.pdtConcerne.add(new Livre("L'alchimiste", 10, 3, "Paulo"));
		
		//of1 est une offre flash sur 1 livre et un spectacle
		OffreFlash of2 = new OffreFlash(0.10d, new Spectacle("Cirque du soleil", 45, 4, "TotemT"));
		of2.pdtConcerne.add(new Livre("Harry Poter", 50, 10, "J K Roling"));
		
		list.add(of1);
		list.add(of2);
		
		//list contient deux types d'offre flash
		return list;
	}
	
	//list des offres de produits
	public static ArrayList<OffreProduit> listOffreProduit(){
		ArrayList<OffreProduit> list = new ArrayList<OffreProduit>();
		
		OffreProduit op1 = new OffreProduit(0.1d, new Tele("tv", 400.d, 20));
		
		list.add(op1);
		
		//une seule offre de produit, qui est sur la tele
		return list;
	}
	
	//list des offres pour les membres
	public static ArrayList<OffreMembre> listOffreMembre(){
		ArrayList<OffreMembre> list = new ArrayList<OffreMembre>();
		
		//TODO
		
		return list;
	}
	
	//creer un client avec la liste des statuts qui se trouvent dans la base
	public static void creerClient() {
		Client c = new Client();
		
		//les statuts de la base
		MembrePersonnel sPAnne=new MembrePersonnel("anneperso");
		Adherent sAAnne=new Adherent("anneadherent");
		MembrePersonnel sPFred=new MembrePersonnel("fredperso");
		
		ArrayList<CarteDeFidelite> sesCartes=new ArrayList<>();
		CarteDeFidelite c1=new CarteDeFidelite(15);
		sesCartes.add(c1);
		sAAnne.setSesCartes(sesCartes);
		
		Client.addClient(sPAnne);
		Client.addClient(sPFred);
		Client.addClient(sAAnne);
		
		ArrayList<OffreFlash> offreF = listOffreFlash();
		ArrayList<OffreProduit> offreP = listOffreProduit();
		ArrayList<OffreMembre> offreM = listOffreMembre();
		//Statut.setOffreFlash(offreF);
		
	}

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

		Tele tv=new Tele("tv", 400.d, 20);
		Livre l1=new Livre("Harry Poter", 50, 10, "J K Roling");


		OffreProduit o=new OffreProduit(0.1d, tv);
		ArrayList<Produit> a=new ArrayList<>();
		a.add(l1);
		a.add(tv);

		OffreFlash of=new OffreFlash(0.15d, l1);
		Livre l2=new Livre("L'alchimiste", 10, 3, "Paulo");

		of.pdtConcerne.add(l2);
		sAAnne.setOffreFlash(of);

		System.out.println(anne.getSonStat().toString());
		anne.seConnecter("anneadherent", "Adherent");

		anne.ajoutProduit(tv);
		anne.ajoutProduit(l1);
		anne.ajoutProduit(l2);
		anne.payer();
		System.out.println(anne.getSonStat()+"  "+ anne.getSonPanier().getTotal());

		
	}

}
