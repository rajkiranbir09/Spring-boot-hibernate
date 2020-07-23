package com.project.hibernate.entity;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "visit")
@Data
public class Visit implements Serializable {
    @Id
    @Column(name = "visit_id", nullable = false)
    private int id;

//    private Employee employee;


//    @Basic
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date date;

//    @Basic
    @Column(name = "status", nullable = false, length = 2147483647)
    @Type(type = "numeric_boolean")
    private Boolean status;


    // REF REPLATIONSHIP
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

}





















