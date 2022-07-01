package dominio;

public class ClienteSenzaAbbonamento extends StatoAbbonamento{
	
	private String statoAbbonamento = "Non abbonato";
	
	public ClienteSenzaAbbonamento(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public String getStato() {
		return statoAbbonamento;
	}
	

}
