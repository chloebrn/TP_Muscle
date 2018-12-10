package laFac;

import java.util.ArrayList;

public class MembrePersonnel implements Statut {
   // private String mailPerso;
   // private String mdpPerso;
    private ArrayList<OffreMembre> sesReductions;

    public MembrePersonnel(){
        super();
    }

    public MembrePersonnel(ArrayList<OffreMembre> sesReductions) {
        this.sesReductions = sesReductions;
    }

    @Override
    public void sonStatut(Client c) {
        c.setSonStat(this);

    }

    @Override
    public String toString() {
        return "Le statut du client est MembrePersonnel";
    }
    /*
	public String getMailPerso() {
		return mailPerso;
	}

	public void setMailPerso(String mailPerso) {
		this.mailPerso = mailPerso;
	}

	public String getMdpPerso() {
		return mdpPerso;
	}

	public void setMdpPerso(String mdpPerso) {
		this.mdpPerso = mdpPerso;
	}

	public ArrayList<OffreMembre> getSesReductions() {
		return sesReductions;
	}

	public void setSesReductions(ArrayList<OffreMembre> sesReductions) {
		this.sesReductions = sesReductions;
	}*/
}
