package com.project.hibernate.repository;



import com.project.hibernate.entity.Post;
import com.project.hibernate.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
    // get all posts by tag
    Tag findById(int id);


}