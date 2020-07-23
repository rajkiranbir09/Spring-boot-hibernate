package com.project.hibernate.service;



import com.project.hibernate.entity.Department;
import com.project.hibernate.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> findByName(String name) {
        return departmentRepository.findByName(name);
    }

    public void delete(Department department) {
        departmentRepository.delete(department);
    }
}
