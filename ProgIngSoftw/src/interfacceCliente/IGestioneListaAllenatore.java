package interfacceCliente;

import java.util.List;

import controller.PersistenceException;
import dominio.Allenatore;

public interface IGestioneListaAllenatore {
	
	public List<Allenatore> getAllenatoriSeguiti(String username) throws PersistenceException;

}
