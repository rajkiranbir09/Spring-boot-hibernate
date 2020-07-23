package com.project.hibernate.dao;

import java.util.List;
import org.hibernate.HibernateException;


public interface Dao<T> {

    // insert
    public int insertRow(T t) throws HibernateException;

    // get all
    public List<T> getList() ;

    // get one by id
    public T getRowById(int id) ;

    // update one by id
    public int updateRow(T t) ;

    // delete row
    public int deleteRow(int id) ;

}