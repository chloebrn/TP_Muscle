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
    //ABDOULAYE : J'ai changé les float en double parce que les deux étaient mélangés

    public Produit(String i, double p, int pts) {
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
	
	//ABDOULAYE
	@Override
	public String toString() {
		return "Produit [id=" + id + ", prix=" + prix + ", pointsDeFidelite=" + pointsDeFidelite + "]";
	}
	
	//ABDOULAYE
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

	//ABDOULAYE
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
