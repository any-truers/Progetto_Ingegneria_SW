package test;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import controller.PersistenceException;
import dominio.Allenatore;
import interfacceCliente.VisualizzaProfiloAllenatoreController;

public class TestVisualizzaProfilo {
	
	@Test
	public void testVisualizzaProfiloAllenatore() throws PersistenceException {
		//Database già popolato
		VisualizzaProfiloAllenatoreController vp= new VisualizzaProfiloAllenatoreController();
		Allenatore allenatore= vp.visualizzaProfilo("gino00");
		
		assertEquals(allenatore.getUsername(), "gino00");
		assertEquals(allenatore.getNome(), "gino");
		assertEquals(allenatore.getCognome(), "giallo");
		assertEquals(allenatore.getCategoria(), "yoga");
		if(allenatore.getValutazione()!= 0) {
			assertEquals(true, false);	
		}
		assertEquals(allenatore.getAllenamentiCaricati().size(), 2);
		
	}

}




