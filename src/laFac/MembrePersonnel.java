package laFac;

import java.util.ArrayList;

public class MembrePersonnel implements Statut {
    private String mailPerso;
    private String mdpPerso;
    private ArrayList<OffreMembre> sesReductions;

    
    public MembrePersonnel() {
    	mailPerso="undefined";
    	sesReductions=new ArrayList<>();
    }
    public MembrePersonnel(String id) {
    	mailPerso=id;
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
	
    @Override
    public void sonStatut(Client c) {
        c.setSonStat(this);

    }

    @Override
    public String toString() {
        return "Le statut du client est MembrePersonnel";
    }
    
    public boolean equals(Object o) {
    	if(o==this) return true;
    	if(o==null) return false;
    	if(o instanceof MembrePersonnel) {
    		MembrePersonnel m=(MembrePersonnel) o;
    		return m.mailPerso==this.mailPerso;
    	}
		return false;
    }
    
}
