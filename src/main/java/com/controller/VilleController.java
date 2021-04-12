package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {

	@Autowired
	VilleBLO villeBLO;

	// OK
	@RequestMapping(value = "/villes", method = RequestMethod.GET)
	@ResponseBody
	public List<Ville> appelVilles() {
		System.out.println("liste des villes");
		return villeBLO.getListeVilles();
	}

	// OK
	@RequestMapping(value = "/nomsvilles", method = RequestMethod.GET)
	@ResponseBody
	public List<String> appelNomVilles() {
		System.out.println("liste des noms de villes");
		return villeBLO.getListeNomsVilles();
	}

	/*
	 * @RequestMapping(value = "/villecp", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public Ville ville(@RequestParam(value = "cp") String cp) {
	 * 
	 * return villeBLO.getVilleParCP(cp); }
	 */

	// OK
	@GetMapping(value = "/ville")
	public List<Ville> trouver(@RequestParam(name = "codeInsee", defaultValue = "") String codeInsee) {
		Ville ville = new Ville();
		ville.setCode_commune_INSEE(codeInsee);
		System.out.println("ville par code insee");
		System.out.println(codeInsee);
		return villeBLO.gettrouverVilles(ville);
	}

	// OK
	@PostMapping(value = "/ville")
	public void CreerUneVille(@RequestBody Ville Ville) {
		System.out.println("ville créée");
		villeBLO.creerUneVille(Ville);
	}

	// OK
	@PutMapping(value = "/ville/{codeInsee}")
	public void modifier(@RequestBody Ville ville, @PathVariable("codeInsee") String codeInsee) {
		System.out.println("ville modifiée");
		villeBLO.modifierUneVille(ville, codeInsee);
	}

	// OK
	@DeleteMapping(value = "/ville/{codeInsee}")
	public void supprimer(@PathVariable("codeInsee") String codeInsee) {
		System.out.println("ville supprimée");
		System.out.println(codeInsee);
		System.out.println(codeInsee);
		villeBLO.supprimerUneVille(codeInsee);
	}
}