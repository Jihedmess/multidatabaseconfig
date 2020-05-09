package com.pfe.pfe.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {
	
	private Environment env;
	
	@Bean(name="dbFonc1Service")
	@ConfigurationProperties(prefix="spring.datasource.test1")
	public DataSource createFonct1ServiceDataSource() {
		/*DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(env.getProperty("app.datasource1.driverClassName"));
	    dataSource.setUrl(env.getProperty("app.datasource1.url"));
	    dataSource.setUsername(env.getProperty("app.datasource1.username"));
	    //dataSource.setPassword(env.getProperty("app.datasource1.password"));*/
		return DataSourceBuilder.create().build();
		
	}
	
	@Bean(name="dbFonct2Service")
	@ConfigurationProperties(prefix="spring.datasource.test2")
	public DataSource createFonct2ServiceDataSource() {
		return DataSourceBuilder.create().build();
		
	}
	
	
	@Bean(name="jdbcFonct1Service")
	@Autowired
	public JdbcTemplate createJdbcTemplateFonct1Service(@Qualifier("dbFonc1Service") DataSource fonctService1) {
		return new JdbcTemplate(fonctService1);
	}
	@Bean(name="jdbcFonct2Service")
	@Autowired
	public JdbcTemplate createJdbcTemplateFonct2Service(@Qualifier("dbFonct2Service") DataSource fonctService2) {
		return new JdbcTemplate(fonctService2);
	}
	

}
