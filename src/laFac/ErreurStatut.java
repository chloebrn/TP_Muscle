package laFac;

//Si un ClientSimple cherche à se déco ou si un clientSimple cherche à se co alors qu'il n'a pas le bon id, etc

public class ErreurStatut extends Exception{

	public ErreurStatut() {
		super();
	}

	public ErreurStatut(String msg) {
		super(msg);
	}
}
