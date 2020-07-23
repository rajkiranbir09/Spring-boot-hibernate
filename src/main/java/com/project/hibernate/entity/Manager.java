package com.project.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name="manager")
@PrimaryKeyJoinColumn(name="employee_id",referencedColumnName="employee_id")
public class Manager {

    @Column(name="car_allowance")
    private int carAllowance;

    @Column(name="bonus_allowance")
    private int bonusAllowance;

}
