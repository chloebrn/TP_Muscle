package laFac;

import java.util.ArrayList;

public class MembrePersonnel extends Statut {
    private String mailPerso;
    private String mdpPerso;
    private ArrayList<OffreMembre> sesReductions;

    public MembrePersonnel() {
    }

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
	}
}
