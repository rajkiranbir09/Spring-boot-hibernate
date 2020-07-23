package com.project.hibernate.repository.impl;


import com.project.hibernate.entity.ProjectReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectreviewRepository extends JpaRepository<ProjectReview, Integer>{
    // find project review by id
    ProjectReview findById(int id);
    // find all project review in the company
    List<ProjectReview> findAll();


//    @Query (value = "SELECT p FROM projectreview AS p WHERE p.editionType = 'GOLD'")
//    List<ProjectReview> findByEdition();


    List<ProjectReview> findByReleaseDateNot(Date date);

    // find by release date before
    List<ProjectReview> findByReleaseDateBefore(Date date);
}
