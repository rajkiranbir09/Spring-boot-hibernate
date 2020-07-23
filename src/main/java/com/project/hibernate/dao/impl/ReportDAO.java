package com.project.hibernate.dao.impl;



import com.project.hibernate.entity.Report;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * layer for interaction with models and performing DB operations
 */
@Repository
public class ReportDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // GET ALL TASKS FROM DATE TO DATE
    public List<Report> getAllTasks(Date startDate, Date endDate) {
        // create query : where startdate and enddate
        return entityManager.createQuery("from report " +
                "where (start_date >= :startDate) AND " +
                "(end_date <= :endDate)", Report.class)
                .setParameter("startDate", startDate, TemporalType.DATE)
                .setParameter("endDate", endDate, TemporalType.DATE)
                .getResultList();
        // set param: startDate and endDate -> getResultList
    }

    // GET ALL TASK
    public List<Report> getAllTasks(String performer, Date startDate, Date endDate) {
        return entityManager.createQuery(
                "from report " +
                        "where (performer LIKE :custPerformer) AND " +
                        "(start_date >= :startDate) AND " +
                        "(end_date <= :endDate)", Report.class)
                .setParameter("custPerformer", performer)
                .setParameter("startDate", startDate, TemporalType.DATE)
                .setParameter("endDate", endDate, TemporalType.DATE)
                .getResultList();
    }

    // GET PERFORMERS
    public List<String> getPerformers() {
        return entityManager.createQuery("SELECT distinct performer FROM report", String.class).getResultList();
    }
}