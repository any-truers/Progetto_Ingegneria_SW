package interfacceCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import controller.Controller;
import controller.PersistenceException;
import dominio.Valutazione;

public class ValutazioneController implements IValutazione {
	
	private Controller controller;
	
	private static final String insert = "INSERT INTO VALUTAZIONE VALUES (?,?,?,?)";
	
	@Override
	public boolean valutaAllenatore(String username, Valutazione v) {
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		controller = new Controller();
		try {
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(insert);
			statement.setString(1, v.getUsernameCliente());
			statement.setString(2, v.getUsernameAllenatore());
			statement.setInt(3, v.getManubri());
			statement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			statement.executeUpdate();
		}  catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

}
