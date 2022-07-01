package interfacceCliente;

import java.util.List;

import controller.PersistenceException;
import dominio.Allenamento;
import dominio.TipoRicerca;

public interface IRicerca {
	
	public List<Allenamento> ricerca(String testo, TipoRicerca tipo) throws PersistenceException;
}
