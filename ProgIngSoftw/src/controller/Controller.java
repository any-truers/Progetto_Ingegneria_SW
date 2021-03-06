package controller;

import java.sql.*;

public class Controller {
	
	private Connection dbConnection;
	
	public Connection openConnection(String s) throws PersistenceException {
		
		this.dbConnection = null;
		try { 
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			
			this.dbConnection = DriverManager.getConnection("jdbc:db2://diva.deis.unibo.it:50000/tw_stud","USER","PASSW");
			
			//this.dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=");
      }
      catch (ClassNotFoundException e) {
          throw new PersistenceException(e.getMessage());
      }
      catch(SQLException e) {
          throw new PersistenceException(e.getMessage());
      }
		return this.dbConnection; 
	}
}
