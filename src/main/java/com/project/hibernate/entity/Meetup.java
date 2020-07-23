package com.project.hibernate.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "meetup ")
public class Meetup {

    @Id
    @GeneratedValue
    @Column(name = "meetup_id")
    private Integer id;

    @NotNull
    private String location;

    @DateTimeFormat
    private LocalDate date;

    @DateTimeFormat
    private LocalTime time;

    @Column(name = "topic")
    @NotNull
    private String topic;


    // ENTITY RELATIONSHIP

    // organiser
    @ManyToOne
    private User organizer;

    @ManyToMany
    @JoinTable(name = "user_meetups_attending", joinColumns = @JoinColumn(name = "meetup_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> attendees = new ArrayList<>();

    @Column(name = "description")
    private String description;

}
