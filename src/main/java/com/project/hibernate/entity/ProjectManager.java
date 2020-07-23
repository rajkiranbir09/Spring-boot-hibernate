package com.project.hibernate.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "projectmanager")
public class ProjectManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectmanager_id")
    private String projectmanagerId;


    @Column(name = "user_name")
    private String userName;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


}
