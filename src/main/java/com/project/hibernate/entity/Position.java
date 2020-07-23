package com.project.hibernate.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "position_id")
    private int id;

    @OneToMany(fetch= FetchType.EAGER, mappedBy = "position")
    private Set<User> persons;


}
