package laFac;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws ErreurStatut, ErreurProdNonOffrable {
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

		NonOffrable nonOffrable=new NonOffrable();

		Tele tv=new Tele("tv", 400.d, 20);
		Livre l1=new Livre("Harry Poter", 50, 10, "J K Roling");
		Livre l2=new Livre("L'alchimiste", 10, 3, "Paulo");
		ArrayList<Produit> combiP=new ArrayList<>();
		combiP.add(l1);
		combiP.add(tv);
		OffreProduit o=new OffreProduit(0.2d, tv);
		OffreProduit op=new OffreProduit(0.1d, l1);
		try {
			tv.setSaCategorie(nonOffrable);
			OffreFlash of = new OffreFlash(0.1d, combiP);
			}
		catch (ErreurProdNonOffrable e){
			System.out.println(e.getMessage());
		}
		try {
			anne.seConnecter("anneadherent", "Adherent");
			fred.seConnecter("x", "y");
		}catch (ErreurStatut e){
			System.out.println(e.getMessage());
		}
		anne.ajoutProduit(tv);
		anne.ajoutProduit(l1);
		anne.ajoutProduit(l2);
		anne.payer();
		System.out.println(" Total achats de Anne = "+ anne.getSonPanier().getTotal());

	}

}
