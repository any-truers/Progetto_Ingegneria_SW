package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Controller;
import controller.PersistenceException;

public class LoginController implements ILogin {

	private Controller controller;

	private static final String select = "SELECT username, users FROM ACCOUNT a WHERE username = ? AND passwordsalthash = ?";
	
	@Override
	public String autenticazione(String username, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		String result = null;
		controller = new Controller();
		try {
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(select);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				if(rs.getString("users").equals("c")) {
					return "cliente";
				}
				else if(rs.getString("users").equals("a")) {
					return "allenatore";
				}
				else {
					return "amministratore";
				}
			}
			else
				return result;
		}  catch (SQLException e) {
			e.printStackTrace();
			return result;
		} catch (PersistenceException e) {
			e.printStackTrace();
			return result;
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
				return result;
			}
		}
	}

}
