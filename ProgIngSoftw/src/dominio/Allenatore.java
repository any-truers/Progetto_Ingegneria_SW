package dominio;

import java.util.ArrayList;
import java.util.List;

public class Allenatore extends Cliente{

	private List<Allenamento> allenamentiCaricati;
	private float valutazione;
	private String categoria;
	
	public Allenatore(String u, String n, String c) {
		super(u, n, c);
		this.allenamentiCaricati = new ArrayList<>();
		this.valutazione = 0;
		this.categoria = "";
	}
	
	public void setCategoria(String c) {
		this.categoria = c;
	}
	
	public String getCategoria() {
		return this.categoria;
	}

	public List<Allenamento> getAllenamentiCaricati() {
		return allenamentiCaricati;
	}

	public void setAllenamentiCaricati(List<Allenamento> allenamentiCaricati) {
		this.allenamentiCaricati = allenamentiCaricati;
	}

	public float getValutazione() {
		return valutazione;
	}

	public void setValutazioneMedia(float valutazioneMedia) {
		this.valutazione = valutazioneMedia;
	}

		public boolean caricaAllenamento(Allenamento a) {
		return this.allenamentiCaricati.add(a);
	}

	public boolean rimuoviAllenamento(Allenamento a) {
		return this.allenamentiCaricati.remove(a);
	}
	
	

}
