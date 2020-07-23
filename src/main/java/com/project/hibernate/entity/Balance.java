package com.project.hibernate.entity;

import javax.persistence.*;


import lombok.Data;

@Data
@Entity
@Table(name = "balance")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "balance_id")
    private int id;



    @Column(name = "balance")
    private int balanceAmount;


    // RELATIONSHIP REF
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
