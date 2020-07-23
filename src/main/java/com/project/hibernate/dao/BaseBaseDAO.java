package com.project.hibernate.dao;


import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;



/**
 * Abstract class implement Dao interface. This class is responsible for
 * implementing all the method of Dao interface. This class call for perform
 * action on database.
 *
 * @param <T>
 *            the type of the value being boxed
 * @version 1.0
 */
@Repository
public abstract class BaseBaseDAO<T> implements Dao<T> {

//    @Autowired
    SessionFactory sessionFactory;

    // pass the Class of the type parameter into the constructor of the generic
    // type
    Class<T> typeParameterClass;

    private final Logger log = LoggerFactory.getLogger(BaseBaseDAO.class);


    public BaseBaseDAO() {
        super();
    }

    // Constructor of BaseDao class accepting Class of the type parameter of
    // generic type
    public BaseBaseDAO(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }


    public int insertRow(T t) throws HibernateException {
        Session session = getSession();
        session.saveOrUpdate(t);
        Serializable id = session.getIdentifier(t);
        return Integer.valueOf(id.toString());
    }


    @SuppressWarnings("unchecked")
    public List<T> getList(){

            Session session = getSession();
            @SuppressWarnings("unchecked")
            DetachedCriteria criteria = DetachedCriteria
                    .forClass(typeParameterClass);
            List<T> list = criteria.getExecutableCriteria(session).list();
            return (List<T>) list;


    }

    public T getRowById(int id)  {
        Session session = getSession();
        DetachedCriteria criteria = DetachedCriteria
                .forClass(typeParameterClass);
        criteria.add(Restrictions.eq("id", id));
        T t = (T) criteria.getExecutableCriteria(session).uniqueResult();

        return t;
    }

    public T getRowByName(String fieldName, String value) {
        Session session = getSession();
        DetachedCriteria criteria = DetachedCriteria
                .forClass(typeParameterClass);
        criteria.add(Restrictions.eq(fieldName, value));
        T t = (T) criteria.getExecutableCriteria(session).uniqueResult();
        return t;
    }

    public int updateRow(T t){

            Session session = getSession();
            session.saveOrUpdate(t);
            Serializable id = session.getIdentifier(t);
            return (Integer) id;


    }


    public int deleteRow(int id) throws HibernateException {
        Session session = getSession();
        @SuppressWarnings("unchecked")
        T t = (T) session.load(typeParameterClass, id);
        session.delete(t);
        Serializable ids = session.getIdentifier(t);
        return (Integer) ids;
    }

    protected Session getSession() throws HibernateException {
        return sessionFactory.getCurrentSession();
        // return sessionFactory.openSession();
    }

    // abstract public List<T> searchByUserName(String queryString) throws
    // ByanException ;
}
