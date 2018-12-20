package laFac;

import java.util.Observable;
import java.util.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class DirectionMarketing implements Observer {

/*
       @Override
    public void update(Observable o, Object arg) {
        System.out.println("j'ai update "+ o.toString()+ "   arg "+ arg.toString());

    }

     Interface observeur Abdoulaye
* //mettre à jour la quantité du produit p
	public void majProduit(Produit p) ;
	public void majProduit(Produit p, int quantite) ;

	public void majCombProd(List<Produit> list);

	public void actionAlertTotal(double total);

	public void ajouterProduit(Produit p);
public void afficheProdQuant();*/

   /* private Map<Produit, Integer> quantProd;
    private List<Produit> combinProd;

    public DirectionMarketing() {
        quantProd = new HashMap<>();
        combinProd = new ArrayList<>();
    }

    //ajouter un produit
    @Override
    public void majProduit(Produit p) {
        addProd(p, 1);
    }

    //ajouter un produit avec sa quantite
    @Override
    public void majProduit(Produit p, int quantite) {
        addProd(p, quantite);
    }

    //maj à effectuer si le panier contient la liste de produit, combinProd
    @Override
    public void majCombProd(List<Produit> list) {
        if(list.containsAll(combinProd)) {
            System.out.println("Alerte combinaison de produit");
        }
    }

    //action lorsque la totale du panier est atteint une certaine somme
    @Override
    public void actionAlertTotal(double total) {
        if(total >= 100)
            System.out.println("Alerte de total");
    }

    @Override
    public void ajouterProduit(Produit p) {
        combinProd.add(p);
    }

    //ajouter le produit p avec sa quantite dans la map
    private void addProd(Produit p, int quant) {
        //ajouter au moins un produit
        if(quant < 1)
            throw new IllegalArgumentException("arguments non valides");
        Integer val = quantProd.get(p);
        if(val == null) {
            quantProd.put(p, quant);
        }
        else {
            quantProd.put(p, quant+val);
        }
    }

    public void afficheProdQuant() {
        Iterator<Entry<Produit, Integer>> it = quantProd.entrySet().iterator();
        Entry<Produit, Integer> ent ;
        while(it.hasNext()) {
            ent = it.next();
            System.out.println(ent.getKey().getId() + " de quantite " + ent.getValue());
        }
    }*/
}
