package com.project.hibernate.entity;

import lombok.Data;

@Data
public class Sprint {

    private Integer id;

    private String startDate;

    private String endDate;

    private Integer number;

    private String status;
}
