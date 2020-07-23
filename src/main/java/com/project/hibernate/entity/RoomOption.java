package com.project.hibernate.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

// room option
@Entity
@Data
@Table(name = "additional_options")
public class RoomOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    // RELATIONSHIP TABLE
    @ManyToMany(mappedBy = "roomOptions")
    private List<Room> rooms;

}
