package com.project.hibernate.dao.impl;

import com.project.hibernate.entity.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class ProjectDAOImpl {

    @PersistenceContext
    private EntityManager entityManager;

    // GET ALL PROJECTS FOR DASHBOARD
    public List<Project> getAllProjectList() {
        return entityManager.createQuery("from Project").getResultList();
    }
    // SAVE NEW PROJECT TO DATABASE
    public Project create(Project project) {
        // validation
        if(project == null){

        }else {
            entityManager.persist(project);
        }


        return project;
    }

    // UPDATE NATIVE - IMPORTANT
//    public int updateNative(String projectName,String projectContent,int userId,String projectStatus,String deadLine,int projectId) {
//        String queryString = "UPDATE tasks SET taskName = ?,taskContent = ?,userId = ?,taskStatus = ?,resultDate = ? WHERE taskId = :taskID";
//
//        Query query = entityManager.createNativeQuery(queryString, Task.class);
//        query.setParameter(1, taskName);
//        query.setParameter(2, taskContent);
//        query.setParameter(3, userId);
//        query.setParameter(4, taskStatus);
//        query.setParameter(5, resultDate);
//        query.setParameter("taskID", taskId);
//
//
//        return query.executeUpdate(); }

    // DELETE ONE PROJECT FROM DATABASE
    public void delete(Project project) {
        if (entityManager.contains(project))
            entityManager.remove(project);
        else
            entityManager.remove(entityManager.merge(project));
        return;
    }
    // FIND ONE PROJECT BY ID
    public Project getById(long projectId) {
        return entityManager.find(Project.class, projectId);
    }



//    /**
//     * Login Return the user having the passed email.
//     */
//    public User getByEmail(String email) {
//        return (User) entityManager.createQuery(
//                "from User where email = :email")
//                .setParameter("email", email)
//                .getSingleResult();
//    }



    // UPDATE PROJECT
    public void update(Project project) {
        entityManager.merge(project);
        return;
    }


}
