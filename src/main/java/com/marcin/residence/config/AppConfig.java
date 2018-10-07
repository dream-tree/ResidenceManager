package com.marcin.residence.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Configures the application, creates the appropriate beans for ViewResolver, DataSource, SessionFactory,
 * TransactionManager, MessageSource and adds the resource handlers.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.marcin.residence")
@PropertySource({ "classpath:persistence-mysql.properties", 
	"classpath:security-persistence-mysql.properties" })
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {	
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");	
		return viewResolver;
	}
	
	@Bean
	public DataSource dataSource() {	
		ComboPooledDataSource dataSource = new ComboPooledDataSource();	
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		logger.info(">> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">> jdbc.user=" + env.getProperty("jdbc.user"));
				
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));	
		
		dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));		
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
		return localSessionFactoryBean;
	}
	
	private final Properties getHibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return hibernateProperties;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
 
	@Bean
	public DataSource securityDataSource() {	
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		try {
			securityDataSource.setDriverClass(env.getProperty("security.jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		logger.info(">> security.jdbc.url=" + env.getProperty("security.jdbc.url"));
		logger.info(">> security.jdbc.user=" + env.getProperty("security.jdbc.user"));
		
		securityDataSource.setJdbcUrl(env.getProperty("security.jdbc.url"));
		securityDataSource.setUser(env.getProperty("security.jdbc.user"));
		securityDataSource.setPassword(env.getProperty("security.jdbc.password"));
		
		securityDataSource.setInitialPoolSize(getIntProperty("security.connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("security.connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("security.connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("security.connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
    @Bean
    public MessageSource messageSource () {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("ValidationMessages");
        return messageSource;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
    }
    
	private int getIntProperty(String propName) {		
		String propVal = env.getProperty(propName);	
		int intPropVal = Integer.parseInt(propVal);		
		return intPropVal;
	}
}