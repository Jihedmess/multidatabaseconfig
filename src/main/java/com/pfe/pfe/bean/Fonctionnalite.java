package com.pfe.pfe.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Fonctionnalite {

	 private Integer id;
	
	   private String name;

	   private String desscription;
	   private String fileActivation;
	   private String filaDesactivation;
	   private String fileChek;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesscription() {
		return desscription;
	}
	public void setDesscription(String desscription) {
		this.desscription = desscription;
	}
	public String getFileActivation() {
		return fileActivation;
	}
	public void setFileActivation(String fileActivation) {
		this.fileActivation = fileActivation;
	}
	public String getFilaDesactivation() {
		return filaDesactivation;
	}
	public void setFilaDesactivation(String filaDesactivation) {
		this.filaDesactivation = filaDesactivation;
	}
	public String getFileChek() {
		return fileChek;
	}
	public void setFileChek(String fileChek) {
		this.fileChek = fileChek;
	}
	  

	  
	}
