package com.project.hibernate.entity;


import lombok.Data;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="Sales_Order")
public class SalesOrder {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="sales_order_id", unique=true)
    @NotNull
    private int salesOrderId;

    /*
     * The date on which the order was placed
     */
    @Temporal(TemporalType.DATE)
    @Column(name="order_date")
    @NotNull
    private Date orderDate;

    /*
     * Time at which the order was recorded
     */
    @Temporal(TemporalType.TIME)
    @Column(name="order_time")
    @NotNull
    private Date orderTime;

    //Total cost of the sales order
    private int totalCost;

	/*
	 * This field maps customer to its sales order
	 * A sales order will have one customer, but a customer can have
	 * multiple sales order
	*/
	/*@ManyToOne
	@JoinColumn(name = "customer_Id")
	private Customer customer;*/

    /*
     * This field maps an employee that has assisted
     * in placing the sales order to the sales order. It is a
     * many to one mapping
     */
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
