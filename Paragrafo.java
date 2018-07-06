/**
 * 
 */

/**
 * @author Matteo
 *
 */


import java.util.*;

public class Paragrafo {
	
	private String descrizione = null;
	private List <Opzione> opzioni = null;
	//private int id = -1;
	
	
	
	/*public Paragrafo (int id) {//costruttore con solo id
		
		this.id = id;
		opzioni = new ArrayList <Opzione>();
	}*/
	
	public Paragrafo (String descrizione) {//costruttore con id e descriione
		
		this.descrizione = descrizione;
		opzioni = new ArrayList <Opzione>();
	}

	public String getDescrizione() {//ritorna la descrizione del paragrafo
		return descrizione;
	}

	public void setDescrizione(String descrizione) {//imposta la descrizione del paragrafo
		this.descrizione = descrizione;
	}

	/*public int getId() {//ritorna l'id del paragrafo
		return id;
	}

	public void setId(int id) {//imposta l'id del paragrafo
		this.id = id;
	}*/
	
	
	public Opzione getOpzione (int index) {
		
		return opzioni.get(index);
		
	}
	
	public void addOpzione (Opzione x) {
		
		opzioni.add(x);
	}
	
	public int quantit‡Opzioni() {
		return opzioni.size();
	}
	
	public String toString () {
		
		return descrizione;
	}
	
	

}
	
