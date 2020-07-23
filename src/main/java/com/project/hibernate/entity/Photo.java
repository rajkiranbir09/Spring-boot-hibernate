package com.project.hibernate.entity;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "photo")
@Data
public class Photo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long photo_id;

    private String photo_name;

    private String photo_description;

    private long photo_likes;

    private long photo_views;

    private Date upload_data = Calendar.getInstance().getTime();

    @Lob
    @Column(nullable = false, unique = true)
    private String photo_file;

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    private User user;

    @ManyToOne
    private Category category;

}