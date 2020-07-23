package com.project.hibernate.dao.impl;



import com.project.hibernate.entity.Guest;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;


    public Guest find(Integer id) {

        final EntityManager em = entityManager;
        try {
            return em.find(Guest.class, id);
        } catch (RuntimeException e) {

            return null;
        }
    }

//    public Guest save(String name, String address, String phone) {
//        final EntityManager em = entityManager;
//        final EntityTransaction trx = em.getTransaction();
//
//        Guest person = new Guest(name, address, phone);
//
//        try {
//
//            trx.begin();
//            em.persist(person);
//            trx.commit();
//            return person;
//
//        } catch (RuntimeException e) {
//            if (trx != null && trx.isActive()) {
//                trx.rollback();
//            }
//
//            return null;
//        }
//    }
//
//    public List<Guest> findName(String name) {
//        if(!StringUtils.isEmpty(name)){
//            name = name + "%";
//        } else return new ArrayList<>();
//        final EntityManager em = entityManager;
//        try {
//            Query query = em.createQuery("SELECT p FROM guest p WHERE p.name LIKE :NAME");
//            query.setParameter("NAME", name);
//            return (List<Guest>) query.getResultList();
//        } catch (RuntimeException e) {
//
//            return null;
//        }
//    }
}
