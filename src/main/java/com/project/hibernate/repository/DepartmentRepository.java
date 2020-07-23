package com.project.hibernate.repository;


import com.project.hibernate.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // find by id
    Department findById(Integer id);

    Optional<Department> findByName(@Param("name") String name);
}