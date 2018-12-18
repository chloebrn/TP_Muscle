package laFac;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Panier extends Observable {
	private double total;
    private ArrayList<Observer> sesObservateurs;
	private ArrayList<Produit> contenu;

    public Panier() {
        this.sesObservateurs = new ArrayList<Observer>();
        this.contenu = new ArrayList<Produit>();
		this.total=0;
	}

  	public ArrayList<Produit> getContenu() {
		return this.contenu;
	}

	public void setContenu(ArrayList<Produit> contenu) {
		this.contenu = contenu;
	}


	public double getTotal() {
		return total;
	}

	public void setTotal(double t) {
		this.total = t;
		//setChanged();
		//notifyObservers();
	}
	
	public double calculetotal() {
		double t=0.;
		if(contenu.size()!=0) {
			for(Produit p: contenu) {
			t+=p.getPrix();
			}
			//total=t;

		/*if(total>=100) this.notifyObservers();*/
		}
		return t; 
	}

	public void ajoutArticle(Produit p){
		contenu.add(p);
		total+=p.getPrix();
    }

	@Override
	public String toString() {
		return "Je suis un pannier :)";
	}

/*	@Override
	public void notifyObservers(Object arg) {
		System.out.println("jai notifieeee");
		if(arg instanceof Observer){
			Observer o= (Observer) arg;
			o.update(this,arg);
		}
	}
*/

    @Override
    public synchronized void addObserver(Observer o) {
        sesObservateurs.add(o);
    }

    @Override
	public void notifyObservers() {
		System.out.println("jai notifieeee");
		for(Observer o:sesObservateurs){
		    o.update(this,o);
            System.out.println(o.toString());
        }

	}
	/*private IObserveur dir; // ABDOULAYE

	//ABDOULAYE
	public Panier(IObserveur io) {
		this();
		dir = io;
	}

	// ABDOULAYE
	public void ajouterProduit(Produit p) {
		contenu.add(p);
	}

	// ABOULAYE
	public void alerteProduit() {
		for (Produit p : contenu) {
			dir.majProduit(p);
		}
	}

	// ABDOULAYE
	public void alerteCombinProd() {
		dir.majCombProd(contenu);
	}

	//o:ajout article
	public void ajoutArticle(Produit p){
		this.contenu.add(p);
	}
	public void alerte(){}
	*/
}

