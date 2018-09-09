package com.marcin.residence.config;
/*package com.marcin.residence;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.assertj.core.util.Preconditions;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:core.properties" })
@ComponentScan(value = "com.test")
public class Temp {   // by sb in net https://discourse.hibernate.org/t/hibernate-5-2-sessionfactory-metadata-and-nullpointerexception/706
  //  private static Logger logger = Logger.getLogger(Temp.class);
    private final static String HIBERNATE_DIALECT = "org.hibernate.dialect.PostgreSQL95Dialect";

    @Autowired private Environment env;
    @Autowired private ResourceLoader resourceLoader;

    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan(new String[] { "com.test.core.domain.*" });
        localSessionFactoryBean.setMappingLocations(loadResources());
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        localSessionFactoryBean.afterPropertiesSet();

        return localSessionFactoryBean.getObject();
    }

    private Resource[] loadResources() {
        Resource[] resources = null;
        try {
            resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                    .getResources("classpath:/hibernate/**.hbm.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resources;
    }

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource сomboPooledDataSource = new ComboPooledDataSource();
        try {
            сomboPooledDataSource.setDriverClass(Preconditions.checkNotNull(env.getProperty("jdbc.driver-class-name")));
        } catch( PropertyVetoException pve ){
//            logger.error("Cannot load datasource driver (" + env.getProperty("jdbc.driver-class-name") +"): " + pve.getMessage());
            return null;
        }

        сomboPooledDataSource.setJdbcUrl(Preconditions.checkNotNull(env.getProperty("jdbc.url")));
        сomboPooledDataSource.setUser(Preconditions.checkNotNull(env.getProperty("jdbc.username")));
        сomboPooledDataSource.setPassword(Preconditions.checkNotNull(env.getProperty("jdbc.password")));

        сomboPooledDataSource.setMinPoolSize(20);
        сomboPooledDataSource.setMaxPoolSize(50);
        сomboPooledDataSource.setCheckoutTimeout(15);
        сomboPooledDataSource.setMaxStatements(0);
        сomboPooledDataSource.setIdleConnectionTestPeriod(30);

        return сomboPooledDataSource;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) throws Exception {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private static Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", HIBERNATE_DIALECT);
        properties.setProperty("hibernate.bytecode.use_reflection_optimizer", "true");
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
        properties.setProperty("hibernate.default_batch_fetch_size", "1000");
        properties.setProperty("hibernate.max_fetch_depth", "2");
        properties.setProperty("hibernate.generate_statistics", "false");
        properties.setProperty("hibernate.default_schema", "EDRIVE");

        properties.setProperty("hibernate.connection.CharSet", "utf8");
        properties.setProperty("hibernate.connection.characterEncoding", "utf8");
        properties.setProperty("hibernate.connection.useUnicode", "true");
        properties.setProperty("hibernate.connection.release_mode", "after_transaction");

        properties.setProperty("hibernate.jdbc.batch_size", "50");
        properties.setProperty("hibernate.jdbc.fetch_size", "500");
        properties.setProperty("hibernate.jdbc.use_scrollable_resultset", "false");

        properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
        properties.setProperty("hibernate.cache.use_query_cache", "true");
        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
        properties.setProperty("hibernate.cache.use_structured_entries", "false");

        properties.setProperty("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");

        return properties;
    }
}*/