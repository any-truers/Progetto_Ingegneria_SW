package test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controller.PersistenceException;
import dominio.Allenamento;
import dominio.Allenatore;
import dominio.LivelloDifficolta;
import dominio.TipoRicerca;
import interfacceAllenatore.AggiungiAllenamentoController;
import interfacceAllenatore.RimuoviAllenamentoController;
import interfacceCliente.RicercaController;

public class TestRicercaAllenamento {
	
	private Allenamento allenamento;
	private File file;
	private Allenatore allenatore;
	
	@Before
	public void setUpCliente() {
		allenatore = new Allenatore("PincoPallino36","Pinco","Pallino");
		file = new File("BasiDiCorsa.mp4");
		allenamento = new Allenamento( "Basi di corsa", 65, "Running", 300, file, LivelloDifficolta.PRINCIPIANTE,allenatore);
	}
	@Test
	public void testGetAllenamento() {
		assertEquals(allenamento.getAllenatore(), allenatore);
		assertEquals(allenamento.getTitolo(), "Basi di corsa");
		assertEquals(allenamento.getDurata(), 65);
		assertEquals(allenamento.getCategoria(), "Running");
		assertEquals(allenamento.getCalorie(), 300);
		assertEquals(allenamento.getFileVideo(), file);
		assertEquals(allenamento.getLivello(), LivelloDifficolta.PRINCIPIANTE);
	}
	
	
	
	
	@Test
	public void testGestioneAllenamento() {
		AggiungiAllenamentoController ia = new AggiungiAllenamentoController();
		try {
			assertEquals(ia.aggiungiAllenamento(allenatore.getUsername(),allenamento.getTitolo(), allenamento.getDurata(),
					allenamento.getCategoria(), allenamento.getCalorie(),allenamento.getLivello(),allenamento.getFileVideo())
					,true);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		RimuoviAllenamentoController ir = new RimuoviAllenamentoController();
		try {
			assertEquals(ir.rimuoviAllenamento(allenamento, allenatore.getUsername()),true);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testGetAllenamentiCaricati() {
		List<Allenamento> all = new ArrayList<>();
		allenamento = new Allenamento( "Corsa avanzata", 65, "Running", 300, file, LivelloDifficolta.ESPERTO,allenatore);
		all.add(allenamento);
		allenatore.setAllenamentiCaricati(all);
		assertEquals(allenatore.getAllenamentiCaricati(),all);
	}
	@Test
	public void testRicerca() {
		RicercaController ir = new RicercaController();
		String testo = "Run";
		TipoRicerca tipo = TipoRicerca.CATEGORIA;
		List<Allenamento> allenamenti = new ArrayList<>();
		try {
			allenamenti = ir.ricerca(testo, tipo);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		assertEquals("Corsa avanzata",allenamenti.get(0).getTitolo());
	}	
}
