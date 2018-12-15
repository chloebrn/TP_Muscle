package laFac;

//Pour les cas ou une ArrayList est vide par ex

public class ErreurVide extends Exception{

	public ErreurVide() {
		super();
	}

	public ErreurVide(String msg) {
		super(msg);
	}
}
