package laFac;

public class NonOffrable implements Categorie {
    public void saCategorie(Produit p) {
        p.setSaCategorie(this);
    }
    public String toString() {
        return "La categorie du produit est NonOffrable";
    }

}
