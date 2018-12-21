package laFac;

public class CarteDeFidelite {
	private int totalPoints;
	private int seuil;
	private double rabais;

	public CarteDeFidelite() {
		totalPoints=0;
	}
	public CarteDeFidelite(int s) {
		this();
		seuil=s;
		rabais=0.3*seuil;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public int getSeuil() {
		return seuil;
	}

	public void setSeuil(int seuil) {
		this.seuil = seuil;
	}

	public double getRabais() {
		return rabais;
	}

	public void setRabais(double rabais) {
		this.rabais = rabais;
	}

	//Verfie si le seuil de la carte est atteint.
	public boolean seuilAtteint(){
		return (totalPoints>=seuil) ;
	}

	//Mise à jour des points de fidélités.
	public void calculPoint(Panier panier){
		for (Produit p:panier.getContenu()){
			totalPoints+=p.getPointsDeFidelite();
		}
	}

	//Applique le rabais au panier si le seuil est atteint.
	public void effectueRabais(Panier panier){
		calculPoint(panier);
		if(this.seuilAtteint()){
			panier.rabais(rabais);
			totalPoints-=seuil;
		}
	}
}