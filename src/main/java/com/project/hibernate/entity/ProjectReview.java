package com.project.hibernate.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.project.hibernate.entity.enums.EditionType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "projectreview")
public class ProjectReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectreview_id")
    private int projectreviewId;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT", length = 1000)
    private String description;


    @Column(name = "edition_type")
    private EditionType editionType;


    @Column(name = "release_date")
    private Date releaseDate;



    // RELATIONSHIP MAPPING

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "projectreview_category",
            joinColumns = @JoinColumn(name = "projectreview_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
