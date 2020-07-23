package com.project.hibernate.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment_child")
@Data
public class CommentChild implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "idcomment")
    private int idcomment;

    @Column(name = "user")
    private String user;

    @Column(name = "date")
    private String date;
}
