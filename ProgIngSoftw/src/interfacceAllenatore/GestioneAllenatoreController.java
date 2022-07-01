package interfacceAllenatore;


public class GestioneAllenatoreController implements IGestioneAllenatore {
	
	private String username;
	
	public GestioneAllenatoreController(String u) {
		this.username = u;
	}
	
	@Override
	public String getUsername() {
		return this.username;
	}

}
