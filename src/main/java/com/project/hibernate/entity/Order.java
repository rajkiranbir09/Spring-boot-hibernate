package com.project.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.hibernate.entity.enums.OrderStatus;
import lombok.Data;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;


    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birthdayDate")
    private Date birthdayDate;

    @Column(name = "deliveryAddress")
    private String deliveryAddress;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "orders_products",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    @JsonIgnoreProperties("orders")
    private List<Product> products;


    @Column(name = "deliveryDate")
    private Date deliveryDate;

    @Column(name = "totalCost")
    private Double totalCost;

    @Column(name = "orderStatus")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
