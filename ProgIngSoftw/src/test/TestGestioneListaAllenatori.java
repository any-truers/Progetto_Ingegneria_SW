package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import controller.PersistenceException;
import dominio.Allenatore;
import interfacceCliente.GestioneListaAllenatoreController;

public class TestGestioneListaAllenatori {
	
	@Test
	public void TestAllenatoriSeguiti() {
		GestioneListaAllenatoreController ig = new GestioneListaAllenatoreController();
		List<Allenatore> list = new ArrayList<>();
		try {
			list = ig.getAllenatoriSeguiti("GaiaBianchi");
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(list.get(0).getUsername(),"PincoPallino36");
	}
	
}


