package laFac;

import java.util.ArrayList;

public abstract class Statut {
	protected ArrayList<OffreProduit> offrePdts;
	protected ArrayList<OffreFlash> offreFlash;

	public Statut() {
		offrePdts=new ArrayList<>();
		offreFlash=new ArrayList<>();
	}

	public void sonStatut(Client c){
		c.setSonStat(this);
	}
	public void calculReduction(Panier panier){
			for(OffreProduit op:offrePdts){
				op.changerPrix(panier);
			}
			for(OffreFlash of:offreFlash){
				of.changerPrix(panier);
			}

	}

}

