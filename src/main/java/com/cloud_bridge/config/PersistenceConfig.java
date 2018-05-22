package com.cloud_bridge.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <pre>
 * com.knk.spring4.config
 * PersistenceConfig.java
 * </pre>
 *
 * @author	KIM_NAKKYUN
 * @date	2017. 12. 7.
 * @brief	JPA 환경 설정
 * 
 */
@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.knk.spring4.repository") // 	<jpa:repositories base-package="com.knk.spring4.repository" />
@EnableJpaRepositories(basePackages = {"com.cloud_bridge.admin.repository", "com.cloud_bridge.www.repository"})
public class PersistenceConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(PersistenceConfig.class);

	/**
	 * <pre>
	 * @return
	 * </pre>
	 *
	 * @author	KIM_NAKKYUN
	 * @date	2017. 12. 7.
	 * @brief	EntityManager 설정
	 *
	 */
	@Bean(name = "entityManagerFactory")
	public EntityManagerFactory entityManagerFactory() {
		
		logger.info("EntityMangerFactory");
		
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPersistenceUnitName("springDataTest");
		emf.setDataSource(getDataSource());	// DB 정보
		emf.setPackagesToScan(new String[] {"com.cloud.bridge.admin.entity", "com.cloud.bridge.www.entity"});	// Entity 탐색 위치

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);	// 하이버네이트 구현체 사용
		emf.setJpaProperties(additionalProperties());	// 하이버네이트 설정
		emf.afterPropertiesSet();
		
		return emf.getObject();
	}

	/**
	 * <pre>
	 * @return
	 * </pre>
	 *
	 * @author	KIM_NAKKYUN
	 * @date	2017. 12. 7.
	 * @brief	데이터베이스 설정
	 *
	 */
	@Bean
	public DataSource getDataSource() {
		
		logger.info("getDataSource");
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("knk");
		dataSource.setPassword("1111"); 		
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	/**
	 * <pre>
	 * @return
	 * </pre>
	 *
	 * @author	KIM_NAKKYUN
	 * @date	2017. 12. 7.
	 * @brief	JPA 예외를 스프링 예외로 변환
	 *
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * <pre>
	 * @return
	 * </pre>
	 *
	 * @author	KIM_NAKKYUN
	 * @date	2017. 12. 7.
	 * @brief	하이버네이트 상세설정
	 *
	 */
	Properties additionalProperties() {
		Properties properties = new Properties();
		/*properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");*/
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.use_sql_comments", "true");
		properties.setProperty("hibernate.id.new_generator_mappings", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
		return properties;
	}

}
