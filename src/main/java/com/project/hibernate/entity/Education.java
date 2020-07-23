package com.project.hibernate.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_id")
    private int id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "degree")
    private String degree;

    @Column(name = "field")
    private String field;

//    @Embedded
//    private Period period;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "job_seeker_id")
//    private JobSeeker jobSeeker;

}
