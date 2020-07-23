package com.project.hibernate.controller;


import java.util.List;

import javax.validation.Valid;

import com.project.hibernate.entity.Department;
import com.project.hibernate.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@RestController
@CrossOrigin
@RequestMapping("/v1/api/departments")
public class DepartmentController {
    private static final Log logger = LogFactory.getLog(DepartmentController.class);

    @Autowired
    DepartmentRepository departmentRepository;

    @PostMapping
    public Department createDepartment(@Valid @RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @GetMapping
    public List<Department> listDepartment() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartment(@PathVariable(value = "id")  Integer id) {
        Department department = departmentRepository.findById(id);

        if(department == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(department);
    }

    @PutMapping("/{id:\\\\d+}")
    public ResponseEntity<?> updateDepartment(@PathVariable(value = "id")  Integer id,
                                              @Valid @RequestBody Department updateData) {
        Department department = departmentRepository.findById(id);

        if(department == null) {
            return ResponseEntity.notFound().build();
        }

        department.setName(updateData.getName());

        Department updatedDepartment = departmentRepository.save(department);

        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable(value = "id")  Integer id) {
        Department department = departmentRepository.findById(id);

        if(department == null) {
            return ResponseEntity.notFound().build();
        }

        departmentRepository.delete(department);

        return ResponseEntity.ok().build();
    }
}