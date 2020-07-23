package com.project.hibernate.repository;


import com.project.hibernate.entity.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
}