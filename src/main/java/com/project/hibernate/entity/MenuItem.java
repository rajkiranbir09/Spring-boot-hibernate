package com.project.hibernate.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Entity;
import javax.persistence.Table;

// Entity for saving lunch menu from the portal


// Enum for menu item
enum MenuItemType {
    Entry, Dessert, Appetizer
}


@Data
@Entity
@Table
public class MenuItem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="item_id", unique=true)
    @NotNull
    private int id;

    @NotNull
    @Column(name="item_name",unique = true)
    private String itemName;

    @NotNull
    @Column(name="item_price")
    private int itemPrice;

    @NotNull
    @Column(name="description")
    private String decription;

    @NotNull
    @Column(name="item_type")
    @Enumerated(EnumType.STRING)
    private MenuItemType itemType;

}
