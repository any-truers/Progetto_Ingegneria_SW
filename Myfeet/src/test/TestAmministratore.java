package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controller.PersistenceException;
import dominio.Cliente;
import interfacceAmministratore.GestioneAmministratoreController;

public class TestAmministratore {
	
	private GestioneAmministratoreController ga;
	
	@Before
	public void setUpCliente() {
		ga= new GestioneAmministratoreController();	
	}
	@Test
	public void testAggiungiAllenatore() throws PersistenceException {
		assertEquals(ga.aggiungiAllenatore("Pino", "Verde", "pinoVerde", "pino","yoga"), true);
		//controllo inserimento di un allenatore con stesso username e quindi se è stato inserito correttamente 
		assertEquals(ga.aggiungiAllenatore("Pino", "Verde", "pinoVerde", "pino","yoga"), false);
	}
	@Test
	public void testRimuoviAllenatore() throws PersistenceException {
		assertEquals(ga.rimuoviAllenatore("pinoVerde"), true);
	}
	@Test
	public void testBloccaUtente() throws PersistenceException {
		assertEquals(ga.bloccaUtente("pinoVerde"), true);
	}
	@Test
	public void testSbloccaUtente() throws PersistenceException {
		assertEquals(ga.sbloccaUtente("pinoVerde"), true);
	}
	@Test
	public void testUtentiBloccati() throws PersistenceException {		
		List<Cliente> result=ga.getUtentiBloccati();
		for(Cliente c : result) {
			System.out.println(c.toString());
		}
		assertEquals(result.size(),2); //PROVA	a
	}
}








