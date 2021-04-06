package com.blo;

import java.util.List;
import com.dto.Ville;

public interface VilleBLO {

	List<Ville> getListeVilles();
	
	List<String> getListeNomsVilles();
	
	List<Ville> gettrouverVilles(Ville vil);
	
	Ville getVilleParCP(String codepostal);
	
	void creerUneVille(Ville ville);
	
	void supprimerUneVille(String codeInsee);
	
	void modifierUneVille(Ville ville, String codeInsee);

}
