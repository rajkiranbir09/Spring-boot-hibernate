package com.project.hibernate.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "ResturantTable")
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "table_id", unique = true)
    @NotNull
    private int id;

    @Column(name = "seats")
    @NotNull
    private int seats;

    @Column(name = "isReserved")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @NotNull
    private int isReserved;

    private int invoiceId;

    private int totalTableCount = 0;

    private static final int MAX_TABLE_COUNT = 8;

}
