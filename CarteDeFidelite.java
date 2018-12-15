package laFac;

public class CarteDeFidelite {
	
	private int ptsDeFidelite;
	private int seuil;
	private double rabais;
	
	public CarteDeFidelite(int seuil) {
		ptsDeFidelite=0;
		this.seuil=seuil;
		rabais=(double)seuil/15.d;
	}
	
	public int getPointsDeFidelite() {
		return ptsDeFidelite;
	}

	public void setPointsDeFidelite(int pointsDeFidelite) {
		this.ptsDeFidelite = pointsDeFidelite;
	}

	public int getSeuil() {
		return seuil;
	}

	public void setSeuil(int seuil) {
		this.seuil = seuil;
	}
	
	public void update(Panier sonPanier) {
		int pts=0;
    	for(Produit p:sonPanier.getContenu()) {
    		pts+=p.getPointsDeFidelite();
    	}
		
		ptsDeFidelite+=pts;
		if(ptsDeFidelite>seuil) {  
			ptsDeFidelite-=seuil;
			sonPanier.soustraitTotal(rabais);
		}
	}
	
	
	

}