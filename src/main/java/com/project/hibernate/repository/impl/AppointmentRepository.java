package com.project.hibernate.repository.impl;


import java.util.List;

import com.project.hibernate.entity.Appointment;
import com.project.hibernate.entity.User;
import org.springframework.data.repository.CrudRepository;



public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    // find all ongoing appointment in the company
    List<Appointment> findAll();

    // get all appointments by user
    List<Appointment> findAllByUser(User user);

    // find one by id
    Appointment findByAppointmentId(Integer id);
}