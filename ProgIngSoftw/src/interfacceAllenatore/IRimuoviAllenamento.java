package interfacceAllenatore;

import controller.PersistenceException;
import dominio.Allenamento;

public interface IRimuoviAllenamento {
	
	public boolean rimuoviAllenamento(Allenamento allenamento, String username) throws PersistenceException;
}
