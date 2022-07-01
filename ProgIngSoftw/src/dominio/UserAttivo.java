package dominio;

public class UserAttivo extends UserState{
	
	private String stato = "Attivo";

	public UserAttivo(User user) {
		super(user);		
	}

	@Override
	public String getStato() {
		return stato;
	}
	

}
