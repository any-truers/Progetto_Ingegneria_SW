package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import dominio.Valutazione;
import interfacceCliente.ValutazioneController;

public class TestValutazione {
	
	@Test
	public void TestValutazioneAllenatore() {
		String usernameUser = "GaiaBianchi";
		String usernameAll = "PincoPallino36";
		int manubri = 3;
		ValutazioneController vc = new ValutazioneController();
		Valutazione v = new Valutazione(manubri, usernameUser, usernameAll);
		boolean res = false;
		res = vc.valutaAllenatore(usernameUser,v);
		assertEquals(res,true);
	}
	
}





