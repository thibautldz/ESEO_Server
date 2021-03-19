package com.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VilleDAOImpl implements VilleDAO{
	
	private Connection connexion;

	public VilleDAOImpl(Connection connexion) {
		this.connexion = connexion;
	}

	public List<String> getListeVille() {
		 Statement statement = null;
	     ResultSet resultat = null;
	     Statement statement2 = null;
	     ResultSet resultat2 = null;
	     List<String> res = new ArrayList<String>();
		try {
			statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT v.Nom_commune FROM ville_france v;");
            while (resultat.next()) {
            	String v = new String(resultat.getString("Nom_Commune"));
            	statement2 = connexion.createStatement();
                res.add(v);
            }	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}