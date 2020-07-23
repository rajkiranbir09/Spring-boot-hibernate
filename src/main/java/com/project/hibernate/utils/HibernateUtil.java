package com.project.hibernate.utils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Class for Hibernate Utils
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static{
        try {

            sessionFactory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable e) {

            throw new ExceptionInInitializerError(e);

        }
    }

    // session
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutDown(){
        //closes caches and connections
        getSessionFactory().close();
    }
}