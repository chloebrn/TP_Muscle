package laFac;

public class Produit {
	protected String id;
    protected double prix;
	protected double reduction;
	protected int pointsDeFidelite;
	protected Categorie saCategorie;
	//protected  boolean offrable;

    //Tout produit est pottentiellement offrable
    public Produit() {
    	id="undefined";
    	prix=0.f;
    	pointsDeFidelite=0;
    	//offrable=true;
    }

    public Produit(String i, double p, int pts) {
    	id=i;
    	prix=p;
    	pointsDeFidelite=pts;
		//offrable=true;
    }

	public Categorie getSaCategorie() {
		return saCategorie;
	}

	public void setSaCategorie(Categorie cat) {
		this.saCategorie = cat;
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

//!!!!!!!
	public double getReduction() {
		return reduction;
	}

	public void ajoutReduction(double red) {
			if(reduction<red) reduction = red;
			else { System.out.println("Deja une meilleure offre");}
	}

	//????????Pour quoi?????????
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + pointsDeFidelite;
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	//??????Pour quoi??????????
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pointsDeFidelite != other.pointsDeFidelite)
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}
}