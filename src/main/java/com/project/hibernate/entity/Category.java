package com.project.hibernate.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="category")
//@EntityListeners(AuditingEntityListener.class)
@Data
// @Indexed
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Document(indexName = "category",type = "categories",shards = 1, replicas = 0, refreshInterval = "-1")
public class Category implements Serializable{
    // id
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="category_id",nullable = false)
    @SequenceGenerator(name="seq1",sequenceName="HIB_SEQ")
//    @Field(index = FieldIndex.not_analyzed)
//    @Field
    private int categoryId;

    @Column(name="name")
    // @Field
//    @Field(type = FieldType.String)
    private String name;

    // @Field
    @Column(name="description")
    private String description;


    // RELATIONSHIP MAPPING
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "categories")
    private Set<ProjectReview> projectReviewSet;

    // Photos
    @OneToMany(mappedBy = "category")
    private List<Photo> photos;

    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern="yyyy-MM-dd)
    private Date create_at;



}