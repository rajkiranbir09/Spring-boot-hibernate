package com.project.hibernate.repository;



import com.project.hibernate.entity.Subcategory;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface SubcategoryRepository extends PagingAndSortingRepository<Subcategory, Integer> {

}