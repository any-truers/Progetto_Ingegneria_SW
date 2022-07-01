package interfacceCliente;

import controller.PersistenceException;
import dominio.Valutazione;

public interface IValutazione {
	
	public boolean valutaAllenatore(String username, Valutazione v) throws PersistenceException;

}
