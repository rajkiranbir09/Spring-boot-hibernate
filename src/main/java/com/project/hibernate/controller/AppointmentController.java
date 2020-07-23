package com.project.hibernate.controller;

import java.util.List;

import com.project.hibernate.entity.Appointment;
import com.project.hibernate.entity.User;
import com.project.hibernate.repository.IUserRepository;
import com.project.hibernate.repository.impl.UserRepositoryImpl;
import com.project.hibernate.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/v1/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private IUserRepository iUserRepository;

    // GET ALL APPOINTMENT
    @GetMapping
    public List<Appointment> getAll(){
        return appointmentService.findAll();
    }

    // CONFIRM APPOINTMENT
    @RequestMapping("/{id}/confirm")
    public Appointment confirmAppointment(@PathVariable("id") int id) {
        return appointmentService.confirmAppointment(id);
    }


    // GET ALL APPOINTMENT BY ONE USER
    @GetMapping(value = "/users/{userId}")
    public List<Appointment> getAllByUser(@PathVariable("userId") int id) {
        User user = iUserRepository.findByUserId(id);
        return appointmentService.findAllByUser(user);

    }


    // CREATE ONE APPOINTMENT
    @PostMapping
    public void createAppointment(@RequestBody Appointment appointment){
        appointmentService.createAppointment(appointment);
    }

}
