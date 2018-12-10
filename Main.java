package laFac;

public class Main {

	public static void main(String[] args) {
		Client anne=new Client();
		Livre l1=new Livre();
		Livre l2=new Livre();

		Adherent startState = new Adherent();
		startState.sonStatut(anne);

		System.out.println(anne.getSonStat().toString());

		MembrePersonnel stopState = new MembrePersonnel();
		stopState.sonStatut(anne);

		System.out.println(anne.getSonStat().toString());
		

	}

}
