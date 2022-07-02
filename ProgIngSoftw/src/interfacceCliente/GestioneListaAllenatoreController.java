package interfacceCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import controller.PersistenceException;
import dominio.Allenatore;

public class GestioneListaAllenatoreController implements IGestioneListaAllenatore {

	private Controller controller;
	private static String getAllenatori = "SELECT * FROM SEGUE s, ALLENATORI a, USERS u WHERE a.username = s.username_allenatore AND a.username = u.username AND s.username_USER = ?";

	@Override
	public List<Allenatore> getAllenatoriSeguiti(String username) throws PersistenceException {
		// TODO Auto-generated method stub

		List<Allenatore> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		Allenatore a = null;
		String uA;
		String n;
		String c;
		this.controller = new Controller();
		try {
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(getAllenatori);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				uA = rs.getString("username_allenatore");
				n = rs.getString("nome");
				c = rs.getString("cognome");
				a = new Allenatore(uA,n,c);
				a.setCategoria(rs.getString("categoria"));
				a.setValutazioneMedia(rs.getFloat("valutazioneMedia"));
				result.add(a);
			}
			return result;
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		
	}

}
