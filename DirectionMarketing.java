package laFac;

import java.util.Observable;
import java.util.Observer;

public class DirectionMarketing implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("j'ai update "+ o.toString()+ "   arg "+ arg.toString());

    }
}
