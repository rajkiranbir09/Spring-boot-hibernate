package com.project.hibernate.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="upload")
@Data
public class Upload {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "upload_id")
    private int id;

    @Column(name = "data")
    private String data;
}
