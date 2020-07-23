package com.project.hibernate.dao;

import javax.transaction.Transactional;

import com.project.hibernate.entity.User;
import org.springframework.data.repository.CrudRepository;


public abstract interface IUserDAO

{
    public abstract User findByEmail(String email);
}