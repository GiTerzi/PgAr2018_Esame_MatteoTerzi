/**
 * 
 */

/**
 * @author Matteo
 *
 */

import java.util.*;

public class Archivio {

	private static List <Storia> storie = new ArrayList <Storia>();
	

	public static void addStoria (Storia x) {//aggiunge una storia all'array
		
		storie.add(x);
		
	}
	
	public static Storia getStoriaFromIndex (int index) {//ritorna la storia tramite l'indice immesso
		
		return storie.get(index);
	}
	
	public static int getIndexFromTitolo (String titolo) {//ritorna l'indice della storia tramite il titolo immesso
		
		int index = -1;
		for(int i = 0; i < storie.size(); i++) {
			if (titolo.equals(storie.get(i).toString()))
				index = i;				
			}
		return index;
	}
	
	public static Storia getStoriaFromTitolo (String titolo) {//ritorna la storia tramite il titolo inserito
		
		int index = -1;
		for(int i = 0; i < storie.size(); i++) {
			if (titolo.equals(storie.get(i).toString()))
				index = i;
			
			}
		if (index >= 0)
			return storie.get(index);
		else
			return null;
	}
	
	public static boolean esisteStoria (String titolo) {//controlla se esiste una storia nell'array e restituisce vero o falso
		boolean trovato = false;
		
		for(int i = 0; i < storie.size(); i++) {
		if (titolo.equals(storie.get(i).toString()))
			trovato = true;
		}
		
		return trovato;
	}
		
	public static boolean noStorie () {
		
		return storie.isEmpty();
	
	}
	
	public static int quanteStorie () {
		
		return storie.size();
	}
}
	
	
	
