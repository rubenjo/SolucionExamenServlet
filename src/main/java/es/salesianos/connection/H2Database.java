package es.salesianos.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class H2Database {

	@Bean
	@Profile(value = "h2")
  	public DriverManagerDataSource h2DataSource() {
  		DriverManagerDataSource dataSource = new DriverManagerDataSource();
  		dataSource.setDriverClassName("org.h2.Driver");
  		dataSource.setUrl("jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'");
  		dataSource.setUsername("h2");
  		dataSource.setPassword("");
  		return dataSource;
  	}
}
