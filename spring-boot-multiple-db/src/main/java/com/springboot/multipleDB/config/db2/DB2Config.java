package com.springboot.multipleDB.config.db2;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "db2EntityManagerFactory", basePackages = {"com.springboot.multipleDB.repo.db2"}, transactionManagerRef = "db2TransactionManager")
public class DB2Config {

	@Bean(name = "db2Datasource")
	@ConfigurationProperties(prefix = "spring.db2.datasource")
	public DataSource datasource() {
		
		return DataSourceBuilder.create().build();
	}
	
	  @Bean(name = "db2EntityManagerFactory")
	  public LocalContainerEntityManagerFactoryBean db2EntityManagerFactoryBean(EntityManagerFactoryBuilder
	  entityManagerFactoryBuilder,@Qualifier("db2Datasource") DataSource
	  dataSource) {
		  Map<String, Object> properties = new HashMap();
		  properties.put("hibernate.hbm2ddl.auto", "update");
		  properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");	  
		  
	  return entityManagerFactoryBuilder.dataSource(dataSource).properties(properties).packages(
	  "com.springboot.multipleDB.model.db2").persistenceUnit("DB2Model").build
	  (); }
	 
	
	@Bean(name = "db2TransactionManager")
	public PlatformTransactionManager db2TransactionManager(@Qualifier("db2EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		
		return new JpaTransactionManager(entityManagerFactory);
	}
}
