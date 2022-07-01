package test;
import static org.junit.Assert.*;

import org.junit.*;

import dominio.Cliente;

public class TestCliente {
	
	private Cliente cliente;
	
	@Before
	public void setUpCliente() {
		cliente = new Cliente("PincoPallino36","Pinco","Pallino");
	}
	
	@Test
	public void testGetCliente() {
		assertEquals(cliente.getUsername(),"PincoPallino36");
		assertEquals(cliente.getNome(),"Pinco");
		assertEquals(cliente.getCognome(),"Pallino");
	}
	
	@Test
	public void testSetCliente() {
		cliente.setUsername("GiovanniGiovannini45");
		assertEquals(cliente.getUsername(),"GiovanniGiovannini45");
		cliente.setNome("Giovanni");
		assertEquals(cliente.getNome(),"Giovanni");
		cliente.setCognome("Giovannini");
		assertEquals(cliente.getCognome(),"Giovannini");
	}
	

}

