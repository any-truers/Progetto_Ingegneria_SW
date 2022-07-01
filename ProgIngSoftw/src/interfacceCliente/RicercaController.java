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
import dominio.TipoRicerca;

public class RicercaController implements IRicerca {

	private Controller controller;

	private static String read_by_categoria = "SELECT * FROM ALLENAMENTI a,ALLENATORI al,USERS u WHERE a.username = al.username AND a.username = u.username AND UPPER(a.categoria) LIKE UPPER(?)";
	private static String read_by_titolo = "SELECT * FROM ALLENAMENTI a,ALLENATORI al,USERS u WHERE a.username = al.username AND a.username = u.username AND UPPER(a.titolo) LIKE UPPER(?)";
	private static String read_by_nomeAllenatore = "SELECT * FROM ALLENAMENTI a,ALLENATORI al,USERS u WHERE a.username = al.username AND a.username = u.username AND UPPER(u.nome) LIKE UPPER(?)";
	private static String read_by_tutti = "SELECT * FROM ALLENAMENTI a,ALLENATORI al,USERS u WHERE a.username = al.username AND a.username = u.username AND UPPER(a.categoria) LIKE UPPER(?) OR UPPER(a.titolo) LIKE UPPER(?) OR"
			+ "UPPER(u.nome) LIKE UPPER(?)";

	@Override
	public List<Allenamento> ricerca(String testo, TipoRicerca tipo) throws PersistenceException {
		// TODO Auto-generated method stub

		List<Allenamento> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		String usernameA;
		String titolo;
		int durata;
		String categoria;
		int calorie;
		LivelloDifficolta difficolta;
		File file;
		try {

			this.controller = new Controller();
			connection = controller.openConnection("B");
			if (tipo.toString().equalsIgnoreCase("categoria")) {
				statement = connection.prepareStatement(read_by_categoria);
				statement.setString(1, testo + "%");
			}
			else if(tipo.toString().equalsIgnoreCase("titolo")) {
				statement = connection.prepareStatement(read_by_titolo);
				statement.setString(1, testo + "%");
			}
			else if(tipo.toString().equalsIgnoreCase("nome_Allenatore")) {
				statement = connection.prepareStatement(read_by_nomeAllenatore);
				statement.setString(1, testo + "%");
			}
			else if(tipo.toString().equalsIgnoreCase("tutti")) {
				statement = connection.prepareStatement(read_by_tutti);
				statement.setString(1, testo + "%");
				statement.setString(2, testo + "%");
				statement.setString(3, testo + "%");
			}
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				
				usernameA = rs.getString("username");
				titolo = rs.getString("titolo");
				durata = rs.getInt("durata");
				categoria = rs.getString("categoria");
				calorie = rs.getInt("calorie");
				difficolta = LivelloDifficolta.valueOf(rs.getString("difficolta").toUpperCase());
				file = new File(titolo);
				Allenatore allenatore=new Allenatore(usernameA,rs.getString("nome"),rs.getString("cognome"));
				Allenamento a = new Allenamento( titolo, durata, categoria, calorie, file, difficolta,allenatore);
				result.add(a);
				
			} else
				result = null;
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
