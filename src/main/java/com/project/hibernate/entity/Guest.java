package com.project.hibernate.entity;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "guest")
@Data
public class Guest implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "guest_id")
    protected Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_last_modified")
    protected Date modificationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created")
    protected Date creationDate;

    @Version
    @Column(name = "version")
    protected Integer version;

    @NotNull(message = "Name is required")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "Address is required")
    @Column(name = "address")
    private String address;

    @NotNull(message = "Phone is required")
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;


    // REFERENCE
    // Branch

//    @OneToOne(targetEntity=Guest.class, cascade={CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST})
//    @JoinColumn(name="guestbranch_id",referencedColumnName="guestbranch_id")
//    private String guestbranch_id;

    // VISIT
//    @Column(name = "id")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "guest", cascade = CascadeType.ALL)
    public List<Visit> visits;




}
