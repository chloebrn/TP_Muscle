package laFac;

public class Livre extends PdtCulturel{
	
	private String auteur;

	public Livre() {
		super();
		auteur="undefined";
	}

	public Livre(String i, double p, int pts, String a) {
		super(i, p, pts);
		auteur=a;
	}
	
	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
}
