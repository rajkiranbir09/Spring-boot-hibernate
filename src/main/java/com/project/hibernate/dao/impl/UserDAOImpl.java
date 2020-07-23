package com.project.hibernate.dao.impl;

import com.project.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
@Transactional
public class UserDAOImpl {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private SessionFactory sessionFactory;

//    @Override
    public List<User> findByEmail(String email) {
        return this.sessionFactory.getCurrentSession()
                .createQuery("from user u where u.email = :email")
                .setString("email", email)
                .list();
    }
    public List<User> findByEmail1(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("findByEmail");
        logger.debug(query.list()+"");
        return query.list();
    }

    // Find user by name and email
    public List<User> findByEmailAndUsername(String email, String username) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createCriteria(User.class)
                .add(Restrictions.eq("email", email))
                .add(Restrictions.eq("name",username))
                .list();
    }
}