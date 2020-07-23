package com.project.hibernate.service.impl;


import java.util.List;

import com.project.hibernate.dao.UserUserDao;
import com.project.hibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl {

    @Autowired
    UserUserDao userDao;

    public int insertRow(User t) {
        return userDao.insertRow(t);
    }

    public List<User> getList() {
        return userDao.getList();
    }

    public User getRowById(int id) {
        return userDao.getRowById(id);
    }

    public int updateRow(User t){
        return userDao.updateRow(t);
    }

    public int deleteRow(int id) {
        return userDao.deleteRow(id);
    }

    public void saveUser(User u) {
        if(u.getUserId() == 0){
//            u.setEnabled(1);
            insertRow(u);
        }else{
            updateRow(u);
        }


    }

    public User getRowByName(String columnName, String value) {
        return userDao.getRowByName(columnName, value);
    }

}