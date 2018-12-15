package laFac;

import java.util.ArrayList;

public class Adherent implements Statut {
    private String mailAdherent;
    private ArrayList<CarteDeFidelite> sesCartes;
    private ArrayList<OffreAdherent> sesOffres;

    public Adherent() {
    	mailAdherent="undefined";
    	sesCartes=new ArrayList<CarteDeFidelite>();
    }
    public Adherent(String id) {
    	mailAdherent=id;
    }
    
    public Adherent(String m, String mdp, ArrayList<CarteDeFidelite> c) {
    	mailAdherent=m;
    	sesCartes=c;
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

	public void sonStatut(Client c) {
		c.setSonStat(this);
	}
	
	public void addCarte(int points) {
		CarteDeFidelite c=new CarteDeFidelite(points);
		sesCartes.add(c);
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
    		return a.mailAdherent==this.mailAdherent;
    	}
		return false;
    }
    
    public CarteDeFidelite carteMax() {
    	if(sesCartes.isEmpty()) return null;
    	CarteDeFidelite c=sesCartes.get(0);
    	for(CarteDeFidelite carte:sesCartes) {
    		if((carte.getSeuil()-carte.getPointsDeFidelite())<(c.getSeuil()-c.getPointsDeFidelite())) {
    			c=carte;
    		}
    	}
    	return c;
    }
    


    public void payer(Panier sonPanier) {
		CarteDeFidelite c=carteMax();
		if(sonPanier.getContenu().isEmpty()) return; //EXCEPTION
		c.update(sonPanier);
		System.out.println("Total : " +sonPanier.getTotal());
		
		
		
		
	}
    
}
