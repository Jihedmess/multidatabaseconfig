package com.pfe.pfe.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.pfe.bean.ActivDesactivSQL;
import com.pfe.pfe.bean.Fonctionnalite;
import com.pfe.pfe.bean.ResponseChek;
import com.pfe.pfe.bean.SQLBody;
import com.pfe.pfe.mapper.FonctionnaliteMapper;
import com.pfe.pfe.service.Fonct1Service;
import com.pfe.pfe.service.Fonct2Service;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DSRestController {

	
	
    public List<Fonctionnalite> findAllMP() throws SQLException {

		JdbcTemplate jdbcTemplate = createJdbcTemplateFonct2Service("root","root","jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","com.mysql.jdbc.Driver");
		
		  List<Fonctionnalite> fonctionalites = jdbcTemplate.query("SELECT * FROM `fonctionalite`", new FonctionnaliteMapper());
		  jdbcTemplate.getDataSource().getConnection().close();
		  return fonctionalites;
		 
		 
		 
       
    }
	
	
	@PostMapping(value="/checkSql")
	public  ArrayList ExecuteSql(@RequestBody SQLBody sqlBody) throws IOException, SQLException {
		ArrayList array = new ArrayList();
		JdbcTemplate jdbcTemplate = createJdbcTemplateFonct2Service(sqlBody.getUsername(),sqlBody.getPassword(),sqlBody.getUrl(),sqlBody.getDriver());
		
		List<Fonctionnalite> listFonctionalite = findAllMP();
		for( Fonctionnalite item : listFonctionalite) {
			FileReader fr=new FileReader("C:\\Users\\ASUS\\Desktop\\fonctionnalés\\"+item.getName()+"\\"+item.getFileChek());    
	        int i;    
	        StringBuffer sb = new StringBuffer();
	        while((i=fr.read())!=-1)  {
	      
	       sb.append((char)i);
	        }  
	        System.out.println(sb);
	            
	        fr.close(); 
	      Integer i1 =  jdbcTemplate.queryForObject(sb.toString(),Integer.class);
	      
	      ResponseChek check = new ResponseChek(item.getId(),item.getName(),item.getDesscription(),item.getFileActivation(),item.getFilaDesactivation(),item.getFileChek(),i1);
	      array.add(check);
		}
		jdbcTemplate.getDataSource().getConnection().close();
				
		return array;
		
	}
	
	@PostMapping(value="/UpdateSQL")
	public  String ExecuteActivation(@RequestBody ActivDesactivSQL sqlBody) throws IOException, SQLException {
		
		JdbcTemplate jdbcTemplate = createJdbcTemplateFonct2Service(sqlBody.getUsername(),sqlBody.getPassword(),sqlBody.getUrl(),sqlBody.getDriver());
		
	
			FileReader fr=new FileReader("C:\\Users\\ASUS\\Desktop\\fonctionnalés\\"+sqlBody.getName()+"\\"+sqlBody.getFile());    
	        int i;    
	        StringBuffer sb = new StringBuffer();
	        while((i=fr.read())!=-1)  {
	      
	       sb.append((char)i);
	        }  
	        System.out.println(sb);
	            
	        fr.close(); 
	      jdbcTemplate.execute(sb.toString());
	      
	     
	      jdbcTemplate.getDataSource().getConnection().close();
		return "Update Table";
		
	}
	
	public DataSource dataSource(String username ,String password , String url , String driver) {
        return DataSourceBuilder
                .create()
                .username(username)
                .password(password)
                .url(url+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC")  
                .driverClassName(driver)
                .build();
    }
	
	public JdbcTemplate createJdbcTemplateFonct2Service(String username ,String password , String url , String driver) {
		return new JdbcTemplate(dataSource(username ,password , url , driver));
	}
}
