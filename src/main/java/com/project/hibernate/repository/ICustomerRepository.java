package com.project.hibernate.repository;


import com.project.hibernate.entity.Customer;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer,Long> {

    Optional<Customer> findById(Long id);
}