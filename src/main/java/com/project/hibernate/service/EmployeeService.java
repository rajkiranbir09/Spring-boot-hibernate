package com.project.hibernate.service;


import com.project.hibernate.entity.Employee;
import com.project.hibernate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }
    // get all employees by department id
    public List<Employee> getEmployeesByDept(String id) {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findEmployeesByDepartment(id)
                .forEach(employees::add);
        return employees;
    }

    public Employee getEmployee(String id) {

        return employeeRepository.findOne(Integer.valueOf(id));
    }

    public void addEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    public void deleteEmployee(String id) {

        employeeRepository.delete(Integer.valueOf(id));
    }
}