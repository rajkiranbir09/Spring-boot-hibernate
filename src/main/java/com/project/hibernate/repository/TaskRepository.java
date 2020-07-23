package com.project.hibernate.repository;

import com.project.hibernate.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task,Long> {

    // find task by name
    public Optional<Task> findByName(@Param("name") String name);
}