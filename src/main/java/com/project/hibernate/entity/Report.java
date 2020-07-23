package com.project.hibernate.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table
@Entity
public class Report {

    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "start_date", nullable = true)
    private Date startDate;
    @Column(name = "end_date", nullable = true)
    private Date endDate;
    @Column(name = "performer", nullable = true, length = 45)
    private String performer;
    @Column(name = "activity", nullable = true, length = 45)
    private String activity;
}
