package com.project.hibernate.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="Employee_Kin")
public class EmployeeKin {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="kin_id", unique=true)
    @NotNull
    private int id;

    //the field tracks employees to their kin
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee parentEmployee;

    @NotNull
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Column(name="last_name")
    private String lastName;

    @NotNull
    @Column(name="street_name")
    private String streetAddress;

    @NotNull
    @Column(name="city")
    private String cityAddress;

    @NotNull
    @Column(name="zipcode")
    private String zipCode;
}
