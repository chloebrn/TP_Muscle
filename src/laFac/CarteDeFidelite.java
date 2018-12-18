package laFac;

public class CarteDeFidelite {
	private int totalPoints;
	private int seuil;
	private double rabais;

	public CarteDeFidelite() {
		totalPoints=0;
	}
	public CarteDeFidelite(int s) {
		totalPoints=0;
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

	public boolean seuilAtteint(){
		return (totalPoints>=seuil) ;//faut effectuer le rabais
	}

	public void calculPoint(Panier panier){
		//int points=0;
		for (Produit p:panier.getContenu()){
			totalPoints+=p.getPointsDeFidelite();
		}
		System.out.println("total point = " + totalPoints);
		//return points;
	}

	public void effectueRabais(Panier panier){
		calculPoint(panier);
		if(this.seuilAtteint()){
			System.out.println("rabais = " + rabais);
			panier.setTotal(panier.getTotal()-rabais);
			totalPoints-=seuil;
		}
	}
}