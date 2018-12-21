package laFac;

import java.util.ArrayList;

public class MembrePersonnel extends Statut {
    private String mailPerso;
    public static ArrayList<OffreMembre> offreMembres=new ArrayList<>();

    //Est ce necessaire un membre perso a forcement son mail non??????????????????????????,
    public MembrePersonnel(){
        super();
        mailPerso="undefined";
    }

    public MembrePersonnel(String mail) {
        this();
        mailPerso=mail;
    }

	public String getMailPerso() {
		return mailPerso;
	}

	public void setMailPerso(String mailPerso) {
		this.mailPerso = mailPerso;
	}

	public ArrayList<OffreMembre> getSesReductions() {
		return offreMembres;
	}

	public void setSesReductions(ArrayList<OffreMembre> sesReductions) {
		this.offreMembres = sesReductions;
	}

    //Redefinition de la methode car il faut aussi appliquer les offres concernant les membres du personnels.
    public void calculReduction(Panier panier){
        super.calculReduction(panier);
        for(OffreMembre om: offreMembres){
            om.changerPrix(panier);
        }
    }

    @Override
    public String toString() {
        return "MembrePersonnel";
    }

    @Override
    public boolean equals(Object o) {
        if(o==this) return true;
        if(o==null) return false;
        if(o instanceof MembrePersonnel) {
            MembrePersonnel m=(MembrePersonnel) o;
            return m.mailPerso.equals(this.mailPerso);
        }
        return false;
    }
}
