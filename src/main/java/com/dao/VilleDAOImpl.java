package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	@Override
	public List<Ville> getListeVilles() {

		Statement statement = null;
		ResultSet resultat = null;
		Statement statement2 = null;
		ResultSet resultat2 = null;
		List<Ville> listville = new ArrayList<Ville>();

		Connection connexion;
		try {
			connexion = JDBCConfiguration.getConnection();

			try {
				statement = connexion.createStatement();
				resultat = statement.executeQuery("SELECT * FROM ville_france;");
				while (resultat.next()) {
					Ville v = new Ville(resultat.getString("Code_commune_INSEE"), resultat.getString("Nom_commune"),
							resultat.getString("Code_postal"), resultat.getString("Libelle_acheminement"),
							resultat.getString("Ligne_5"), resultat.getString("Latitude"),
							resultat.getString("Longitude"));
					statement2 = connexion.createStatement();
					listville.add(v);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return listville;
	}
	
	@Override
	public List<String> getNomsVilles() {

		Statement statement = null;
		ResultSet resultat = null;
		Statement statement2 = null;
		ResultSet resultat2 = null;
		List<String> nom = new ArrayList<String>();

		Connection connexion;
		try {
			connexion = JDBCConfiguration.getConnection();

			try {
				statement = connexion.createStatement();
				resultat = statement.executeQuery("SELECT Nom_commune FROM ville_france;");
				while (resultat.next()) {
					nom.add(resultat.getString("Nom_commune"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return nom;
	}


}