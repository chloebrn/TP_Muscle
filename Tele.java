package laFac;

public class Tele extends HighTech {

    public Tele() {
        super();
    }

    public Tele(String id, double p, int pts) {
        super(id, p, pts);
    }

    /*@Override
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj==null) return false;
        if(obj instanceof Tele) {
            Tele t=(Tele) obj;
            //return (prix;
            return true;
        }
        return false;
    }
    */
}
