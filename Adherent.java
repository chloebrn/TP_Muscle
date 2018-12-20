package laFac;

import java.util.ArrayList;

public class Adherent extends Statut {
    private String mailAdherent;
    private ArrayList<CarteDeFidelite> sesCartes;
    public static ArrayList<OffreAdherent> offreAdherents=new ArrayList<>();

	//Est ce necessaire un adherent a forcement son mail non??????????????????????????,
	public Adherent() {
    	super();
    	mailAdherent="undefined";
    	sesCartes=new ArrayList<>();
	}

	public Adherent(String id) {
		super();
		mailAdherent=id;
		sesCartes=new ArrayList<>();
	}

   	public String getMailAdherent() {
		return mailAdherent;
	}

	public void setMailAdherent(String mailAdherent) {
		this.mailAdherent = mailAdherent;
	}

	public ArrayList<CarteDeFidelite> getSesCartes() {
		return sesCartes;
	}

	public void setSesCartes(ArrayList<CarteDeFidelite> sesCartes) {
		this.sesCartes = sesCartes;
	}

	public ArrayList<OffreAdherent> getSesOffres() {
		return offreAdherents;
	}

	public void setSesOffres(ArrayList<OffreAdherent> sesOffres) {
		this.offreAdherents = sesOffres;
	}

	public void addCarte(int points) {
		CarteDeFidelite c=new CarteDeFidelite(points);
		sesCartes.add(c);
	}

	/*
	//plus necessaire car defini ds statut class abstraite
	public void sonStatut(Client c) {
		c.setSonStat(this);
	}*/


	//Renvoi la carte ayant un total de point le plus proche de son seuil. Celle ci sera choisit lors de l'achat.
	public CarteDeFidelite carteMax() {
		if(sesCartes.isEmpty()) return null;//Exception??????????? throw ErreurCarteAdherent adh n'a pas de carte de fidélité????????
		CarteDeFidelite c=sesCartes.get(0);
		for(CarteDeFidelite carte:sesCartes) {
			if((carte.getSeuil()-carte.getTotalPoints())<(c.getSeuil()-c.getTotalPoints())) {
				c=carte;
			}
		}
		return c;
	}

	//Redefinition de la methode car il faut aussi appliquer les offres concernant les adherents, ainsi que un eventuel rabais.
	public void calculReduction(Panier panier){
		super.calculReduction(panier);
		for(OffreAdherent oAd: offreAdherents){
			oAd.changerPrix(panier);
		}
		CarteDeFidelite c=carteMax();
		c.calculPoint(panier);
		c.effectueRabais(panier);
	}

    public String toString() {
        return "Adherent";
    }

    public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(o instanceof Adherent) {
			Adherent a=(Adherent) o;
			return a.mailAdherent.equals(this.mailAdherent);
		}
		return false;
	}
}
