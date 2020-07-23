package com.project.hibernate.dao;


import com.project.hibernate.entity.Employee;
import com.project.hibernate.entity.EmployeeKin;
import com.project.hibernate.entity.Manager;

import java.util.List;



public interface IEmployeeDAO {

    List<Object[]> getAllEmployeesNames();

    Employee getEmployeeById(long employeeId);

    void addEmployee(Employee employee);

    Employee updateEmployee(Employee employee);
    EmployeeDAOImpl
    void deleteEmployee(long employeeId);

    boolean employeeExists(String firstName, String lastName, String ssn);

    List<EmployeeKin> getAllEmployeeKins(long employeeId);

    void addManager(Manager manager);

    Manager getManagerById(long employeeId);

    void deleteManager(long employeeId);
}