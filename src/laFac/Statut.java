package laFac;

import java.util.ArrayList;

public abstract class Statut {
	public static  ArrayList<OffreProduit> offrePdts=new ArrayList<>();
	public static ArrayList<OffreFlash> offreFlashs =new ArrayList<>();

	//public static ArrayList<OffreCo> offresClients=new ArrayList<>();

	public void sonStatut(Client c){
		c.setSonStat(this);
	}

	//Applique les reductions pour l'ensembles des offres disponibles à tous les clients.
	public void calculReduction(Panier panier){
		for(OffreProduit op:offrePdts){
				op.changerPrix(panier);
			}
		for(OffreFlash of: offreFlashs){
				of.changerPrix(panier);
			}
	/*
		for(OffreCo op:offresClients){
			op.changerPrix(panier);
		}	*/
	}
}

