package com.project.hibernate.service;

import com.project.hibernate.entity.TaskDetail;
import com.project.hibernate.repository.TaskDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskDetailService {

    @Autowired
    private TaskDetailRepository taskDetailRepository;

    public TaskDetail save(TaskDetail department) {
        return taskDetailRepository.save(department);
    }

    public TaskDetail findOne(Long id) {
        return taskDetailRepository.findOne(id);
    }

    public void delete(TaskDetail department) {
        taskDetailRepository.delete(department);
    }
}