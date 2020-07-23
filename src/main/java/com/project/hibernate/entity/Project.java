package com.project.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Entity
@Table(name = "project")
@Data
public class Project {

    @Id
    @SequenceGenerator(name = "PROJECT_ID_SEQ", sequenceName = "PROJECT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECT_ID_SEQ")
    private Integer id;

    private String name;

    private String content;

//
//    private Department department;

    @NotNull
    private Date deadline;

    @NotNull
    private String status;


    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "NO_SPRINTS", nullable = false)
    private Integer noSprints;

    @Column(name = "SPRINT_LENGTH_DAYS", nullable = false)
    private Integer sprintLengthDays;


    // ENTITY RELATIONSHIP
    @OneToOne
    private ProjectManager projectManager;
//
//    @ManyToMany
////    @JoinTable(name = "user_project", joinColumns = @JoinColumn(name = "project_id"),
////            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private Set<User> members = new HashSet<>();











}
