package com.project.hibernate.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "guestbranch")
public class GuestBranch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="guestbranch_id",nullable = false)
    private int guestbranchId;

    @Column(name = "branch_no")
    private String branchNo;

    @Column(name = "name")
    @NotNull(message = "Branch Name is required")
    @Size(min = 4, message = "Minimum Length is Four Character")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Use letters only please")
    private String name;
}
