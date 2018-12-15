package laFac;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Client anne=new Client("anne");
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
		OffreProduit o=new OffreProduit(0.1d, tv);
		

		
		Livre l1=new Livre("Harry Poter", 50, 10, "J K Roling");
		Livre l2=new Livre();
		
		System.out.println(anne.getSonStat().toString());
		anne.seConnecter("anneadherent", "Adherent");
		anne.achete(tv);
		anne.payer();
		/*System.out.println(anne.getSonStat().toString()+ "      "+((Adherent)anne.getSonStat()).getSesCartes().get(0).getPointsDeFidelite());
		anne.seDeconnecter();
		System.out.println(anne.getSonStat().toString());
		
		anne.seConnecter("anneperso", "MembrePersonnel");
		System.out.println(anne.getSonStat().toString());*/
	}

}
