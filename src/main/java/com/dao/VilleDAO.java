package com.dao;

import java.util.List;
import com.dto.Ville;

public interface VilleDAO {

	List<Ville> getListeVilles();

	List<String> getNomsVilles();
	
}

