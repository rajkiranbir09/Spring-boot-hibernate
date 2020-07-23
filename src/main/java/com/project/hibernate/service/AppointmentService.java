package com.project.hibernate.service;


import com.project.hibernate.entity.Appointment;
import com.project.hibernate.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public interface AppointmentService {
    // create one appointment by user
    Appointment createAppointment(Appointment appointment);

    // get all list of appointment in the company
    List<Appointment> findAll();

    // find appointment by id
    Appointment findAppointment(int id);

    // confirm appointment
    Appointment confirmAppointment(int id);
    // get all appointment by user
    List<Appointment> findAllByUser(User user);
}