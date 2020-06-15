package com.pfe.pfe.bean;

public class ActivDesactivSQL {
	String url;
	String username;
	String password;
	String driver;
    String name ;
    String file;
    
    
    public ActivDesactivSQL (String url,String username,String password,String driver, String name , String file) {
    	this.url = url;
    	this.username = username;
    	this.password = password;
    	this.driver = driver;
    	this.name = name;
    	this.file = file;
    	
    }


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDriver() {
		return driver;
	}


	public void setDriver(String driver) {
		this.driver = driver;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}
    
    
    

}
