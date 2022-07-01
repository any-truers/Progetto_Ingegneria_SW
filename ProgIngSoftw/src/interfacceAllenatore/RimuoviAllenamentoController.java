package interfacceAllenatore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.Controller;
import controller.PersistenceException;
import dominio.Allenamento;

public class RimuoviAllenamentoController implements IRimuoviAllenamento {
	
	private Controller controller;
	
	private static String delete = "DELETE " +
			"FROM ALLENAMENTI " +
			"WHERE username = ? AND titolo = ?";

	@Override
	public boolean rimuoviAllenamento(Allenamento allenamento, String username) throws PersistenceException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			this.controller = new Controller();
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(delete);
			statement.setString(1, username);
			statement.setString(2, allenamento.getTitolo());
			statement.executeUpdate();
			
		}catch (SQLException e) {
			//throw new PersistenceException(e.getMessage());
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
				//throw new PersistenceException(e.getMessage());
				return false;
			}
		}
		
		return true;
	}

}
