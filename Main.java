/**
 * 
 */

/**
 * @author Matteo
 *
 */


//import java.util.*;

import it.unibs.fp.mylib.InputDati;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		final String MESSAGGIO_BENVENUTO = "Buongiorno e benvenuti nel gioco Avventure testuali!!\n\nIniziamo!";
		final String MENU                = "Inserite il numero corrispondente all'opzione che volete usare tra:\n\n1) Creazione nuova storia\n2) Creazione nuovo/i paragrafo/i ad una storia data\n3) Creazione nuova opzione dato un paragrafo\n4) Ricerca di una storia\n5) Visualizzazione di tutte le storie create\n6) Selezione di una storia da giocare\n\n";
		final String CONTINUARE          = "Vuoi continuare ad utilizzare il menù? (Sì = 1 | No = 0)\n ";
		final String ANCORA              = "Devi inserire altre opzioni in questo paragrafo? (Sì = 1 | No = 0)\n";
		final String ANCORA2             = "Devi inserire altri paragrafi in questa storia?\n(Sì = 1 | No = 0)";
		
		final String NUOVO_TITOLO        = "Inserire il titolo da dare alla nuova storia:\n";
		final String CERCA_STORIA        = "Inserire il titolo della storia da cercare:\n";
		final String GIOCA_STORIA        = "Inserire il titolo della storia al quale volete giocare:\n\n";
		
		
		final String QUALE_STORIA        = "A quale storia volete aggiungerlo/i (Inserire titolo storia) ?\n";
		final String QUALI_PARAGRAFI     = "A quale paragrafo volete aggiungerla/e (Inserire id paragrafo) ?\n";
		final String QUANTI_PARAGRAFI    = "Inserite in successione l'id (in ordine crescente da 0)e la descrizione dei paragrafi che volete creare, quando avete finito, inserite un id negativo:\n";
		final String QUALI_COLLEGATI     = "A quale paragrafo vuoi collegarla?\n";
		final String DESCRIZIONE_PARAG	 = "Che descrizione vuoi inserire nell'opzione?\n";
		final String INSERISCI_ID        = "Inserisci l'id:\n";
		final String INSERISCI_DESCR     = "Insersci la descrizione:\n";
		final String INIZIO_FINE         = "Il paragrafo che si vuole inserire è identificabile come paragrafo iniziale o finale? (Sì = 1 | No = 0)\n";
		final String INIZIALE            = "Il paragrafo è iniziale? (Sì = 1 | No = 0)\n";
		final String FINALE              = "Il paragrafo è finale? (Sì = 1 | No = 0)\n";
		
		final String BENE                = "Operazione completata correttamente\n";
		
		final String STORIA_PRESENTE     = "Questo titolo esiste già! Riprova e cambialo!\n";
		final String STORIA_TROVATA      = "Storia trovata!\n";
		final String STORIA_INESISTENTE  = "La storia non esiste! Riprova!\n";
		final String NESSUNA_STORIA      = "Non ci sono storie da visualizzare!\n";
		final String PARAGRAFO_NO        = "Il paragrafo associato all'id immesso non esiste! Controlla meglio l'id e riprova!\n";
		final String VALORE_OCCUPATO     = "L'id è gia stato assegnato! Cambia id!\n";
		
		
		final String SALUTI              = "È stato bello giocare con te! A presto!";
		
		
		System.out.println(MESSAGGIO_BENVENUTO);
		
		do {
		
		int scelta = InputDati.leggiIntero(MENU);
		
		switch (scelta) {
		
		case 1: String titolo = InputDati.leggiStringaNonVuota(NUOVO_TITOLO);
				if (Archivio.esisteStoria(titolo) == true) {
					System.out.println(STORIA_PRESENTE);
					break;
				}																							//OK//
				else
					Archivio.addStoria(new Storia (titolo));//crea ed aggiunge una nuova storia
					System.out.println(BENE);
					break;
				
		case 2: //controlla che la storia inserita esista
				String titolo1 = InputDati.leggiStringaNonVuota(QUALE_STORIA);
				int index = 0 ;
				boolean esiste = true;
				if (Archivio.esisteStoria(titolo1) == true)
					index = Archivio.getIndexFromTitolo(titolo1);
				else {
					System.out.println(STORIA_INESISTENTE);
					esiste = false;
					break;
				}
				
				if (esiste = true) {//se esiste inserisce i paragrafi										//OK//
					

					int id = -1;
					String descrizione = null;
					
					do {
					if(InputDati.leggiIntero(INIZIO_FINE, 0, 1) == 1) {//paragrafo iniziale o finale??
						
						
						if(InputDati.leggiIntero(INIZIALE, 0, 1) == 1) {//iniziale
							
							id = InputDati.leggiIntero(INSERISCI_ID);
							descrizione = InputDati.leggiStringaNonVuota(INSERISCI_DESCR);
							if (Archivio.getStoriaFromIndex(index).existAssociation(id) == true) {//se il valore dell'id ha gia un valore associato...
								System.out.println(VALORE_OCCUPATO);
								
								}
							else{//se l'id non è ancora stato associato prosegue con il nuovo inserimento
								Archivio.getStoriaFromIndex(index).addValue(id, new Paragrafo (descrizione));
								Archivio.getStoriaFromIndex(index).setIdInizio(id);//memorizza nella storia l'id iniziale
								
								}
						}
						
						else
							if(InputDati.leggiIntero(FINALE, 0, 1) == 1){//finale
							
							id = InputDati.leggiIntero(INSERISCI_ID);
							descrizione = InputDati.leggiStringaNonVuota(INSERISCI_DESCR);
							if (Archivio.getStoriaFromIndex(index).existAssociation(id) == true) {//se il valore dell'id ha gia un valore associato...
								System.out.println(VALORE_OCCUPATO);
								}
							else{//se l'id non è ancora stato associato prosegue con il nuovo inserimento
								Archivio.getStoriaFromIndex(index).addValue(id, new Paragrafo (descrizione));
								Archivio.getStoriaFromIndex(index).setIdInizio(id);//memorizza nella storia l'id iniziale
								}
								
								
							}
						}
						
						
				
					
					
					else 
						{
						
						System.out.println(QUANTI_PARAGRAFI);
						int id1;
						do {
							id1 = InputDati.leggiIntero(INSERISCI_ID);
							String descrizione1 = InputDati.leggiStringaNonVuota(INSERISCI_DESCR);
							if (Archivio.getStoriaFromIndex(index).existAssociation(id1) == true) {//se il valore dell'id ha gia un valore associato...
								System.out.println(VALORE_OCCUPATO);
								//break;
								}
								
							else//se l'id non è ancora stato associato prosegue con il nuovo inserimento
								Archivio.getStoriaFromIndex(index).addValue(id1, new Paragrafo (descrizione1));
							
						}	while(id1 >= 0);//finchè non viene iserito un id negativo
						if (id1 < 0) System.out.println(BENE);
						//break;
						}
					}while(InputDati.leggiIntero(ANCORA2, 0, 1) == 1);
						
						break;}
					
	
		case 3: //controlla che la storia esista
				String titolo2 = InputDati.leggiStringaNonVuota(QUALE_STORIA);
				int index1 = -1;
				if (Archivio.esisteStoria(titolo2) == true)
					index1 = Archivio.getIndexFromTitolo(titolo2);
				else {
					System.out.println(STORIA_INESISTENTE);
					esiste = false;
					break;
				}
				
				if (esiste = true) {//se la storia esiste...
					
					int id1 = InputDati.leggiIntero(QUALI_PARAGRAFI);
					Storia x = Archivio.getStoriaFromTitolo(titolo2);
					Paragrafo y = x.getValue(id1);//ricava il paragrafo dato il suo id											//NI//	
						
					if (y == null) {//se l'id del paragrafo non esiste  esce dallo switch
						System.out.println(PARAGRAFO_NO);
						break;
					}
								
					else //se esiste  l'id...
						
						do {
						id1 = InputDati.leggiInteroNonNegativo(QUALI_COLLEGATI);
						String titolo3 = InputDati.leggiStringaNonVuota(DESCRIZIONE_PARAG);
							
						y.addOpzione(new Opzione(id1 , titolo3));//crea ed aggiunge al paragrafo una nuova opzione dati i valori inseriti dall'utente
						System.out.println(BENE);
						}while(InputDati.leggiIntero(ANCORA, 0, 1) == 1);
						break;
				}
					
				else {//se la storia non esiste esce dallo switch
					
					System.out.println(STORIA_INESISTENTE);
					break;
				}
				
			
		case 4: String titolo4 = InputDati.leggiStringaNonVuota(CERCA_STORIA);
				if (Archivio.esisteStoria(titolo4) == true)//Se la storia esiste...
					System.out.println(STORIA_TROVATA);// stampa che esiste
				else//altrimenti																						//OK//
					System.out.println(STORIA_INESISTENTE);//stampa che non esiste
					
					
				
				
		case 5: if(Archivio.noStorie() == true) {
			
				System.out.println(NESSUNA_STORIA);
				break;
				}		
				else {
					System.out.printf("Indice        Titolo");
				
					for(int i = 0; i < Archivio.quanteStorie(); i++) {//scorre l'arrayList delle storie                //OK//
						
						String titolo11 = Archivio.getStoriaFromIndex(i).toString();//estrapola il titolo per ognuna
						
						System.out.printf("\n%d%19s", i, titolo11);//stampa indice e titolo
					
					}
					System.out.println();	
					break;
				}
		
		
		case 6: String titolo5 = InputDati.leggiStringaNonVuota(GIOCA_STORIA);
				Gioco.Gioca(Archivio.getStoriaFromTitolo(titolo5));
				
			
			}
		
		}while (InputDati.leggiIntero(CONTINUARE, 0, 1) == 1);//il menu continua ad essere eseguito fino a quando l'utentenon decide di chiuderlo (0)
		
	System.out.println(SALUTI);
		
	
	}
}
	

