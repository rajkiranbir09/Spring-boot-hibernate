package com.project.hibernate.entity;
import lombok.Data;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


// Entity Article -> User(role) -> create Article
@Entity
@Data
@Table(name="article")
//@Indexed
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="article_id",nullable = false)
    private int articleId;

//    @Field
    @Column(name="title",nullable = false)
    private String title;

//    @Field
    @Column(name="category")
    private String category;


//    @Field
    @Column(name = "content",nullable = false)
    private String content;


    /*@Field*/
    @Column(name = "description")
    private String description;

//    @Field
    @CreatedDate
    @Version
    @Column(name = "created_at")
    private Date createdAt;



}
