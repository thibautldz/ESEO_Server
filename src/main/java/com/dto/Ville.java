package com.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ville implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6148940624560946029L;
	String Code_commune_INSEE;
	String Nom_commune;
	String Code_postal;
	String Libelle_acheminement;
	String Ligne_5;
	String Latitude;
	String Longitude;
}
