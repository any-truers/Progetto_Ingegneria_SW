package dominio;

import java.io.File;

public class Allenamento {
	
	private String usernameAllenatore;
	private String titolo;
	private int durata;
	private String categoria;
	private int calorie;
	private File fileVideo;
	private LivelloDifficolta livello;
	private Allenatore allenatore;
	
	
	public Allenamento(String titolo, int durata, String categoria, int calorie, File fileVideo,
			LivelloDifficolta livello, Allenatore allenatore) {
		this.titolo = titolo;
		this.durata = durata;
		this.categoria = categoria;
		this.calorie = calorie;
		this.fileVideo = fileVideo;
		this.livello = livello;
		this.allenatore = allenatore;
	}

	public String getUsernameAllenatore() {
		return usernameAllenatore;
	}

	public void setUsernameAllenatore(String usernameAllenatore) {
		this.usernameAllenatore = usernameAllenatore;
	}

	public Allenatore getAllenatore() {
		return allenatore;
	}

	public void setAllenatore(Allenatore allenatore) {
		this.allenatore = allenatore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public File getFileVideo() {
		return fileVideo;
	}

	public void setFileVideo(File fileVideo) {
		this.fileVideo = fileVideo;
	}

	public LivelloDifficolta getLivello() {
		return livello;
	}

	public void setLivello(LivelloDifficolta livello) {
		this.livello = livello;
	}

}
