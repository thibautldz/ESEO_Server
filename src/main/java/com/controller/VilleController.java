package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.DaoException;
import com.dao.VilleDAO;
import com.dao.VilleDAOImpl;

@RestController
public class VilleController {
	@RequestMapping(value="/ville",method=RequestMethod.GET)
	@ResponseBody
	public List<String> appelVille()
	{
		VilleDAOImpl VilleDB = null;
		try {
			VilleDB = VilleDAO.getImpl();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return VilleDB.getListeVille();
	}
}