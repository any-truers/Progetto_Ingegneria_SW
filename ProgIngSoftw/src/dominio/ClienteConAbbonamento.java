package dominio;

public class ClienteConAbbonamento extends StatoAbbonamento{
	
	private String statoAbbonamento = "Abbonato";
	
	public ClienteConAbbonamento(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public String getStato() {
		return statoAbbonamento;
	}	
	

}
