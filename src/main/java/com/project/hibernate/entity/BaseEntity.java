package com.project.hibernate.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;


@MappedSuperclass
public abstract class BaseEntity {
//     extends AbstractPersistable<Integer> {

    private static final long serialVersionUID = -9214388576700297054L;

    @Id
    @GeneratedValue(generator="seqId",strategy=GenerationType.SEQUENCE)
    @Column(name="id")
    protected int id;

    @Column(name="INSERT_DTTM")
    protected Date insertDttm;

    @Column(name="VERSION_DTTM")
    protected Date versionDttm;

    @Column(name="DELETED")
    protected boolean deleted;

    @Column(name = "created_at")
    private Date createdDate;




}