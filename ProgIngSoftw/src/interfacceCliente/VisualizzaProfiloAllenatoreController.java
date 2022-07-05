package interfacceCliente;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import controller.PersistenceException;
import dominio.Allenamento;
import dominio.Allenatore;
import dominio.LivelloDifficolta;

public class VisualizzaProfiloAllenatoreController implements IVisualizzaProfiloAllenatore {
	
	private Controller controller;
	
	private static final String dati_allenatore="SELECT nome,cognome FROM USERS WHERE USERNAME = ?";
	
	private static final String lista_allenamenti_caricati="SELECT A.username,U.nome,U.cognome,AL.durata,AL.categoria,AL.file,AL.titolo,AL.calorie,AL.difficolta "
			+ "FROM ALLENAMENTI AL,ALLENATORI A,USERS U "
			+ "WHERE AL.USERNAME=A.USERNAME "
			+ "AND AL.USERNAME = ? "
			+ "AND AL.USERNAME =U.USERNAME ";
	
	private static final String valutazione_allenatore="SELECT valutazioneMedia FROM Allenatori WHERE USERNAME = ? ";
	
	private static final String categoria_allenatore="SELECT categoria FROM Allenatori WHERE USERNAME = ? ";
	
	private List<Allenamento> getAllenamentiCaricati(String usernameAll) throws PersistenceException{
		Connection connection = null;
		PreparedStatement statement = null;
		List<Allenamento> result=null;
		try {
			
			this.controller = new Controller();
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(lista_allenamenti_caricati);
			statement.setString(1, usernameAll);
			ResultSet rs = statement.executeQuery();
			
			Allenamento a=null;
			if (rs.next()) {
				result=new ArrayList<Allenamento>();
				do {
					Allenatore allenatore=new Allenatore(usernameAll, rs.getString("nome"), rs.getString("cognome"));
					a=new Allenamento(rs.getString("titolo"), rs.getInt("durata"), 
							rs.getString("categoria"), rs.getInt("calorie"), new File(rs.getString("file")),
							LivelloDifficolta.valueOf(rs.getString("difficolta").toUpperCase()),allenatore);
					
					result.add(a);
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

	
	private String getCategoria(String usernameAll) throws PersistenceException{
		Connection connection = null;
		PreparedStatement statement = null;
		String result=null;
		try {
			
			this.controller = new Controller();
			
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(categoria_allenatore);
			statement.setString(1, usernameAll);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
					result=rs.getString("categoria"); 
			}
			else {
				//non è stato trovato nessun allenatore;
				return result;
			}
		}catch (SQLException e) {
			//throw new PersistenceException(e.getMessage());
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
				//throw new PersistenceException(e.getMessage());
				return result;
			}
		}
		
		return result;
	}

	@Override
	public boolean seguiAllenatore(String username, String usernameAll) throws PersistenceException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean smettiDiSeguireAllenatore(String username, String usernameAll) throws PersistenceException {
		// TODO Auto-generated method stub
		return false;
	}

	
	private float getValutazione(String usernameAll) throws PersistenceException{
		Connection connection = null;
		PreparedStatement statement = null;
		float result=-1;
		try {
			
			this.controller = new Controller();
			
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(valutazione_allenatore);
			statement.setString(1, usernameAll);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
					result=rs.getFloat("valutazionemedia"); 
			}
			else {
				//non è stato trovato nessun allenatore;
				return result;
			}
		}catch (SQLException e) {
			//throw new PersistenceException(e.getMessage());
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
				//throw new PersistenceException(e.getMessage());
				return result;
			}
		}
		
		return result;
	}


	@Override
	public Allenatore visualizzaProfilo(String username) throws PersistenceException{
		
		Connection connection = null;
		PreparedStatement statement = null;
		String nome =" ";
		String cognome = "";
		Allenatore a=null;
		try {
			
			this.controller = new Controller();
			
			connection = controller.openConnection("B");
			statement = connection.prepareStatement(dati_allenatore);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
					nome=rs.getString("nome"); 
					cognome=rs.getString("cognome");	
			}
			else {
				//non è stato trovato nessun allenatore;
				return null;
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
		
		a = new Allenatore(username, nome, cognome);
		
		a.setAllenamentiCaricati(this.getAllenamentiCaricati(username));
		
		if(this.getValutazione(username)<0) {
			
			return null;
		}else {
			a.setValutazioneMedia(this.getValutazione(username));
		}
		
		a.setCategoria(this.getCategoria(username));
		
		return a;
	}

}
