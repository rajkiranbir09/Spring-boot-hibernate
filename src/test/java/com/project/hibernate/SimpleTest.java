package com.project.hibernate;

import com.sun.tools.javap.TypeAnnotationWriter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class SimpleTest {
//
//    private SessionFactory factory = null;

//    @BeforeClass
//    public void setup() {
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure()
//                .build();
//        factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//    }
//
//    @Test(dependsOnMethods = "saveMessage")
//    public void readMessage() {
//        try (Session session = factory.openSession()) {
//            List<TypeAnnotationWriter.Note> list = session.createQuery("from Message", Message.class).list();
//
//            assertEquals(list.size(), 1);
//            for (Message m : list) {
//                System.out.println(m);
//            }
//        }
//    }
    // save message

//    @Test
//    public void saveMessage() {
//        Message message = new Message("Hello, world");
//        try (Session session = factory.openSession()) {
//            Transaction tx = session.beginTransaction();
//            session.persist(message);
//            tx.commit();
//        }
//    }
}