package test;
import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import dominio.Allenamento;
import dominio.Allenatore;
import dominio.LivelloDifficolta;

public class TestAllenamento {
	
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

}

