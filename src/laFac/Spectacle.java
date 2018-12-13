package laFac;

public class Spectacle extends Produit{
	public Spectacle(String i, double p, int pts, String a) {
		super(i, p, pts);
		artiste=a;
		
	}

	private String artiste;

	public String getArtiste() {
		return artiste;
	}

	public void setArtiste(String artiste) {
		this.artiste = artiste;
	}
}
