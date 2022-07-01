package dominio;

public class UserBloccato extends UserState{
	
	private String stato = "Bloccato";
	private String motivazione;
	
	public UserBloccato(User user,String motivazione) {
		super(user);
		this.motivazione=motivazione;
	}

	@Override
	public String getStato() {
		return stato;
	}
	
	public String getMotivazione() {
		return motivazione;
	}

	public void setMotivazione(String motivazione) {
		this.motivazione= motivazione;
	}
	
}
