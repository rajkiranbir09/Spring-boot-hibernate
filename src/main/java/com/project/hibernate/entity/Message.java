package com.project.hibernate.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "message_table")
public class Message {
    @Id
    @GeneratedValue
    private Integer id;

    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    private String senderId;

    private String receiverId;

    private String messageId;
}
