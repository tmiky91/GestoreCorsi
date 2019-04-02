package it.polito.tdp.corsi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	public static Connection getConnection() {
		
		String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root";
		Connection conn;
		try {
			conn = DriverManager.getConnection(jdbcURL);
			
		} catch (SQLException e) {
			System.out.println("Errore caricamento database");
			throw new RuntimeException(e);
		}
		return conn;

	}
}
