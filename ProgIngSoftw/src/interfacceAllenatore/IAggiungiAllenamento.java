package interfacceAllenatore;

import java.io.File;

import controller.PersistenceException;
import dominio.LivelloDifficolta;

public interface IAggiungiAllenamento{
	
	public boolean aggiungiAllenamento(String username, String titolo, int durata, String categoria,
			int calorie, LivelloDifficolta livello, File file) throws PersistenceException;

}
