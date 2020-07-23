package com.project.hibernate.repository;


import com.project.hibernate.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import sun.net.www.content.text.Generic;

import javax.annotation.Generated;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByFirstName(String FirstName);

    Customer findByNip(String nip);

    // Native Query
    @Query(value = "SELECT * FROM customer WHERE first_name = ?1", nativeQuery = true)
    Customer findByFirstNameNativeQ (String firstName);

    // JPQL Query
    @Query(value = "SELECT c FROM Customer c WHERE c.firstName =:firstName")
    Customer findByFirstNameJPQL(@Param("firstName") String firstName);

    // HQL Query
    @Query(value = "SELECT p FROM #{#entityName} p WHERE p.firstName like ?1% ")
    Customer findByFirstNameHQL(String firstName);

    // Procedure
    @Procedure(procedureName = "procesDocumentCustomerByNIP", outputParameterName = "ROLA")
    String procesDocumentCustomerByNIP();




}