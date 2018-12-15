package laFac;

public class CarteDeFidelite {
	
	private int totalPoints;

	public CarteDeFidelite() {
		totalPoints=0;
	}
	public CarteDeFidelite(int p) {
		totalPoints=p;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public int calculPoint(Panier panier){
		int points=0;
		for (Produit p:panier.getContenu()){
			points+=p.getPointsDeFidelite();
		}
		return points;
	}

	public void effectueRabais(Panier panier){
		//ici ou dans offre adherent?
		//Rabais=taux?
	}
}