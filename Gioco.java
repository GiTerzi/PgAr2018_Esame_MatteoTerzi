import it.unibs.fp.mylib.InputDati;

public class Gioco {

	public final static String SCEGLI = "Cosa scegli? (La prima opzione ha indice = 0, le altre proseguono in ordine crescente\n\n";
	public final static String GIOCA  = "Il gioco è iniziato, ecco la descrizione del primo paragrafo:\n\n";
	public final static String FINALE = "Sei arrivato alla fine della storia, complimenti!!";
	
	public static  void Gioca(Storia a) {
		
		System.out.println(GIOCA);
		
		int i = 0;
	
		int iniziale = a.getIdInizio();
		
		Paragrafo inizio = a.getValue(iniziale);
		
		System.out.println(inizio.toString());//stampa la descrizione del paragrafo
		
		while(i < inizio.quantitàOpzioni()) {
			
			System.out.println(inizio.getOpzione(i).toString());
			i++;
		}
		
		int idOpzione = InputDati.leggiIntero(SCEGLI, 0, inizio.quantitàOpzioni() - 1);
		
		int IdnextP = a.getValue(iniziale).getOpzione(idOpzione).getIdCollegato();
		
		Paragrafo next = a.getValue(IdnextP);//sono nel nuovo paragrafo
		
		i = 0;
		int idNextParag = 0;
		
		while (a.getFinaleEq(i) == false) {
			
			
			int j = 0;
			System.out.println(next.toString());//stampa la descrizione del paragrafo
			
			while (j < next.quantitàOpzioni()) {
				
				System.out.println(next.getOpzione(j));
				j++;
				
			}
			
			int idOpt = InputDati.leggiIntero(SCEGLI, 0, next.quantitàOpzioni() - 1);
			idNextParag = next.getOpzione(idOpt).getIdCollegato();
			
			next = a.getValue(idNextParag);
			
			i = idNextParag;
			
		}
		
		System.out.println(a.getValue(idNextParag).toString());
		
		System.out.println(FINALE);
		
	}
	
}
