package com.project.hibernate.service;


import com.project.hibernate.dao.RoomOptionDao;
import com.project.hibernate.entity.RoomOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

@Service
public class RoomOptionService {

    @Autowired
    private RoomOptionDao roomOptionDao;

    public List<RoomOption> findAll () {
        return (List<RoomOption>) roomOptionDao.findAll();
    }

    public RoomOption findById (int id) {
        return roomOptionDao.findOne(id);
    }

}