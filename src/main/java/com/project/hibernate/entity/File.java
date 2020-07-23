package com.project.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;



import lombok.Data;

@Data
@Entity
@Table
public class File implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "file_id")
    private int fileId;

    @Column(name="file")
    private byte[] file;

    private String custom;

    private String make;

    private int year;

    private int redlineSpeed;

    private float maxCapacity;

    private Date lastModifiedDate;

}
