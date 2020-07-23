package com.project.hibernate.service;


import com.project.hibernate.entity.Balance;
import com.project.hibernate.entity.User;

public interface BalanceService {
    // find balance by user
    public Balance findBalance(User user);

    // save balance by user
    public void saveBalance(Balance balance);
}