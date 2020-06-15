package com.pfe.pfe.bean;

public class ResponseChek {
	 private Integer id;
		
	   private String name;

	   private String desscription;
	   private String fileActivation;
	   private String filaDesactivation;
	   private String fileChek;
	   
	   private  Integer result; 
	   
	 public  ResponseChek( Integer id ,String name, String desscription,String fileActivation, String filaDesactivation, String fileChek, Integer result ){
		  this.id= id;
		  this.name = name;
		  this.desscription = desscription;
		  this.fileActivation  = fileActivation;
		  this.filaDesactivation = filaDesactivation;	
		  this.fileChek = fileChek;
		  this.result = result;
		  
	   }

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

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}
	   
	   
	   
	   

}
