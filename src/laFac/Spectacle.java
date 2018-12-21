package laFac;

public class Spectacle extends Produit{
	private String artiste;

	public Spectacle(String i, float p, int pts, String a) {
		super(i, p, pts);
		artiste=a;
		
	}
}
