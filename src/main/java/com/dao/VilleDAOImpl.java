package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
					listville.add(v);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (DaoException e1) {
			e1.printStackTrace();
		}
		return listville;
	}

	@Override
	public List<String> getNomsVilles() {

		Statement statement = null;
		ResultSet resultat = null;
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
			e1.printStackTrace();
		}
		return nom;
	}

	@Override
	public List<Ville> trouverVilleParVille(Ville ville) {

		Connection connexion;
		List<Ville> villes = new ArrayList<Ville>();
		Statement statement = null;
		ResultSet resultat = null;
		try {
			connexion = JDBCConfiguration.getConnection();

			try {

				statement = connexion.createStatement();
				resultat = statement.executeQuery(
						"SELECT * FROM ville_france WHERE Code_commune_INSEE =" + ville.getCode_commune_INSEE());

				while (resultat.next()) {
					ville = new Ville();
					ville.setNom_commune(resultat.getString("Nom_Commune"));
					ville.setCode_commune_INSEE(resultat.getString("Code_commune_INSEE"));
					ville.setCode_postal(resultat.getString("Code_postal"));
					ville.setLibelle_acheminement(resultat.getString("Libelle_acheminement"));
					ville.setLigne_5(resultat.getString("Ligne_5"));
					ville.setLatitude(resultat.getString("Latitude"));
					ville.setLongitude(resultat.getString("Longitude"));

					villes.add(ville);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (DaoException e1) {
			e1.printStackTrace();
		}
		return villes;
	}

	@Override
	public Ville trouverVilleParCP(String codepostal) {

		Connection connexion;
		Ville ville = null;
		Statement statement = null;
		ResultSet resultat = null;

		try {
			connexion = JDBCConfiguration.getConnection();

			try {

				statement = connexion.createStatement();
				resultat = statement.executeQuery("SELECT * FROM ville_france where Nom_commune =" + codepostal);

				while (resultat.next()) {
					ville = new Ville();
					ville.setNom_commune(resultat.getString("Nom_Commune"));
					ville.setCode_commune_INSEE(resultat.getString("Code_commune_INSEE"));
					ville.setCode_postal(resultat.getString("Code_postal"));
					ville.setLibelle_acheminement(resultat.getString("Libelle_acheminement"));
					ville.setLigne_5(resultat.getString("Ligne_5"));
					ville.setLatitude(resultat.getString("Latitude"));
					ville.setLongitude(resultat.getString("Longitude"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (DaoException e1) {
			e1.printStackTrace();
		}
		return ville;
	}

	@Override
	public void creeUneVille(Ville ville) {

		Connection connexion;
		try {
			connexion = JDBCConfiguration.getConnection();

			try {
				PreparedStatement preparedStatement = connexion
						.prepareStatement("INSERT INTO ville_france VALUES(?,?,?,?,?,?,?)");
				preparedStatement.setString(1, ville.getCode_commune_INSEE());
				preparedStatement.setString(2, ville.getNom_commune());
				preparedStatement.setString(3, ville.getCode_postal());
				preparedStatement.setString(4, ville.getLibelle_acheminement());
				preparedStatement.setString(5, ville.getLigne_5());
				preparedStatement.setString(6, ville.getLatitude());
				preparedStatement.setString(7, ville.getLongitude());
				try {
					preparedStatement.executeUpdate();
					System.out.println("execute");
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				connexion.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (DaoException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void supprimerUneVille(String codeInsee) {

		Connection connexion;
		try {
			connexion = JDBCConfiguration.getConnection();

			try {
				PreparedStatement preparedStatement = connexion
						.prepareStatement("DELETE FROM ville_france WHERE code_commune_INSEE = ?");
				preparedStatement.setString(1, codeInsee);
				try {
					preparedStatement.executeUpdate();
					System.out.println("execute");
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				connexion.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (DaoException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void modifierUneVille(Ville ville, String codeInsee) {

		Connection connexion;
		try {
			connexion = JDBCConfiguration.getConnection();

			try {
				PreparedStatement preparedStatement = connexion.prepareStatement(
						"UPDATE ville_france SET nom_commune = ?, code_postal = ?, libelle_acheminement = ?, ligne_5 = ?, latitude = ?, longitude= ? WHERE code_commune_INSEE = ?");
				preparedStatement.setString(1, ville.getNom_commune());
				preparedStatement.setString(2, ville.getCode_postal());
				preparedStatement.setString(3, ville.getLibelle_acheminement());
				preparedStatement.setString(4, ville.getLigne_5());
				preparedStatement.setString(5, ville.getLatitude());
				preparedStatement.setString(6, ville.getLongitude());
				preparedStatement.setString(7, codeInsee);
				try {
					preparedStatement.executeUpdate();
					System.out.println("execute");
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				connexion.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (DaoException e1) {
			e1.printStackTrace();
		}
	}

}
