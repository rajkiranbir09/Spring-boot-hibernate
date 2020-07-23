package com.project.hibernate.repository;


import com.project.hibernate.entity.Course;
import org.apache.catalina.Manager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findByCourseId(Integer id);

    // search by category
//    @Query("select c from Course c where c.categoryId like :categoryId")
//    public Page<Course> searchByCategory(@Param("categoryId") Integer categoryId, Pageable pageable);

    // find by topic id - topic name
    public List<Course> findByTopicId(String name);

}