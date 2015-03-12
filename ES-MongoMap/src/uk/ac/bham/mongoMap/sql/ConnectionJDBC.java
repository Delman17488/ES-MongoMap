package uk.ac.bham.mongoMap.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
	private Connection connection = null;
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void getConnectionJDBC(String url, String username,String password){	
		try{
			this.connection = DriverManager.getConnection(url, username, password);
		}catch(SQLException e){
			System.out.println(e.getMessage());
			System.out.println("sql ex driver");
		}
		
	}
	
}
