package laFac;

public abstract class Produit {
	private String id;
    private double prix;
    private int pointsDeFidelite;

    public Produit() {
    	id="undefined";
    	prix=0.f;
    	pointsDeFidelite=0;
    }
    
    public Produit(String i, float p, int pts) {
    	id=i;
    	prix=p;
    	pointsDeFidelite=pts;
    }
    

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getPointsDeFidelite() {
		return pointsDeFidelite;
	}

	public void setPointsDeFidelite(int pointsDeFidelite) {
		this.pointsDeFidelite = pointsDeFidelite;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}