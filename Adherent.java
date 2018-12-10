package laFac;

import java.util.ArrayList;

public class Adherent implements Statut {
    private String mailAdherent;
    private String mdpAdherent;
    private ArrayList<CarteDeFidelite> sesCartes;
    private ArrayList<OffreAdherent> sesOffres;

    public Adherent() {
    	mailAdherent="undefined";
    	mdpAdherent="undefined";
    	sesCartes=new ArrayList<CarteDeFidelite>();
    }
    
    public Adherent(String m, String mdp, ArrayList<CarteDeFidelite> c) {
    	mailAdherent=m;
    	mdpAdherent=mdp;
    	sesCartes=c;
    }

	public String getMailAdherent() {
		return mailAdherent;
	}

	public void setMailAdherent(String mailAdherent) {
		this.mailAdherent = mailAdherent;
	}

	public String getMdpAdherent() {
		return mdpAdherent;
	}

	public void setMdpAdherent(String mdpAdherent) {
		this.mdpAdherent = mdpAdherent;
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

	@Override
	public void sonStatut(Client c) {
		c.setSonStat(this);
	}
    @Override
    public String toString() {
        return "Le statut du client est Adherent";
    }
}
