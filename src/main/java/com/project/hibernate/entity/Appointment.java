package com.project.hibernate.entity;


import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    private int appointmentId;

    @Column(nullable = true)
    private Date date;

    @Column(nullable = true)
    private String location;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private boolean confirmed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
