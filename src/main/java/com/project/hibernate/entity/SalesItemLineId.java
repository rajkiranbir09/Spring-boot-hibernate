package com.project.hibernate.entity;


import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class SalesItemLineId implements Serializable {

    private long salesOrderId;

    private int menuItemId;


}
