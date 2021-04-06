package com.dao;

import java.util.List;
import com.dto.Ville;

public interface VilleDAO {

	List<Ville> getListeVilles();

	List<String> getNomsVilles();

	List<Ville> trouverVilleParVille(Ville ville);

	Ville trouverVilleParCP(String codepostal);

	void creeUneVille(Ville ville);

	void supprimerUneVille(String codeInsee);

	void modifierUneVille(Ville ville, String codeInsee);
	
}

