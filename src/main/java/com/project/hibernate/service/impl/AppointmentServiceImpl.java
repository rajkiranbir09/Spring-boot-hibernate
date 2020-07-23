package com.project.hibernate.service.impl;

import com.project.hibernate.entity.Appointment;
import com.project.hibernate.entity.User;
import com.project.hibernate.repository.impl.AppointmentRepository;
import com.project.hibernate.service.AppointmentService;
import org.elasticsearch.search.aggregations.metrics.percentiles.hdr.InternalHDRPercentiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment findAppointment(int id) {
        return appointmentRepository.findByAppointmentId(id);
    }

    @Override
    public Appointment confirmAppointment(int id) {
        Appointment appointment = findAppointment(id);
        appointment.setConfirmed(true);// set confirm = true
        appointmentRepository.save(appointment);// save
        return appointment;
    }

    @Override
    public List<Appointment> findAllByUser(User user) {
        return appointmentRepository.findAllByUser(user);
    }
}
