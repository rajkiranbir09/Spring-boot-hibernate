package com.project.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id", updatable = false, nullable = false)
    private int id;

    private String registrationNumber;



    // RELATIONSHIP


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Company company;

}
