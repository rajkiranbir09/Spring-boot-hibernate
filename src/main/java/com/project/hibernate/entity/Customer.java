package com.project.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;


@Table
@Entity
//@Data
//@RequiredArgsConstructor
@RedisHash("customers")
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    // version
    @Version
    private int version;

}
