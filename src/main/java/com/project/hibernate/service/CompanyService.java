package com.project.hibernate.service;


import com.project.hibernate.entity.Company;

public interface CompanyService {

    Company getCompanyWithDepartments(int companyId);

    Company getCompanyWithDepartmentsAndEmployees(int companyId);

    Company getCompanyWithDepartmentsAndEmployeesAndOffices(int companyId);

    Company getCompanyWithCars(int companyId);
}