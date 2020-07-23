package com.project.hibernate.dao.impl;


import java.util.List;

import com.project.hibernate.dao.MeetingDAO;
import com.project.hibernate.entity.Meeting;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class MeetingDAOImpl {

    protected SessionFactory sessionFactory;

//    @Override
//    public Meeting insert(Meeting t) {
//        return (Meeting) insertEntity(t);
//    }
//
//    @Override
//    public Meeting update(Meeting t) {
//        return (Meeting) updateEntity(t);
//    }
//
//    @Override
//    public boolean delete(Meeting t) {
//        t = (Meeting) deleteEntity(t);
//        return t.isDeleted();
//    }


    public List<Meeting> getAllList() {
        String sql="select meeting from meeting meeting where meeting.deleted=false";
        Query query= sessionFactory.openSession().createQuery(sql);
        return query.getResultList();
    }

}