package com.project.hibernate.dao;


import com.project.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;



@Repository
public class UserUserDao extends BaseBaseDAO<User> implements Dao<User> {

    public UserUserDao() {
        super(User.class);
    }



}