package com.project.hibernate.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
public class Node {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToOne(cascade= CascadeType.ALL)
    private Node parent;

    @OneToMany(mappedBy="parent")
    private Collection<Node> children = new ArrayList<Node>();
    // getters and setters

}
