package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dao.DaoException;
import com.dao.VilleDAO;
import com.dao.VilleDAOImpl;
import com.dto.Ville;

@RestController
public class VilleController {
	
	@Autowired
	VilleBLO villeBLO;
	
	@RequestMapping(value="/villes",method=RequestMethod.GET)
	@ResponseBody
	public List<Ville> appelVilles()
	{
		System.out.println("liste des villes");
		return villeBLO.getListeVilles();
	}
	
	@RequestMapping(value="/villesnoms",method=RequestMethod.GET)
	@ResponseBody
	public List<String> appelNomVilles()
	{
		System.out.println("liste des noms de villes");
		return villeBLO.getListeNomsVilles();
	}
}