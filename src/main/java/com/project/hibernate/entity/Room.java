package com.project.hibernate.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "category_id")
    private String roomCategory;

    @Column(name = "price")
    private Integer price;

    // RELATIONSHIP TABLE

    @ManyToMany
    @JoinTable(name = "room_options", joinColumns = {
            @JoinColumn(name = "room_id")}, inverseJoinColumns = {
            @JoinColumn(name = "option_id")
    })
    private List<RoomOption> roomOptions;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

}
