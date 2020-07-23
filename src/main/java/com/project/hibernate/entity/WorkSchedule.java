package com.project.hibernate.entity;

import com.project.hibernate.entity.enums.WeekDay;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class WorkSchedule {
    @Id
    @GeneratedValue
    private long id;

    private Timestamp startTime;
    private Timestamp endTime;

    @Enumerated(EnumType.STRING)
    private WeekDay workDay;

    // getters and setters
}