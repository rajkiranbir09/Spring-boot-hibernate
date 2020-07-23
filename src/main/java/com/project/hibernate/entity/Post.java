package com.project.hibernate.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.TABLE;

@Data
@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
//    @TableGenerator(name="tablegen",
//            table="ID_TABLE",
//            pkColumnName="ID",
//            valueColumnName="NEXT_ID")
//    @GeneratedValue(strategy=TABLE,generator="tablegen")
    private Integer id;

    @NotBlank(message = "Title can't be empty.")
    @Size(min = 3, message = "A title must be at least 3 characters.")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Body can't be empty")
    @Column(nullable = false, length = 3000)
    private String body;

    // transient field

    @Transient
    private String shortText;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;

    @Column(nullable = true, name="image_url")
    private String imageUrl;

    @ManyToOne
    @JsonManagedReference
    private User user;

    @ManyToMany
    @JoinTable(
            name="post_tags",
            joinColumns={@JoinColumn(name="post_id")},
            inverseJoinColumns={@JoinColumn(name="tag_id")}
    )
    private List<Tag> tags;




    // RELATIONSHIP WITH OTHER TABLE
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "post_categorization",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> categorization = new ArrayList<>();



    @ManyToOne
    @JoinColumn(name="department_id")
    Department department;

}
