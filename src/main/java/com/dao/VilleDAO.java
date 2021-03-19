package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface VilleDAO {
	/**
	 * Implémentation fichiers
	 * @return
	 */
	
	/**
	 * Implémentation BD localhost
	 * @return
	 * @throws DaoException 
	 */
	public static VilleDAOImpl getImpl() throws DaoException {
		String connectionURL = "jdbc:mysql://localhost:3306/villefrance"; 
		// load driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			throw new DaoException("Impossible de se connected à la base de données");
			//e2.printStackTrace();
		}
		
		// connexion BD
		Connection connexion = null;
		try {
			//Connection connection = DriverManager.getConnection(connectionURL, "root", "");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/villefrance?user=root&password=");
			connexion.setAutoCommit(false);
		} catch (SQLException e1) {
			throw new DaoException("Impossible de se connected à la base de données");
			//e1.printStackTrace();
		}
		
		return new VilleDAOImpl(connexion);
	}

}

