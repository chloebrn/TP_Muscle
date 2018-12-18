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
		System.out.println("tot avant "+ panier.getTotal());
			for(OffreProduit op:offrePdts){
				op.changerPrix(panier);
			}
		System.out.println("tot apres offrePdt "+ panier.getTotal());
			for(OffreFlash of:offreFlash){
				of.changerPrix(panier);
			}
		System.out.println("tot apres offreFlash "+ panier.getTotal());

	}

	public ArrayList<OffreProduit> getOffrePdts() {
		return offrePdts;
	}

	public void setOffrePdts(ArrayList<OffreProduit> offrePdts) {
		this.offrePdts = offrePdts;
	}

	public ArrayList<OffreFlash> getOffreFlash() {
		return offreFlash;
	}

	public void setOffreFlash(OffreFlash of) {
		offreFlash.add(of);
	}
}

