package com.springboot.multipleDB.config.db1;


import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = {"com.springboot.multipleDB.repo.db1"}, transactionManagerRef = "transactionManager")
public class DB1Config {

	@Primary
	@Bean(name = "datasource")
	@ConfigurationProperties(prefix = "spring.db1.datasource")
	public DataSource datasource() {
		
		return DataSourceBuilder.create().build();
	}
	
	  @Primary
	  @Bean(name = "entityManagerFactory") 
	  public LocalContainerEntityManagerFactoryBean db1EntityManagerFactoryBean(EntityManagerFactoryBuilder
	  entityManagerFactoryBuilder,@Qualifier("datasource") DataSource
	  dataSource) {
	  
	  Map<String, Object> properties = new HashMap();
	  properties.put("hibernate.hbm2ddl.auto", "update");
	  properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");	  
	  return
	  entityManagerFactoryBuilder.dataSource(dataSource).properties(properties).
	  packages("com.springboot.multipleDB.model.db1").persistenceUnit(
	  "DB1Model").build(); }
	 
	
	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager db1TransactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		
		return new JpaTransactionManager(entityManagerFactory);
	}
}
