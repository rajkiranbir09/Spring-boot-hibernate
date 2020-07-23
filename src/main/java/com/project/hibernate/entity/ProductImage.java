package com.project.hibernate.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_images")
@Data
public class ProductImage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk")
    private Long pk;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "contentType", nullable = false)
    private String contentType;

    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "lob", nullable = false)
    private byte[] lob;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;


}
