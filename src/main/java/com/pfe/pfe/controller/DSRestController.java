package com.pfe.pfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.pfe.bean.Fonctionnalite;
import com.pfe.pfe.service.Fonct1Service;
import com.pfe.pfe.service.Fonct2Service;

@RestController
public class DSRestController {

	@Autowired
	
	Fonct1Service fonct1service;
	
	@Autowired
	
	Fonct2Service fonct2service;
	
	@RequestMapping(value="/listeFonct1")
	public List<Fonctionnalite> getAllFonct1(){
	
	return fonct1service.findAll();
	}
	
	@PostMapping(value="/addFonct1")
	public String addfonct1(@RequestBody Fonctionnalite f) {
		fonct1service.insert(f);
		return "";
	}
	
	@RequestMapping(value="/listeFonct2")
	public List<Fonctionnalite> getAllFonct2(){
	
	return fonct2service.findAll();
	}
	
	@PostMapping(value="/addFonct2")
	public String addfonct2(@RequestBody Fonctionnalite f) {
		fonct2service.insert(f);
		return "";
	}
}
