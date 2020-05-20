package com.pfe.pfe.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.pfe.bean.Fonctionnalite;
import com.pfe.pfe.bean.Request;
import com.pfe.pfe.mapper.FonctionnaliteMapper;
import com.pfe.pfe.service.Fonct1Service;
import com.pfe.pfe.service.Fonct2Service;
import com.pfe.pfe.service.Fonct3Service;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DSRestController {

	@Autowired
	
	Fonct1Service fonct1service;
	
	@Autowired
	
	Fonct2Service fonct2service;
	
	@Autowired
	
	Fonct3Service fonct3service;
	
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
	@PostMapping(value="/listeFonct7")
	public List<Fonctionnalite> getAllFonct3(@RequestBody Request request){
		DataSource dataSource = DataSourceBuilder
                .create()
                .username(request.getUser())
                .password(request.getPassword())
                .url(request.getUrl()+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .driverClassName(request.getDriver())
                .build();
		JdbcTemplate jdbc =  new JdbcTemplate(dataSource);
		
	return jdbc.query("select * from fonctionnalite", new FonctionnaliteMapper());
	}
	
	@PostMapping(value="/addFonct3")
	public String addfonct3(@RequestBody Fonctionnalite f) {
		fonct3service.insert(f);
		return "";
	}
	
	public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("root")
                .password("")
                .url("jdbc:mysql://localhost:3306/teste?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }
	public JdbcTemplate createJdbcTemplateFonct2Service() {
		return new JdbcTemplate(dataSource());
	}
}
