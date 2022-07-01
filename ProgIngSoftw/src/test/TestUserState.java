package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import dominio.Allenatore;
import dominio.Cliente;
import dominio.ClienteConAbbonamento;
import dominio.ClienteSenzaAbbonamento;
import dominio.StatoAbbonamento;
import dominio.UserAttivo;
import dominio.UserBloccato;
import dominio.UserState;

public class TestUserState {
	
	private Allenatore allenatore;
	private Cliente cliente;
	
	@Before
	public void setUp() {
		allenatore = new Allenatore("PincoPallino36","Pinco","Pallino");
		UserState statoAllenatore = new UserAttivo(allenatore);
		allenatore.setUserState(statoAllenatore);
		cliente = new Cliente("GaiaBianchi","Gaia","Bianchi");
		StatoAbbonamento statoAbbonamento = new ClienteConAbbonamento(cliente);
		cliente.setStatoAbbonamento(statoAbbonamento);
		UserState statoCliente = new UserBloccato(cliente,"troppi tentativi di accesso");
		cliente.setUserState(statoCliente);
	}
	@Test
	public void testUserState() {
		assertEquals(allenatore.getUserState().getStato(),"Attivo");
		assertEquals(cliente.getStatoAbbonamento().getStato(),"Abbonato");
		assertEquals(cliente.getUserState().getStato(),"Bloccato");
		UserState statoCliente = new UserAttivo(cliente);
		cliente.setUserState(statoCliente);
		assertNotEquals(cliente.getUserState().getStato(),"Bloccato");
		StatoAbbonamento statoAbbonamento = new ClienteSenzaAbbonamento(cliente);
		cliente.setStatoAbbonamento(statoAbbonamento);
		assertNotEquals(cliente.getStatoAbbonamento().getStato(),"Abbonato");
	}
}



