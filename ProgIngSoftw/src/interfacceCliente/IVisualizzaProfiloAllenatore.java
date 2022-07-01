package interfacceCliente;

import controller.PersistenceException;
import dominio.Allenatore;

public interface IVisualizzaProfiloAllenatore {
	
	//List<Allenamento> getAllenamentiCaricati(String usernameAll);
	
	//String getCategoria(String usernameAll);
	
	public boolean seguiAllenatore(String username, String usernameAll) throws PersistenceException;
	
	public boolean smettiDiSeguireAllenatore(String username, String usernameAll) throws PersistenceException;
	
	//float getValutazione(String usernameAll);
	
	public Allenatore visualizzaProfilo(String username) throws PersistenceException;

}
