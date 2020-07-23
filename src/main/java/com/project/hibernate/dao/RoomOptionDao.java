package com.project.hibernate.dao;


import com.project.hibernate.entity.RoomOption;
import org.springframework.data.repository.CrudRepository;


import java.util.Set;

public interface RoomOptionDao extends CrudRepository<RoomOption, Integer> {

    RoomOption findByName(String name);

}