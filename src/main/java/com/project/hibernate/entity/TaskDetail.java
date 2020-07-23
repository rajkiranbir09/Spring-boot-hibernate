package com.project.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

import lombok.Data;

@Data
@Entity
@Table(name = "task_detail")
public class TaskDetail {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private int time;
}
