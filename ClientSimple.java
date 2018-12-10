package laFac;

public class ClientSimple implements Statut {

    public ClientSimple() {
    }

    @Override
    public void sonStatut(Client c) {
        c.setSonStat(this);
    }
    @Override
    public String toString() {
        return "Le statut du client est ClientSimple";
    }
}

