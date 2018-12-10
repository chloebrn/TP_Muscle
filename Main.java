package laFac;

public class Main {

	public static void main(String[] args) {
		Client anne=new Client();
		Livre l1=new Livre("Harry Poter", 50, 10, "J K Roling");
		Livre l2=new Livre();

		/*Adherent startState = new Adherent();
		startState.sonStatut(anne);

		System.out.println(anne.getSonStat().toString());

		MembrePersonnel stopState = new MembrePersonnel();
		stopState.sonStatut(anne);

		System.out.println(anne.getSonStat().toString());
*/
		Panier p=new Panier();
		DirectionMarketing d=new DirectionMarketing();
		p.addObserver(d);
		p.ajoutArticle(l1);
		p.setTotal(100);
		System.out.println(p.getTotal()+"  "+ p.calculetotal());

	}

}
