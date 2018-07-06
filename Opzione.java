/**
 * 
 */

/**
 * @author Matteo
 *
 */


import java.util.*;

public class Opzione {
	
	private String descrizione = null;
	private int idCollegato = -1;
	
	
	public Opzione (int idCollegato) {//costruttore con solo id di Collegamento con un altro paragrafo
		
		this.idCollegato = idCollegato;
	}
	
	public Opzione (int idCollegato, String descrizione) {// costruttore id Collegamento + Descrizione dell'opzione
		
		this.idCollegato = idCollegato;
		this.descrizione = descrizione;
	}
	
	public void modifyLink (int x) {//modifica/imposta l'id di collegamento
		
		idCollegato = x;
	}

	public int getIdCollegato() {//ritorna l'id del collegamento
		return idCollegato;
	}

	public String getDescrizione() {//ritorna la descrizione
		return descrizione;
	}

	public void setDescrizione(String descrizione) {//imposta/modifica la descrizione dell'opzione
		this.descrizione = descrizione;
	}
	
	public String toString () {
		
		return descrizione;
	}
	
	
	

	
	
}
