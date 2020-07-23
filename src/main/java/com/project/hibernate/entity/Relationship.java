package com.project.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

import lombok.Data;

@Data
@Entity
@Table
public class Relationship implements Serializable {

    @Id
    @GeneratedValue
    private long Id;



    // RELATIONSHIP TABLE

    // User - follow
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "follower")
    private User follower;

    // User followed
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "followed")
    private User followed;
}
