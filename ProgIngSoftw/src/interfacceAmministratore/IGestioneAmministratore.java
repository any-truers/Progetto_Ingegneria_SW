package interfacceAmministratore;

import java.util.List;

import controller.PersistenceException;
import dominio.Cliente;

public interface IGestioneAmministratore {

	public boolean aggiungiAllenatore(String nome, String cognome, String username, String password, String categoria) throws PersistenceException;
	
	public boolean rimuoviAllenatore(String username) throws PersistenceException;
	
	public boolean bloccaUtente(String username) throws PersistenceException;
	
	public boolean sbloccaUtente(String username) throws PersistenceException;
	
	public List<Cliente> getUtentiBloccati() throws PersistenceException;
		
}
