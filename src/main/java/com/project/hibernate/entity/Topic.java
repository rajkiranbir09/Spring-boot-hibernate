package com.project.hibernate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Topic {

    @Id
    private int id;

    private String name;

    private String description;


}
