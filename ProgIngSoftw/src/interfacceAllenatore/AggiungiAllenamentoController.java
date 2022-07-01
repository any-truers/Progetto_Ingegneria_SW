package interfacceAllenatore;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.Controller;
import controller.PersistenceException;
import dominio.LivelloDifficolta;

public class AggiungiAllenamentoController implements IAggiungiAllenamento {
	
	private Controller controller;
	
	private static final String insert = "INSERT INTO ALLENAMENTI ( username, titolo, durata, categoria, calorie, difficolta,file)" +
			"VALUES (?,?,?,?,?,?,?) ";
	
	@Override
	public boolean aggiungiAllenamento(String username, String titolo, int durata, String categoria,
			int calorie, LivelloDifficolta livello, File file) throws PersistenceException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			this.controller = new Controller();
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(insert);
			statement.setString(1, username);
			statement.setString(2, titolo);
			statement.setInt(3, durata);
			statement.setString(4, categoria);
			statement.setInt(5, calorie);
			statement.setString(6, livello.toString());
			statement.setString(7, file.getName());	
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
