package interfacceAmministratore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import controller.PersistenceException;
import dominio.Cliente;
import dominio.UserBloccato;

public class GestioneAmministratoreController implements IGestioneAmministratore {

	private Controller controller;
	
	private static String delete_account = "DELETE FROM ACCOUNT WHERE username = ? ";
	
	private static final String insert_account= "INSERT INTO ACCOUNT(username,passwordSaltHash,USERS,AMMINISTRATORE) "
			+ "VALUES (?,?,'a',NULL)";
	
	private static final String insert_users= "INSERT INTO USERS (username,nome,COGNOME,STATO ,TENTATIVILOGIN ) "
			+ "VALUES (?,?,?,?,?)";
	
	private static final String insert_cliente= "INSERT INTO CLIENTI(USERNAME,CLIENTE_ABBONATO,CLIENTE_NON_ABBONATO,ALLENATORI) VALUES (?,'c',NULL,'a')";
	
	private static final String insert_allenatori= "INSERT INTO ALLENATORI VALUES (?,?,0)";
	
	private static final String blocca_user="UPDATE USERS SET STATO = 'bloccato' WHERE  USERNAME = ?";
	
	private static final String sblocca_user="UPDATE USERS SET STATO = 'attivo' WHERE  USERNAME = ?";
	
	private static final String lista_utenti_bloccati="SELECT username,nome,cognome,motivazione FROM USERS WHERE STATO='Bloccato'";
	
	@Override
	public boolean aggiungiAllenatore(String nome, String cognome, String username, String password, String categoria) throws PersistenceException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			this.controller = new Controller();
			
			//INSERIMETNO ACCOUNT
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(insert_account);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.executeUpdate();
			statement.close();
			
			//INSERIMETNO USER
			statement = connection.prepareStatement(insert_users);
			statement.setString(1, username);
			statement.setString(2, nome);
			statement.setString(3, cognome);
			statement.setString(4, "attivo");
			statement.setInt(5, 0);
			statement.executeUpdate();
			statement.close();
			
			//INSERIMETNO CLIENTE
			statement = connection.prepareStatement(insert_cliente);
			statement.setString(1, username);
			statement.executeUpdate();
			statement.close();
			
			//INSERIMETNO ALLENATORE
			statement = connection.prepareStatement(insert_allenatori);
			statement.setString(1, username);
			statement.setString(2, categoria);
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

	@Override
	public boolean rimuoviAllenatore(String username) throws PersistenceException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			this.controller = new Controller();
			
			//rimuovi ACCOUNT
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(delete_account);
			statement.setString(1, username);
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

	@Override
	public boolean bloccaUtente(String username) throws PersistenceException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			this.controller = new Controller();
			
			//rimuovi ACCOUNT
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(blocca_user);
			statement.setString(1, username);
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

	@Override
	public boolean sbloccaUtente(String username) throws PersistenceException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			this.controller = new Controller();
			
			//rimuovi ACCOUNT
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(sblocca_user);
			statement.setString(1, username);
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

	@Override
	public List<Cliente> getUtentiBloccati() throws PersistenceException {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Cliente> result=null;
		try {
			
			this.controller = new Controller();
			
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(lista_utenti_bloccati);
			ResultSet rs = statement.executeQuery();
			
			Cliente c=null;
			if (rs.next()) {
				result=new ArrayList<Cliente>();
				do {
					c=new Cliente(rs.getString("username"), rs.getString("nome"), rs.getString("cognome"));
					UserBloccato a=new UserBloccato(c,rs.getString("motivazione"));
					c.setUserState(a);
					result.add(c);
				
				}while(rs.next());
			}
		}catch (SQLException e) {
			//throw new PersistenceException(e.getMessage());
			return null;
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
				return null;
			}
		}
		return result;
	}

}
