package laFac;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.TreeSet;

/* Cette classe se comporte comme un HashMap sans la 2nde clè
 * Le but de cette est de d'associer à chaque élément, d'une collection, son nombre d'occurrence
 * */

public class HashPerso<T> {
	Map<T, Integer> hashT ; //HashMap comportant comme un délégué de cette classe
	int size ;
	
	public HashPerso(){
		hashT = new HashMap<T, Integer>();
		size = 0;
	}
	
	/*constructeur prenant une collection en paramètre*/
	public HashPerso(Collection<T> coll){
		hashT = new HashMap<T, Integer>();
		for(T t : coll){
			if(hashT.get(t) == null)
				add(t);
			else
				add(t, 1);		
		}
		size = coll.size();
	}
	
	/* ajouter l'élément e avec count occurrence(s)*/
	public boolean add(T e, int count) {
		if(count < 0)
			throw new IllegalArgumentException("arguement non valide");
		Integer val = hashT.get(e);  //recupérer le nbre d'occ de e s'il existe
		if(val == null){
			hashT.put(e, count);
			size += count;
			return true;
		}
		else{ //rajouter count au nbre d'occ de e qui existe déjà
			hashT.put(e, val+count);
			size += count;
			return true;
		}
	}
	
	//ajouter un élément avec une seule occurrence
	public boolean add(T e) {
		//hashT.put(e, 1);
		this.add(e, 1);
		size++;
		return true;
	}
	
	/* renvoyer le nombre d'occ de "e" */
	public int count(Object o) {
		Integer nbOcc = hashT.get((T)o);
		if(nbOcc == null)
			return 0;
		return nbOcc;
	}
	
	//effacer la hashMap
	public void clear() {
		hashT.clear();
		size = 0;
	}
	
	//renvoie le nombre d'élément dans cette collection
	public int size() {
		return size;
	}
	
	/* retourner la liste des cle sans doublons */
	public ArrayList<T> elements(){
		Set<T> tr = new TreeSet<T>();
		tr = hashT.keySet();
		ArrayList<T> l = new ArrayList<T>(tr);
		return l;
		
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("[\n");
		Iterator<Entry<T, Integer>> it = hashT.entrySet().iterator();
		while(it.hasNext()){
			Entry<T, Integer> e = it.next();
			sb.append(e.getKey()+" x "+e.getValue()+" \n");
		}
		return sb.toString()+"]";
	}
	
	
	public boolean isEmpty(){
		return size==0 && hashT.isEmpty();
	}

}
