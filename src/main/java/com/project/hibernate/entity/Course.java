package com.project.hibernate.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "course")
@Table(name="course")
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"},
        allowGetters = true)
public class Course implements Serializable{


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="course_id",nullable = false)
    private int courseId;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id",
            insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Category category;

    // topic

    @ManyToOne
    private Topic topic;





}