package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dominio.Allenatore;

public class TestAllenatore {
	
	private Allenatore allenatore;
	
	@Before
	public void setUpAllenatore() {
		allenatore = new Allenatore("PincoPallino36","Pinco","Pallino");
	}
	
	@Test
	public void testGetAllenatore() {
		assertEquals(allenatore.getUsername(),"PincoPallino36");
		assertEquals(allenatore.getNome(),"Pinco");
		assertEquals(allenatore.getCognome(),"Pallino");
	}
	
	@Test
	public void testSetAllenatore() {
		allenatore.setUsername("GiovanniGiovannini45");
		assertEquals(allenatore.getUsername(),"GiovanniGiovannini45");
		allenatore.setNome("Giovanni");
		assertEquals(allenatore.getNome(),"Giovanni");
		allenatore.setCognome("Giovannini");
		assertEquals(allenatore.getCognome(),"Giovannini");
	}

}

