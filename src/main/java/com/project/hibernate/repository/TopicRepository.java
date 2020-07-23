package com.project.hibernate.repository;


import com.project.hibernate.entity.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface TopicRepository extends CrudRepository<Topic, Integer>{
    // find one topic by id
    Topic findById(int id);

}