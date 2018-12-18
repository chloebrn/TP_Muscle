package laFac;

import java.util.ArrayList;


public class MembrePersonnel extends Statut {
    private String mailPerso;
    public static ArrayList<OffreMembre> sesReductions=new ArrayList<>(); //Catalogue des offres membres

    
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
    

    public void calculReduction(Panier sonPanier) {
		//modifie les prix des produits ayant une offre flash ou offre produit
		super.calculReduction(sonPanier);
		//applique offre adherent aux produit concerne
		for(OffreMembre oMb:sesReductions){
			oMb.changerPrix(sonPanier);
			
		}
		//appliquer rabais
		
		
	}
	public static void addSesReductions(OffreMembre offreMembre) {
		sesReductions.add(offreMembre);
	}
    
}
