package com.project.hibernate.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;



//@XmlRootElement
//@NamedQueries({
//        @NamedQuery(name = "Contact.findAll", query = "SELECT s FROM contact s")})
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
//        allowGetters = true)
@Entity
@Data
//@Indexed
@Table(name = "contact", uniqueConstraints = {
        @UniqueConstraint(columnNames = "contact_id"),
        @UniqueConstraint(columnNames = "contact_code") })
public class Contact implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "contact_id", unique = true, nullable = false)
    private int contactId;

    @Column(name = "contact_code", unique = true, nullable = false, length = 5)
//    @Field( analyze = Analyze.YES, store = Store.NO)
    private String contactCode;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String image;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @JsonIgnoreProperties
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "contact", cascade = CascadeType.ALL)
    private User user;

//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "contact_id",nullable = false)
//    private Integer contactId;
//
//    @Size(max = 255)
//    @Column(name = "name",nullable = false)
////    @NotBlank
//    private String name;
//
//    @NotNull
//    private String title;
//
//    @NotNull
//    private String content;
//
////    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
////    @ManyToOne(optional = false)
////    private User userId;
//
//    // CREATED DATE
//    @Column(nullable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreatedDate
//    private Date createdAt;
//
//    @Column(nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @LastModifiedDate
//    private Date updatedAt;
//

}