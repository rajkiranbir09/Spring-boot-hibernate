package com.project.hibernate.repository;


import com.project.hibernate.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {



    Category findByCategoryId(Integer id);

    // find all
    List<Category> findAll();

    List<Category> findByNameIn(String[] names);



}
