package com.project.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class Task {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "isComplete")
    private boolean isComplete;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    // RELATIONSHIP JOIN TABLE
    @OneToMany
    @JoinColumn(name="task_id", referencedColumnName="id")
    private List<TaskDetail> taskDetails;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "task_user", joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> users;



}
