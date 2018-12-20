package laFac;

public class ClientSimple extends Statut {

    public ClientSimple() {
        super();
    }

   /*
   //plus necessaire car defini ds statut class abstraite
    public void sonStatut(Client c) {
        c.setSonStat(this);
    }*/
    @Override
    public String toString() {
        return "Le statut du client est ClientSimple";
    }
}

