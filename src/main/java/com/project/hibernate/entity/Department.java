package com.project.hibernate.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@Data
@Entity
@Table(name = "department")
@Audited
//@SequenceGenerator(name="seqId",sequenceName="SEQ_DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @Column(name = "contact_phone", nullable = false)
    private String contactPhone;



    // RELATIONSHIP MAPPING



    @OneToMany(orphanRemoval = true, mappedBy = "department")
    @OrderBy("post_id")
    private List<Post> posts = new ArrayList<>();

    // employee - aka .user
    @OneToMany(mappedBy="department",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference
    private Set<User> employees = new HashSet<>();

    @ManyToMany(mappedBy="departmentList")
    private List<Meeting> meetingList;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    // Office
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Office> offices = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Company company;

//    @OneToMany
//    @JoinColumn(name="user_department", referencedColumnName="id")
//    private List<User> users;








}
