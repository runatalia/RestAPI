
package com.spring.rest.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.spring.rest")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("oracle.jdbc.OracleDriver");
            dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            dataSource.setUser("admin");
            dataSource.setPassword("123");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;

    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.spring.rest.entity");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
        hibernateProperties.setProperty("current_session_context_class", "true");
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;

    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
    }
