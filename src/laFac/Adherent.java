package laFac;

import java.util.ArrayList;

public class Adherent extends Statut {
    private String mailAdherent;
    private ArrayList<CarteDeFidelite> sesCartes;
    private ArrayList<OffreAdherent> sesOffres;

    public Adherent() {
    	super();
    	mailAdherent="undefined";
    	sesCartes=new ArrayList<>();
		sesOffres=new ArrayList<>();
    }
	public Adherent(String id) {
		super();
		mailAdherent=id;
		sesCartes=new ArrayList<>();
		sesOffres=new ArrayList<>();
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
		return sesOffres;
	}

	public void setSesOffres(ArrayList<OffreAdherent> sesOffres) {
		this.sesOffres = sesOffres;
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
	//trouver la carte la plus proche du seuil
	public CarteDeFidelite carteMax() {
		if(sesCartes.isEmpty()) return null;
		CarteDeFidelite c=sesCartes.get(0);
		for(CarteDeFidelite carte:sesCartes) {
			if((carte.getSeuil()-carte.getTotalPoints())<(c.getSeuil()-c.getTotalPoints())) {
				c=carte;
			}
		}
		return c;
	}
	public void calculReduction(Panier panier){
		//modifie les prix des produits ayant une offre flash ou offre produit
		super.calculReduction(panier);
		//applique offre adherent aux produit concerne
		for(OffreAdherent oAd:sesOffres){
			oAd.changerPrix(panier);
		}
		//appliquer rabais
		CarteDeFidelite c=carteMax();
		c.calculPoint(panier);
		c.effectueRabais(panier);
	}
    public String toString() {
        return "Le statut du client est Adherent";
    }
	public boolean equals(Object o) {
		if(o==this) return true;
		if(o==null) return false;
		if(o instanceof Adherent) {
			Adherent a=(Adherent) o;
			System.out.println("o est adherent");
			return a.mailAdherent.equals(this.mailAdherent);
		}
		return false;
	}
}
