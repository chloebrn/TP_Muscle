package laFac;

import java.util.ArrayList;
import java.util.Observer;

public class Test {

    //la liste des produits en vente
    public static ArrayList<Produit> listProduit(){
        ArrayList<Produit> list = new ArrayList<Produit>();

        list.add((new Tele("tv", 400.d, 20)));
        list.add(new Livre("Harry Poter", 50, 10, "J K Roling"));
        list.add(new Livre("L'alchimiste", 10, 3, "Paulo"));
        list.add(new Spectacle("Cirque du soleil", 45, 4, "TotemT"));
        list.add(new Spectacle("L'age des héros", 24, 2, "Marvel"));

        return list;
    }

    //la liste des offres flash de cette periode
    public static ArrayList<OffreFlash> listOffreFlash() throws ErreurProdNonOffrable {
        ArrayList<OffreFlash> list = new ArrayList<OffreFlash>();

        //of1 est une offre flash sur 2 livres
        OffreFlash of1 = new OffreFlash(0.15d);
        of1.pdtConcerne.add(new Livre("Harry Poter", 50, 10, "J K Roling"));
        of1.pdtConcerne.add(new Livre("L'alchimiste", 10, 3, "Paulo"));

        //of1 est une offre flash sur 1 livre et un spectacle
        OffreFlash of2 = new OffreFlash(0.10d);
        of2.pdtConcerne.add(new Spectacle("Cirque du soleil", 45, 4, "TotemT"));
        of2.pdtConcerne.add(new Livre("Harry Poter", 50, 10, "J K Roling"));

        list.add(of1);
        list.add(of2);

        //list contient deux types d'offre flash
        return list;
    }

    //list des offres de produits
    public static ArrayList<OffreProduit> listOffreProduit() throws ErreurProdNonOffrable {
        ArrayList<OffreProduit> list = new ArrayList<OffreProduit>();

        OffreProduit op1 = new OffreProduit(0.1d, new Tele("tv", 400.d, 20));

        list.add(op1);

        //une seule offre de produit, qui est sur la tele
        return list;
    }

    //list des offres pour les membres
    public static ArrayList<OffreMembre> listOffreMembre(){
        ArrayList<OffreMembre> list = new ArrayList<OffreMembre>();

        //TODO

        return list;
    }

    //creer un client avec la liste des statuts qui se trouvent dans la base
    public static void creerClient() throws ErreurStatut, ErreurProdNonOffrable {
        Client c = new Client();

        //les statuts de la base
        MembrePersonnel sPAnne=new MembrePersonnel("anneperso");
        Adherent sAAnne=new Adherent("anneadherent");
        MembrePersonnel sPFred=new MembrePersonnel("fredperso");

        ArrayList<CarteDeFidelite> sesCartes=new ArrayList<>();
        CarteDeFidelite c1=new CarteDeFidelite(15);
        sesCartes.add(c1);
        sAAnne.setSesCartes(sesCartes);

        Client.addClient(sPAnne);
        Client.addClient(sPFred);
        Client.addClient(sAAnne);

        ArrayList<OffreFlash> offreF = listOffreFlash();
        ArrayList<OffreProduit> offreP = listOffreProduit();
        ArrayList<OffreMembre> offreM = listOffreMembre();
        //Statut.setOffreFlash(offreF);

    }

    public static void main(String[] args) throws ErreurStatut, ErreurProdNonOffrable {
        Client anne=new Client();
        Client fred= new Client("fred");
        Client cha=new Client("cha");
        MembrePersonnel sPAnne=new MembrePersonnel("anneperso");
        Adherent sAAnne=new Adherent("anneadherent");
        MembrePersonnel sPFred=new MembrePersonnel("fredperso");
        Client.addClient(sPAnne);
        Client.addClient(sPFred);
        Client.addClient(sAAnne);

        ArrayList<CarteDeFidelite> sesCartes=new ArrayList<>();
        CarteDeFidelite c1=new CarteDeFidelite(15);
        sesCartes.add(c1);
        sAAnne.setSesCartes(sesCartes);

        Offrable offrable=new Offrable();
        NonOffrable nonOffrable=new NonOffrable();
        //HighTech ht=new HighTech();
        //ht.setSaCategorie(offrable);

        Tele tv=new Tele("tv", 400.d, 20);
        tv.setSaCategorie(offrable);
        Livre l1=new Livre("Harry Poter", 50, 10, "J K Roling");
        l1.setSaCategorie(offrable);
        Livre l2=new Livre("L'alchimiste", 10, 3, "Paulo");
        ArrayList<Produit> combiP=new ArrayList<>();
        combiP.add(l1);
        combiP.add(tv);
        OffreProduit o=new OffreProduit(0.1d, tv);
        OffreProduit op=new OffreProduit(0.1d, l1);
        //tv.setSaCategorie(nonOffrable);
        OffreFlash of=new OffreFlash(0.1d, combiP);
        tv.setSaCategorie(nonOffrable);
        System.out.println(o.pdtConcerne.size()+ " "+ " tv est offrable?" + tv.getSaCategorie());

        anne.seConnecter("anneadherent", "Adherent");

        anne.ajoutProduit(tv);
        anne.ajoutProduit(l1);
        anne.ajoutProduit(l2);
        anne.payer();
        System.out.println(anne.getSonStat()+"  "+ anne.getSonPanier().getTotal());

        //Abdou
        Observer alPrd = new AlerteProd();
        Observer alComb = new AlerteCombinProd();
        Observer alTot = new AlerteTotal();

       /* anne.getSonPanier().addObserver(alTot);
        anne.getSonPanier().addObserver(alPrd);

        anne.getSonPanier().notifyObservers();*/

        anne.addObserver(alPrd);
        anne.addObserver(alComb);
        anne.addObserver(alTot);
        anne.notifyObservers();

    }

}
