package com.project.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class UserRank {
    @GeneratedValue
    @Id
    @Column(name = "userank_id")
    private int id;

    @NotNull
    private String name;

    @OneToMany
    @JoinColumn(name="userrank_id")
    private List<User> users;

}
