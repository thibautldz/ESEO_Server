package com.blo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;

	public List<Ville> getListeVilles() {
		List<Ville> ville;

		ville = villeDAO.getListeVilles();
		return ville;
	}

	public List<String> getListeNomsVilles() {
		List<String> ville;

		ville = villeDAO.getNomsVilles();
		return ville;
	}
	
	public List<Ville> gettrouverVilles(Ville vil) {
		List<Ville> ville;

		ville = villeDAO.trouverVilleParVille(vil);
		return ville;
	}
	
	public Ville getVilleParCP(String codepostal) {
		Ville ville;
		
		ville = villeDAO.trouverVilleParCP(codepostal);
		return ville;
	}
	
	public void creerUneVille(Ville ville) {
		villeDAO.creeUneVille(ville);;
	}
	
	public void supprimerUneVille(String codeInsee) {
		villeDAO.supprimerUneVille(codeInsee);
	}
	
	public void modifierUneVille(Ville ville, String codeInsee) {
		villeDAO.modifierUneVille(ville, codeInsee);
	}
}
