package com.project.hibernate.repository;



import com.project.hibernate.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findEmployeesByDepartment(String deptId);
}