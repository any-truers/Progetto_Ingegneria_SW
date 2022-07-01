package interfacceCliente;

public class GestioneClienteController implements IGestioneCliente{
	
	
	private String username;
	
	public GestioneClienteController(String username) {
		this.username = username;
	}
	
	@Override
	public String getUsername() {
		return this.username;
	}

}
