package com.project.hibernate.service;


import com.project.hibernate.entity.Task;
import com.project.hibernate.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> findByName(String name) {
        return taskRepository.findByName(name);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }
}