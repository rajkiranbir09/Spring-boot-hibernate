package com.project.hibernate.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

public class PrimaryAccount {

    private Long id;

    private int accountNumber;

    private BigDecimal accountBalance;



}
