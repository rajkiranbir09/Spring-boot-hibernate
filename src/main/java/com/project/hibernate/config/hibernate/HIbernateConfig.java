package com.project.hibernate.config.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;

//@Configuration
public class HIbernateConfig {
//    @Bean(name = "sessionFactory")
//    public SessionFactory getSessionFactory(@Qualifier("dataSource") DataSource dataSource) {
//        LocalSessionFactoryBuilder sessionBuilder = new
//                LocalSessionFactoryBuilder(dataSource);
//        sessionBuilder.scanPackages("com.project.hibernate.entity");
//        return sessionBuilder.buildSessionFactory();
//    }
}
