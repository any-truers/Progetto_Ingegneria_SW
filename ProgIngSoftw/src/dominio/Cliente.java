package dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends User{
	
	private List<Allenatore> allenatoriSeguiti;
	private StatoAbbonamento statoAbbonamento;
	
	
	public Cliente(String username, String nome, String cognome) {
		super(username, nome, cognome);
		this.allenatoriSeguiti = new ArrayList<>();
	}


	public List<Allenatore> getAllenatoriSeguiti() {
		return allenatoriSeguiti;
	}


	public void setAllenatoriSeguiti(List<Allenatore> allenatoriSeguiti) {
		this.allenatoriSeguiti = allenatoriSeguiti;
	}


	public StatoAbbonamento getStatoAbbonamento() {
		return this.statoAbbonamento;
	}
	
	public void setStatoAbbonamento(StatoAbbonamento s) {
		this.statoAbbonamento = s;
	}
	
	public boolean valutaAllenatore(Valutazione v) {
		boolean res = false;
		//INTERAGIRE CON CLASSE CHE ACCEDE A DB PER AGGIUNGERE VALUTAZIONE E RITORNA BOOLEAN
		return res;
	}
	
	public boolean seguiAllenatore(String usernameAllenatore) {
		boolean res = false;
		//INTERAGIRE CON CLASSE CHE ACCEDE A DB E AGGIUNGE ALLENATORE E RITORNA ALLENATORE DA METTERE IN LISTA O NULL SE ERRORE
		return res;
	}
	
	public boolean smettiDiSeguire(String usernameAllenatore) {
		boolean res = false;
		boolean trovato = false;
		for(Allenatore a: this.allenatoriSeguiti) {
			if(a.getUsername().equals(usernameAllenatore)) {
				trovato = true;
			}
		}
		if(trovato == false) {
			return res;
		}
		//ALTRIMENTI INTERAGIRE CON CLASSE CHE ACCEDE A DB PER RIMUOVERE ALLENATORE E RITORNA BOOLEAN
		return res;
	}
	
	
}
