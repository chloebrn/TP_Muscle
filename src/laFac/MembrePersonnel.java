package laFac;

import java.util.ArrayList;

public class MembrePersonnel extends Statut {
    private String mailPerso;
    private ArrayList<OffreMembre> sesReductions;

    public MembrePersonnel(){
        super();
        mailPerso="undefined";
        sesReductions=new ArrayList<>();
    }

    public MembrePersonnel(String mail) {
        super();
        mailPerso=mail;
        sesReductions=new ArrayList<>();
    }

	public String getMailPerso() {
		return mailPerso;
	}

	public void setMailPerso(String mailPerso) {
		this.mailPerso = mailPerso;
	}

	public ArrayList<OffreMembre> getSesReductions() {
		return sesReductions;
	}

	public void setSesReductions(ArrayList<OffreMembre> sesReductions) {
		this.sesReductions = sesReductions;
	}

    /*
    //plus necessaire car defini ds statut class abstraite
    public void sonStatut(Client c) {
        c.setSonStat(this);

    }*/
    public void calculReduction(Panier panier){
        super.calculReduction(panier);
        for(OffreMembre om:sesReductions){
            om.changerPrix(panier);
        }
    }

    public String toString() {
        return "Le statut du client est MembrePersonnel";
    }
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
