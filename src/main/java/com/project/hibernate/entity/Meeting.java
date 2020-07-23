package com.project.hibernate.entity;


import java.util.List;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@Entity
@Table(name="meeting")
//@SequenceGenerator(name="seqId",sequenceName="SEQ_MEETING")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meeting_id")
    private int id;

    @Column
    private String name;


    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "meeting_department",
            joinColumns = {@JoinColumn(name = "meeting_id" )},
            inverseJoinColumns = {@JoinColumn(name = "department_id")})
    private List<Department> departmentList;



}