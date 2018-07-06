/**
 * 
 */

/**
 * @author Matteo
 *
 */


import java.util.*;

public class Storia {

	
	private Map <Integer , Paragrafo> paragrafi = new HashMap <>(); 
	private String titolo = null;
	private List <Integer> idFinale = new ArrayList <Integer>();
	private int idInizio = 0;
	
	

	public Storia (String titolo) {//costruttore 
		
		this.titolo = titolo;
	}	
	
	public int getIdInizio() {//restituisce l'id iniziale
		return idInizio;
	}

	public void setIdInizio(int idInizio) {//imposta l'id iniziale
		this.idInizio = idInizio;
	}
	
	public void addFinale (int id) {//aggiunge un id finale nella lista
		
		idFinale.add(id);
	}
	
	public boolean getFinaleEq (int id) { //restituisce se uno degli id finali della storia combacia con quello inserito
		
		boolean trovato = false;
		for (int i = 0; i < idFinale.size(); i++) {
			
			if (idFinale.get(i) == id)
				trovato = true;
		}
		return trovato;
	}


	public String getTitolo() {//ritorna il titolo della storia
		return titolo;
	}


	public void modifyTitolo(String titolo) {//modifica il titolo della storia 
		this.titolo = titolo;
	}
	
	public  void addValue (int x , Paragrafo y) {//aggiunge un oggetto di tipo paragrafo e lo associ ad un id fornito
		
		paragrafi.put(x, y);
	}
	
	public Paragrafo getValue (int x) {//ritorna il paragrafo associato al suo id
		
		return paragrafi.get(x);
	}

	public boolean existAssociation (int index) {//ritorna vero se il valore id inserito è gia stato associato
		
		return paragrafi.containsKey(index);
	}
	/*@override
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {//restituisce la descrizione di storia dal titolo 
		
		return titolo;
	}
	
}
