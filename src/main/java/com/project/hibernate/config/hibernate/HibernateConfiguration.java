package com.project.hibernate.config.hibernate;

import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Environment;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


//@Configuration
//@EntityScan("com.project.hibernate.entity")
//@EnableTransactionManagement
//@PropertySource("classpath:application.properties")
//@EnableJpaRepositories(basePackages="com.project.hibernate.repository")
//public class HibernateConfiguration {
//
//    // CONFIG data source
//    @Value("${spring.datasource.driverClassName}") String
//            driverClassName;
//    @Value("${spring.datasource.url}") String url;
//    @Value("${spring.datasource.username}") String username;
//    @Value("${spring.datasource.password}") String password;
//
//    @Bean(name = "dataSource")
//    public DataSource getDataSource() {
//        DataSource dataSource = DataSourceBuilder
//                .create()
//                .username(username)
//                .password(password)
//                .url(url)
//                .driverClassName(driverClassName)
//                .build();
//        return dataSource;
//    }
//
//    // SESSION FACTORY
//    @Bean(name = "sessionFactory")
//    public SessionFactory getSessionFactory(@Qualifier("dataSource") DataSource dataSource) {
//        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
//        sessionBuilder.scanPackages("com.project.hibernate.entity");
//        return sessionBuilder.buildSessionFactory();
//    }
//
//    // HIBERNATE TRANSACTION MANAGER
//
//    @Bean(name = "transactionManager")
//    public HibernateTransactionManager getTransactionManager(
//            SessionFactory sessionFactory) {
//        HibernateTransactionManager transactionManager = new
//                HibernateTransactionManager(sessionFactory);
//        return transactionManager;
//    }
//
////    @Bean
////    SessionFactory sessionFactory(EntityManagerFactory emf) {
////
////    }
//
//
//



//}

//@Configuration
//@EnableTransactionManagement
//@PropertySource({"classpath:application.properties"})
public class HibernateConfiguration {

//    @Autowired
//    private Environment environment;
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory(){
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan(new String[]{"com.base","com.base.model"});
//        sessionFactory.setMappingResources(new String[]{"Employee.hbm.xml"});
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }
//
//    @Bean
//    public Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
//        properties.put("hibernate.show_sql", environment.getRequiredProperty("hiberante.show_sql"));
//        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
//        return properties;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
//        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
//        dataSource.setUsername(environment.getRequiredProperty("jdbc.userName"));
//        dataSource.setUsername(environment.getRequiredProperty("jdbc.password"));
//        return dataSource;
//    }
//
////    @Bean
////    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){
////        return hemf.getSessionFactory();
////    }

}
