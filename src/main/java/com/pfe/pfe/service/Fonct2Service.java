package com.pfe.pfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pfe.pfe.bean.Fonctionnalite;
import com.pfe.pfe.mapper.FonctionnaliteMapper;
@Repository
public class Fonct2Service {
	@Qualifier("jdbcFonct2Service")
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List < Fonctionnalite > findAll() {
	    return jdbcTemplate.query("select * from fonctionnalite", new FonctionnaliteMapper());
	}





	public int insert(Fonctionnalite f) {
	    return jdbcTemplate.update("insert into fonctionnalite (id, name, desscription, fileActivation, filaDesactivation, fileChek) " + "values(?, ?, ?, ?, ?, ?)",
	        new Object[] {
	            f.getId(), f.getName(), f.getDesscription(),f.getFileActivation(),f.getFilaDesactivation(),f.getFileChek()
	        });
	}
}
